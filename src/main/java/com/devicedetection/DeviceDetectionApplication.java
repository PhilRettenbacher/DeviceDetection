package com.devicedetection;

import com.devicedetection.model.ConsumptionData;
import com.devicedetection.model.WebStreamData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeviceDetectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceDetectionApplication.class, args);
		ConsumptionData.initialize();
	}

}
