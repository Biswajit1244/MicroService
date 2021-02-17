package com.biss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProj1SpringCloudEurekaPaymentServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsProj1SpringCloudEurekaPaymentServiceApplication.class, args);
	}

}
