package com.biss.service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.biss.store.KafkaMessageStorage;

@Service
public class KafkaConsumerService {

	@Autowired
	private KafkaMessageStorage store;
	
	@KafkaListener(topics = "${my.kafka.tpcname}",groupId = "djbravo")
	public void readMessageFromKafka(String msg) {
		System.out.println("Data Received from Kafka is=>"+msg);
		store.add(msg);
	}
}