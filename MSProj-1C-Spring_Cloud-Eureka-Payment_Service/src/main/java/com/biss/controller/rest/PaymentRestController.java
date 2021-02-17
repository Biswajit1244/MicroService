package com.biss.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biss.consumer.PaymentConsumer;

@RestController
public class PaymentRestController {
	@Autowired
	public PaymentConsumer con;
	
	@GetMapping("/pay")
	public String doPayment() {
		return "From Payment=> "+con.connectToOrder();
	}
}
