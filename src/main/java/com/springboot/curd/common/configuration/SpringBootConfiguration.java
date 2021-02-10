package com.springboot.curd.common.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBootConfiguration {

	@Value("${springBoot.app.name}")
	private String name;
	@Value("${springBoot.welcome.message}")
	private String message;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
