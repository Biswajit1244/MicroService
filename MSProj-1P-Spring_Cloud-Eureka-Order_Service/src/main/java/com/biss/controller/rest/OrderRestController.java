package com.biss.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
	
	@GetMapping("/show")
	public String showMsg() {
		return "From Order Producer";
	}
}
