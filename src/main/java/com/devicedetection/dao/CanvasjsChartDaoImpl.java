package com.devicedetection.dao;

import java.util.List;
import java.util.Map;

import com.devicedetection.model.CanvasjsChartData;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
 
@Repository("canvasjsChartDao")
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}
 
}                        