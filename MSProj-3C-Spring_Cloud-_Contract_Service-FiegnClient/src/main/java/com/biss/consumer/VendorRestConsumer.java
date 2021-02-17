package com.biss.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "VENDOR-SERVICE")
public interface VendorRestConsumer {
	
	@GetMapping("/vendor/show")
	public String fromVendor();
}
