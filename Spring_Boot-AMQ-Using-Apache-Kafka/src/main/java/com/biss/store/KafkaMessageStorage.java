package com.biss.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class KafkaMessageStorage {

	private List<String> messages=new ArrayList<>();
	
	public void add(String input) {
		messages.add(input);
	}
	
	public String readAll() {
		return messages.toString();
	}

}
