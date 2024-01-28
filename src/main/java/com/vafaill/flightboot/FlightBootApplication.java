package com.vafaill.flightboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = "com.vafaill.flightboot.model.concrete")
public class FlightBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBootApplication.class, args);
	}

}
