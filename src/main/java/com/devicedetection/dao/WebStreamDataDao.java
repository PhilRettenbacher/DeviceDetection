package com.devicedetection.dao;

import java.util.List;
import java.util.Map;

import com.devicedetection.model.CanvasjsChartData;
import com.devicedetection.model.ConsumptionData;
import com.devicedetection.model.ConsumptionPointTime;
import com.devicedetection.model.FullConsumptionData;
import com.devicedetection.model.WebStreamData;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
 
@Repository("webStreamDataDao")
public class WebStreamDataDao {
 
	public FullConsumptionData getStreamData() {
		return new FullConsumptionData(ConsumptionData.getConsumptionData(), ConsumptionData.delimiters);
	}
 
}  