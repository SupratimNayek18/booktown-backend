package com.booktown.backend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.booktown.backend.exception.CustomerNotFoundException;
import com.booktown.backend.exception.CustomerRegistrationException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> customerNotFoundException(CustomerNotFoundException cnfe)
	{
		return  new ResponseEntity<>(cnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerRegistrationException.class)
	public ResponseEntity<String> customerRegistrationException(CustomerRegistrationException cre)
	{
		return  new ResponseEntity<>(cre.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
}
