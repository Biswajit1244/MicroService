package com.biss.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorRestController {
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/show")
	public String showMsg() {
		return "response comming from port:-"+port;
	}
}
