package com.biss.controller.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class CustromerRestController {
	
	@GetMapping("/get")
	@HystrixCommand(fallbackMethod = "dummyMethod")
	public String mainMethod() {
		System.out.println("From Actual Service Method START...");
		 if(new Random().nextInt(15)<10) {
			 throw new RuntimeException("DUMMY");
		 }
		 System.out.println("From Actual Service Method END...");
	return "SUCCESS";	
	}
	
	public String dummyMethod() {
		System.out.println("From DUMMY Method....");
	return"FROM DUMMY";
	}
	
}
