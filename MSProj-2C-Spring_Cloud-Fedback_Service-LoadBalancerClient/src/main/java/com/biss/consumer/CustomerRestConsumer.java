package com.biss.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerRestConsumer {
	@Autowired
	private LoadBalancerClient client;
	
	public String frmProducer() {
		RestTemplate rt=new RestTemplate();
		//use choose(ServiceId) that given one ServiceInstance
		ServiceInstance si=client.choose("CUSTOMER-SERVICE");
		
		String URL=si.getUri()+"/show";
		String resp=rt.getForObject(URL, String.class);
		
		return resp;
	}
}
