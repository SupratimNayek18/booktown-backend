package com.booktown.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booktown.backend.dto.RegistrationDetailsDTO;
import com.booktown.backend.dto.UserCredentialsDTO;
import com.booktown.backend.entity.Customer;
import com.booktown.backend.exception.CustomerNotFoundException;
import com.booktown.backend.exception.CustomerRegistrationException;
import com.booktown.backend.service.EntryService;


@RestController
public class EntryController {
	
	@Autowired
	EntryService entryService;
	
	@PostMapping("/login")
	public ResponseEntity<Customer> login(@RequestBody UserCredentialsDTO userCredentialsDTO) throws CustomerNotFoundException{
		Customer customer = entryService.login(userCredentialsDTO);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Customer> register(@RequestBody RegistrationDetailsDTO registrationDetailsDTO) throws CustomerRegistrationException{
		Customer customer = entryService.registration(registrationDetailsDTO);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
}
