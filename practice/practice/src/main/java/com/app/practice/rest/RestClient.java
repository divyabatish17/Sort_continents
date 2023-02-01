package com.app.practice.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.practice.dto.ContinentsDto;
import com.app.practice.dto.StateDto;

@Component
public class RestClient {
	
	public static final String GET_ALL="https://cloudfinch-public.s3.ap-south-1.amazonaws.com/countries.json";
	public static final String GET_BY_REGION=GET_ALL+"/region/{region}";

	@Autowired
	@Qualifier("restWebClient")
	private WebClient webClient;

	public RestClient() {

	}

	public RestClient(WebClient webClient) {
		this.webClient = webClient;
	}
	
	public List<StateDto> fetchAll(){
		return webClient.get().uri(GET_ALL).retrieve().bodyToFlux(StateDto.class).collectList().block();
	}
	
	public List<ContinentsDto> fetchContinentsDetails(){
		return webClient.get().uri(GET_ALL).retrieve().bodyToFlux(ContinentsDto.class).collectList().block();
	}
	
	public List<ContinentsDto> fetchContinents(String region){
		return webClient.get().uri(GET_BY_REGION,region).retrieve().bodyToFlux(ContinentsDto.class).collectList().block();
	}

	
}
