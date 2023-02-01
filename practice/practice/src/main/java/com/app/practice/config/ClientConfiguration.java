package com.app.practice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfiguration {

	@Value(value="${rest.url}")
	private String restUrl;
	
	@Bean(name="restWebClient")
	public WebClient restWebClient() {
		return WebClient.create(restUrl);
	}
}
