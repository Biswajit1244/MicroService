package com.biss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biss.service.producer.KafkaProducerService;
import com.biss.store.KafkaMessageStorage;

@RestController
@RequestMapping("/kafka")
public class KafkaRestController {
	@Autowired
	private KafkaProducerService producer;
	@Autowired
	private KafkaMessageStorage store;
	
	//..send?message=___
	@GetMapping("/send")
	public String sendMsgToProducer(
			@RequestParam("message")String msg
			) 
	{
		producer.sendMessageToKafka(msg);
		return "SENT ->"+msg;
	}
	
	@GetMapping("/all")
	public String viewAllMessages() {
		String allMsg=store.readAll();
		return allMsg;
	}
}
