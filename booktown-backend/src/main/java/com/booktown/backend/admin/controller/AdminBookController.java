package com.booktown.backend.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booktown.backend.admin.exception.BookNotAddedException;
import com.booktown.backend.admin.exception.BookNotFoundException;
import com.booktown.backend.admin.service.AdminProductService;
import com.booktown.backend.dto.BookDTO;
import com.booktown.backend.entity.Book;

@RestController
@RequestMapping("/admin")
public class AdminBookController {
	
	@Autowired
	AdminProductService adminProductService;
	
	//Post method for adding book
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody BookDTO bookDTO) throws BookNotAddedException{
		return new ResponseEntity<>(adminProductService.addBook(bookDTO),HttpStatus.OK);
	}
	
	//Delete method for deleting book by id
	@DeleteMapping("/deleteBook")
	public ResponseEntity<String> addBook(@RequestBody Integer bookId) throws BookNotFoundException{
		return new ResponseEntity<>(adminProductService.deleteById(bookId),HttpStatus.OK);
	}
	
	//Put method for updating book entity using dto object
	@PutMapping("/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody BookDTO bookDTO) throws BookNotFoundException{
		return new ResponseEntity<>(adminProductService.updateBook(bookDTO),HttpStatus.OK);
	}
	
}
