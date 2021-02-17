package com.biss.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CustomerRestController {
	
	@Value("${my.app.name}")
	private String data;
	
	@GetMapping("/cust")
	public String showData() {
		return "Application Name="+data;
	}
}
