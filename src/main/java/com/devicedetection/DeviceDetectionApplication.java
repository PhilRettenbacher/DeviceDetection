package com.devicedetection;

import java.sql.Date;

import com.devicedetection.dao.GeraetEventRepository;
import com.devicedetection.dao.GeraetRepository;
import com.devicedetection.model.ConsumptionData;
import com.devicedetection.model.Geraet;
import com.devicedetection.model.GeraetEvent;
import com.devicedetection.model.WebStreamData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.sql.Timestamp;

@SpringBootApplication
public class DeviceDetectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceDetectionApplication.class, args);
		ConsumptionData.initialize();
	}
	@Bean
    public CommandLineRunner mappingDemo(GeraetRepository geraetRepository,
                                         GeraetEventRepository geraetEventRepository) {
        return args -> {

			
			// create a new book
            /*Geraet geraet = new Geraet("Geraet1", "beschreibung", 0, 10000);
            Geraet geraet2 = new Geraet("Geraet2", "beschreibung", 0, 5000);

            // save the book
            geraetRepository.save(geraet);
            geraetRepository.save(geraet2);

            // create and save new pages
            geraetEventRepository.save(new GeraetEvent(new Timestamp(new java.util.Date().getTime()-1000*3600*1), true, geraet));
            geraetEventRepository.save(new GeraetEvent(new Timestamp(new java.util.Date().getTime()-1000*3600*11), false, geraet));
            geraetEventRepository.save(new GeraetEvent(new Timestamp(new java.util.Date().getTime()-1000*3600*30), true, geraet));
            
            geraetEventRepository.save(new GeraetEvent(new Timestamp(new java.util.Date().getTime()-1000*3600*2), true, geraet2));
            geraetEventRepository.save(new GeraetEvent(new Timestamp(new java.util.Date().getTime()-1000*3600*7), false, geraet2));
            geraetEventRepository.save(new GeraetEvent(new Timestamp(new java.util.Date().getTime()-1000*3600*17), true, geraet2));*/
        };
    }
}
