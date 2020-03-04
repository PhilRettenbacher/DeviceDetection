package com.devicedetection.api;

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
 
@Controller
@RequestMapping("/canvasjschart")
@ComponentScan(value="com.devicedetection.services")
public class CanvasjsChartController {
 
	@Autowired
	private CanvasjsChartService canvasjsChartService;
 
	@RequestMapping(path="/show")
	public String springMVC(ModelMap modelMap) {
		List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		return "chart";
	}
 
}                        