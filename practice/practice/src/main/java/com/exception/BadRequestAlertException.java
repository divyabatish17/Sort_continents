package com.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadRequestAlertException extends ResponseStatusException {

	public BadRequestAlertException(String message){
	    super(HttpStatus.BAD_REQUEST, message);
	  }

	  @Override
	  public HttpHeaders getResponseHeaders() {
		return null;
	      
	  }
}
