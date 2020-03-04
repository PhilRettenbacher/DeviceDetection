package com.devicedetection.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsumptionData
{
    static String urlText = "http://80.120.42.246:82/androidapi/api/verbrauch";
    static List<Integer> consumptionData = new ArrayList<Integer>();
    static RequestThread request;
	public static List<Integer> getConsumptionData() {
		return consumptionData;
    }
    
    
    public static void initialize()
    {
        request = new RequestThread(urlText);
        request.start();
    }
}
class RequestThread extends Thread
{
    String urlText;
    String regex = "tagesVerbrauch\":\"\\d+";
    RequestThread (String urlText)
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
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                int status = con.getResponseCode();

                BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }   
                in.close();
                System.out.println(content.toString());
                
                String message = content.toString();

                Pattern r = Pattern.compile(regex);
                Matcher m = r.matcher(message);
                if(m.find())
                {
                    int start = m.start()+17;
                    int end = m.end();
                    
                    String str = message.substring(start, end);
                    int val = Integer.parseInt(str);
                    System.out.println(val);
                    ConsumptionData.consumptionData.add(val);
                }

                con.disconnect();
                sleep(100);
            }
        }   
        catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
            return;
		}
    }
}