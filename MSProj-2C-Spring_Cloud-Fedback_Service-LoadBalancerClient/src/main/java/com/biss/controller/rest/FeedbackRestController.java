package com.biss.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biss.consumer.CustomerRestConsumer;

@RestController
public class FeedbackRestController {
	@Autowired
	private CustomerRestConsumer consumer;
	
	@GetMapping("/fb")
	public String feedback() {
		return "Feedback"+consumer.frmProducer();
	}
}
