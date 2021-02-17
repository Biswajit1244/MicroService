package com.biss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProj3PSpringCloudVendorServiceFiegnClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj3PSpringCloudVendorServiceFiegnClientApplication.class, args);
	}

}
