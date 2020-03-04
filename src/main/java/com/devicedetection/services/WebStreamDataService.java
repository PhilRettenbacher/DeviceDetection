package com.devicedetection.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devicedetection.dao.CanvasjsChartDao;
import com.devicedetection.dao.WebStreamDataDao;
 
@Service
public class WebStreamDataService  {
 
	@Autowired
	private WebStreamDataDao webStreamDataDao;


	public void setWebStreamDataDao(WebStreamDataDao webStreamDataDao) {
		this.webStreamDataDao = webStreamDataDao;
	}
 
	public List<List<Map<Object, Object>>> getWebStreamData() {

        List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
        List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();

        List<Integer> data = webStreamDataDao.getStreamData();
        Map<Object,Object> map = null;
        for(int i = 0; i<data.size(); i++)
        {
            map = new HashMap<Object,Object>(); map.put("x", i); map.put("y", data.get(i));dataPoints1.add(map);
        }
        list.add(dataPoints1);
        return list;
    }    
}
