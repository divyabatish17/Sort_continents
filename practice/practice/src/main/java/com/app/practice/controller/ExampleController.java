package com.app.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.practice.dto.ContinentsDto;
import com.app.practice.dto.StateDto;
import com.app.practice.rest.RestClient;
import com.exception.BadRequestAlertException;

@RestController
@RequestMapping("/api")
public class ExampleController {

	@Autowired
	RestClient restClient;
	
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		try {
			List<StateDto> result = restClient.fetchAll();
	        if(result!=null) {
	        	return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
	        }
	        else {
	        	return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Result not present");
	        }
	        }
	        catch(Exception e) {
	        	throw new BadRequestAlertException("No result");
	        }
	}
	
	@GetMapping("/details")
	public ResponseEntity<Object> getDetails(){
		try {
			List<ContinentsDto> result = restClient.fetchContinentsDetails();
	        if(result!=null) {
	        	return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
	        }
	        else {
	        	return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Result not present");
	        }
	        }
	        catch(Exception e) {
	        	throw new BadRequestAlertException("No result");
	        }
	}
	
	@GetMapping("/region/{region}")
	public ResponseEntity<Object> getBasedOnContinents(@PathVariable String region){
		try {
			List<ContinentsDto> result = restClient.fetchContinents(region);
	        if(result!=null) {
	        	return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
	        }
	        else {
	        	return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Result not present");
	        }
	        }
	        catch(Exception e) {
	        	throw new BadRequestAlertException("No result");
	        }
	}
	
}
