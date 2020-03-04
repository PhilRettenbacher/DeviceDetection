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
import com.devicedetection.services.WebStreamDataService;
 
@Controller
@RequestMapping("/diagram")
@ComponentScan(value="com.devicedetection.services")
public class WebStreamDataController {
 
	@Autowired
	private WebStreamDataService webStreamDataService;
 
	@RequestMapping(path="/show")
	public String springMVC(ModelMap modelMap) {
		List<List<Map<Object, Object>>> data = webStreamDataService.getWebStreamData();
		modelMap.addAttribute("dataPointsList", data);
		return "diagram";
	}
 
}       