package com.gbadegesin.socialappautomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.json.JsonMapper;

@SpringBootApplication
public class SocialAppAutomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialAppAutomationApplication.class, args);
	}
	
	@Bean
	ObjectMapper objectMapper() {
		return JsonMapper.builder().build();
	}

}