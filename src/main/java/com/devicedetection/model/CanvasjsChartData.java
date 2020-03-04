package com.devicedetection.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanvasjsChartData {
 
	static Map<Object,Object> map = null;
	static List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
	static List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
	
	static {
		map = new HashMap<Object,Object>(); map.put("x", 0); map.put("y", 23.1);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1); map.put("y", 23.4);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 2); map.put("y", 23.7);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 3); map.put("y", 24.1);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 4); map.put("y", 23.5);dataPoints1.add(map);		
		
		list.add(dataPoints1);
	}
	
	public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
		return list;
	}
}                        