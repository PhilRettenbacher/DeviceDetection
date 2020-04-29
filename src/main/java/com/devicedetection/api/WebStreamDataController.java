package com.devicedetection.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.devicedetection.services.CanvasjsChartService;
import com.devicedetection.services.CanvasjsChartServiceImpl;
import com.devicedetection.services.WebStreamDataService;
 
@Controller
@RequestMapping("/diagram")
@ComponentScan(value="com.devicedetection.services")
public class WebStreamDataController {
 
	@Autowired
	private WebStreamDataService webStreamData;
 
	@RequestMapping(path="/show")
	public String springMVC(ModelMap modelMap) {
		List<String> names = new ArrayList<String>();
		List<List<Map<Object, Object>>> canvasjsDataList = webStreamData.getWebStreamData(names);
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		modelMap.addAttribute("names", names);
		return "diagram";
	}
	
	@RequestMapping(path="/show/1")
	public String springMVC1(ModelMap modelMap) {
		List<String> names = new ArrayList<String>();
		List<List<Map<Object, Object>>> canvasjsDataList = webStreamData.getWebStreamData(names);
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		modelMap.addAttribute("names", names);
		return "diagram1";
	}
	
	@RequestMapping(path="/show/2")
	public String springMVC2(ModelMap modelMap) {
		List<String> names = new ArrayList<String>();
		List<List<Map<Object, Object>>> canvasjsDataList = webStreamData.getWebStreamData(names);
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		modelMap.addAttribute("names", names);
		return "diagram2";
	}
	
	@RequestMapping(path="/show/3")
	public String springMVC3(ModelMap modelMap) {
		List<String> names = new ArrayList<String>();
		List<List<Map<Object, Object>>> canvasjsDataList = webStreamData.getWebStreamData(names);
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		modelMap.addAttribute("names", names);
		return "diagram3";
	}
	
	@RequestMapping(path="/show/4")
	public String springMVC4(ModelMap modelMap) {
		List<String> names = new ArrayList<String>();
		List<List<Map<Object, Object>>> canvasjsDataList = webStreamData.getWebStreamData(names);
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		modelMap.addAttribute("names", names);
		return "diagram4";
	}
	
	@RequestMapping(path="/show/5")
	public String springMVC5(ModelMap modelMap) {
		List<String> names = new ArrayList<String>();
		List<List<Map<Object, Object>>> canvasjsDataList = webStreamData.getWebStreamData(names);
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		modelMap.addAttribute("names", names);
		return "diagram5";
	}
 
}       