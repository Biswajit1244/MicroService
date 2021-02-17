package com.biss.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestContrller {
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/show")
	public String show() {
		return "response from "+port;
	}
}
