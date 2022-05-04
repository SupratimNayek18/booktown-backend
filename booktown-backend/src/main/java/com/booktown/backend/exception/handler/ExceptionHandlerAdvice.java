package com.booktown.backend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.booktown.backend.admin.exception.AdminNotFoundException;
import com.booktown.backend.admin.exception.AdminRegistrationException;
import com.booktown.backend.admin.exception.BookNotAddedException;
import com.booktown.backend.exception.BookNotFoundException;
import com.booktown.backend.exception.CustomerNotFoundException;
import com.booktown.backend.exception.CustomerRegistrationException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> customerNotFoundException(CustomerNotFoundException cnfe) {
		return new ResponseEntity<>(cnfe.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerRegistrationException.class)
	public ResponseEntity<String> customerRegistrationException(CustomerRegistrationException cre) {
		return new ResponseEntity<>(cre.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<String> adminNotFoundException(AdminNotFoundException anfe) {
		return new ResponseEntity<>(anfe.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminRegistrationException.class)
	public ResponseEntity<String> adminRegistrationException(AdminRegistrationException are) {
		return new ResponseEntity<>(are.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BookNotAddedException.class)
	public ResponseEntity<String> bookNotAddedException(BookNotAddedException bnae) {
		return new ResponseEntity<>(bnae.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String> bookNotFoundException(BookNotFoundException bnfe) {
		return new ResponseEntity<>(bnfe.getMessage(), HttpStatus.NOT_FOUND);
	}

}
