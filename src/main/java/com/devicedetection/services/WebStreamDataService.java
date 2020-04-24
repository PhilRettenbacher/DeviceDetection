package com.devicedetection.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devicedetection.dao.CanvasjsChartDao;
import com.devicedetection.dao.GeraetEventRepository;
import com.devicedetection.dao.GeraetRepository;
import com.devicedetection.dao.WebStreamDataDao;
import com.devicedetection.model.ConsumptionPointTime;
import com.devicedetection.model.FullConsumptionData;
import com.devicedetection.model.Geraet;
import com.devicedetection.model.GeraetEvent;
 
@Service
public class WebStreamDataService  {
 
	@Autowired
	private WebStreamDataDao webStreamDataDao;

    @Autowired
    private GeraetRepository geraetRepository;

    @Autowired
    private GeraetEventRepository geraetEventRepository;

    public int threshold = 2000;
    public int slopeThreshold = 200;

	public void setWebStreamDataDao(WebStreamDataDao webStreamDataDao) {
		this.webStreamDataDao = webStreamDataDao;
	}
 
	public List<List<Map<Object, Object>>> getWebStreamData(List<String> names) {



        List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
        List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
        
        FullConsumptionData fullConsumptionData = webStreamDataDao.getStreamData();
        Map<Object,Object> map = null;
        
        for(int i = 0; i<fullConsumptionData.values.length; i++)
        {
            names.add(fullConsumptionData.values[i]);
            list.add(new ArrayList<Map<Object,Object>>());
        }

        for(int i = 0; i<fullConsumptionData.data.size(); i++)
        {
            for(int j = 0; j<fullConsumptionData.values.length;j++)
            {
                map = new HashMap<Object,Object>(); 
                map.put("x", fullConsumptionData.data.get(i).time); 
                map.put("y", fullConsumptionData.data.get(i).values[j]);
                list.get(j).add(map);
            }

            
        }
        
        names.add("Durchschnitt");
        List<Map<Object,Object>> vals2 = new ArrayList<Map<Object,Object>>();
        list.add(vals2);
        int[] avgs = new int[fullConsumptionData.data.size()];
        for (int i = 0; i<fullConsumptionData.data.size(); i++)
        {
            int avg = 0;
            for(int j = i-7; j<=i+7; j++)
            {
                int val = j;
                if(j<0)
                    val=0;
                if(j>=fullConsumptionData.data.size())
                    val = fullConsumptionData.data.size()-1;
                avg +=fullConsumptionData.data.get(val).values[0];
            }
            avg = avg / 15;
            avgs[i]=avg;
            map = new HashMap<Object,Object>(); 
            map.put("x", fullConsumptionData.data.get(i).time); 
            map.put("y", avg);
            vals2.add(map);
        }

        //Map<Long, GeraetEvent> gereatMap = new HashMap<Long, GeraetEvent>();
        List<GeraetEvent> events = getEvents();

        
        System.out.println(fullConsumptionData.data.get(0).time.toString());

        int currVal2 = 0;

        for(GeraetEvent event : events)
        {
            currVal2 += event.getGeraet().getVerbrauch() * (event.getEventTyp() ? 1:-1);
        }
        int countdevice = 0;
        long last = 0;
        if(events.size()>0)
            last = events.get(events.size()-1).getDatum().getTime();
        for(int i = 0; i<avgs.length;i++)
        {
            if(last<fullConsumptionData.data.get(i).time.getTime())
            {
            
                int diff = Math.abs(currVal2 - avgs[i]);
                int slope = 0;
                if(i>0)
                    slope = Math.abs(avgs[i]-avgs[i-1]);
                boolean mode = currVal2<avgs[i];
                if(diff>threshold && slope<slopeThreshold)
                {
                    System.out.println("Device detected: " + fullConsumptionData.data.get(i).time.toString());
                    currVal2 = avgs[i];
                    Geraet geraet = new Geraet("Geraet-" + countdevice, "beschreibung", 0, diff);
                    geraetRepository.save(geraet);
                    geraetEventRepository.save(new GeraetEvent(new Timestamp(fullConsumptionData.data.get(i).time.getTime()), mode, geraet));
                    countdevice++;
                }
            }
        }
        events = getEvents();
        names.add("Erkannte Geräte");

        List<Map<Object,Object>> vals = new ArrayList<Map<Object,Object>>();
        list.add(vals);
        
        int currVal = 0;
        long startTime = fullConsumptionData.data.get(0).time.getTime();

        boolean first = true;
        for(GeraetEvent event : events)
        {
            int oldVal = currVal;
            currVal += event.getGeraet().getVerbrauch() * (event.getEventTyp() ? 1:-1);
            
            if(event.getDatum().getTime()>=startTime)
            {
                if(first)
                {
                    first=false;
                    map = new HashMap<Object,Object>();
                    map.put("x", new Date(startTime));
                    map.put("y", oldVal);
                    vals.add(map);
                }
                map = new HashMap<Object,Object>();
                map.put("x", event.getDatum());
                map.put("y", oldVal);
                vals.add(map);
                map = new HashMap<Object,Object>();
                map.put("x", event.getDatum());
                map.put("y", currVal);
                vals.add(map);
            }
        }


        //list.add(dataPoints1);
        return list;
    }

    List<GeraetEvent> getEvents()
    {
        List<GeraetEvent> events = new ArrayList<GeraetEvent>();

        for(Geraet geraet : geraetRepository.findAll())
        {
            for (GeraetEvent event : geraetEventRepository.findByGeraet(geraet))
            {
                events.add(event);
            }
        }

        //gereatMap = gereatMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(e->e.getKey(), e->e.getValue(), (e1, e2)->e2, HashMap::new));
        
        Collections.sort(events, (GeraetEvent a, GeraetEvent b)->Long.compare(a.getDatum().getTime(), b.getDatum().getTime()));
        return events;
    }
}
