package com.biss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudExternalConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudExternalConfigServerApplication.class, args);
	}

}
