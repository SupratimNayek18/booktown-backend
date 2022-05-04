package com.booktown.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booktown.backend.entity.Cart;
import com.booktown.backend.service.CustomerBookService;

@RestController
@RequestMapping("/book")
public class CustomerBookController {
	
	@Autowired
	CustomerBookService customerBookService;
	
	@PostMapping("/addToCart")
	public ResponseEntity<Cart> addToCart(@RequestParam Integer bookid,@RequestParam Integer customerId){
		return new ResponseEntity<>(customerBookService.addToCart(bookid,customerId),HttpStatus.OK);
	}
	
	@DeleteMapping("/emptyCart")
	public ResponseEntity<String> emptyCart(@RequestParam Integer customerId){
		return new ResponseEntity<>(customerBookService.emptyCart(customerId),HttpStatus.OK);
	}
	
}
