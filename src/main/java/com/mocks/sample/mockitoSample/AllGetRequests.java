package com.mocks.sample.mockitoSample;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping("/get")
public class AllGetRequests {

	
	@GetMapping
	public String hello() {
		return "H";
	}
	
	
	@GetMapping(value="/json",produces=MediaType.APPLICATION_JSON_VALUE)
	public SayHello anotherHello() {
		return new SayHello("Greetings", "Hello");
	}
	
}

@Data
class SayHello{
	
	public String value;
	public String title;
	

	public SayHello(String value, String title) {
		super();
		this.value = value;
		this.title = title;
	}
}