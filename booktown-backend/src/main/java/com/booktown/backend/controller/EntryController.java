package com.booktown.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {
	
	@GetMapping("/login")
	public ResponseEntity<String> login(){
		return new ResponseEntity<>("This is Login Controller",HttpStatus.OK);
	}
	
	@GetMapping("/register")
	public ResponseEntity<String> register(){
		return new ResponseEntity<>("This is Register Controller",HttpStatus.OK);
	}
	
}
