package com.trafficstatus.trafficstatus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TrafficStatusApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficStatusApplication.class, args);
	}

}
