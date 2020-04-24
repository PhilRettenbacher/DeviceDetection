package com.devicedetection.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsumptionData
{
    static String urlText = "http://80.120.42.246:82/androidapi/api/gesamtverbrauch";
    static List<ConsumptionPointTime> consumptionData = new ArrayList<ConsumptionPointTime>();
    static RequestThread request;
	public static List<ConsumptionPointTime> getConsumptionData() {
		return consumptionData;
    }
    public static String[] delimiters = new String[] {"wertGesamt", "wertTheorie", "wertWerkstatt"};
    
    public static void initialize()
    {
        request = new RequestThread(urlText);
        request.start();
    }
}
class RequestThread extends Thread
{
    String urlText;
    //String regex = "tagesVerbrauch\":\"\\d+";
    
    String timeDelimiter = "time";
    RequestThread (final String urlText)
    {
        this.urlText = urlText;
    }

    public void run()
    {
        URL url;
		try {
			url = new URL(urlText);



            while(true)
            {
                final HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                final int status = con.getResponseCode();

                final BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
                String inputLine;
                final StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }   
                in.close();
                //System.out.println(content.toString());
                
                final String message = content.toString();
                
                final String[] split = message.split("\\},\\{");
                List<ConsumptionPointTime> data = new ArrayList<ConsumptionPointTime>(split.length);
                for(int i = 0; i<split.length;i++)
                {
                    //System.out.println(s);
                    final int[] vals = new int[ConsumptionData.delimiters.length];
                    for(int j = 0; j<ConsumptionData.delimiters.length;j++)
                    {
                        vals[j] = ExtractValue(split[i], ConsumptionData.delimiters[j]);
                    }
                    Date time = ExtractTime(split[i], timeDelimiter);
                    data.add(new ConsumptionPointTime(vals, time));
                }
                System.out.println("Lines: " + split.length);
                ConsumptionData.consumptionData = data;
                /*Pattern r = Pattern.compile(regex);
                Matcher m = r.matcher(message);
                if(m.find())
                {
                    int start = m.start()+17;
                    int end = m.end();
                    
                    String str = message.substring(start, end);
                    int val = Integer.parseInt(str);
                    System.out.println(val);
                    ConsumptionData.consumptionData.add(val);
                }*/

                con.disconnect();
                sleep(60*1000*5);
            }
        }   
        catch (final IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        } catch (final InterruptedException e) {
			// TODO Auto-generated catch block
            return;
		}
    }
    Date ExtractTime(final String text, final String delimiter)
    {
        final String regx = delimiter + "\":\"\\d+.\\d+.\\d+ \\d+:\\d+:\\d+";
        final Pattern r = Pattern.compile(regx);
        final Matcher m = r.matcher(text);
        if(m.find())
        {
            final int start = m.start()+delimiter.length()+3;
            final int end = m.end();
                    
            final String str = text.substring(start, end);
            //System.out.println(val);
            try {
				return DateFormat.getDateTimeInstance().parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }
    int ExtractValue(final String text, final String delimiter)
    {
        final String regx = delimiter + "\":\"\\d+";
        final Pattern r = Pattern.compile(regx);
        final Matcher m = r.matcher(text);

        if(m.find())
        {
            
            final int start = m.start()+delimiter.length()+3;
            final int end = m.end();
                    
            final String str = text.substring(start, end);
            final int val = Integer.parseInt(str);
            //System.out.println(val);
            return val;
        }
        return -1;
    }
}