package com.biss.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biss.consumer.VendorRestConsumer;

@RestController
public class ContractRestController {
	
	@Autowired
	private VendorRestConsumer coon;
	
	@GetMapping("/disp")
	public String frmVendor() {
		return "cosumer->"+coon.fromVendor();
	}
}
