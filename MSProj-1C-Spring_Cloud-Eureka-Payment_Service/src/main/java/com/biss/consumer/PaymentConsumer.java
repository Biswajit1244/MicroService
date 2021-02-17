package com.biss.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class PaymentConsumer {
	
	@Autowired
	public DiscoveryClient client;
	
	public String connectToOrder() {
		//Define one RestTemplate
		RestTemplate rt=new RestTemplate();
		
		//Get ServiceInstance by giving application name
		List<ServiceInstance> listSi=client.getInstances("ORDER-SERVICE");
		
		//get one ServiceInstance
		ServiceInstance si=listSi.get(0);
		
		//4. Read URI and add path
		String URL = si.getUri()+"/show";
		
		//Make HttpCall to Producer
		String msg=rt.getForObject(URL,String.class);
				
		return msg;
	}
}
