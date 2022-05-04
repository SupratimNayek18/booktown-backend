package com.booktown.backend.admin.service;

import com.booktown.backend.admin.exception.BookNotAddedException;
import com.booktown.backend.dto.BookDTO;
import com.booktown.backend.entity.Book;
import com.booktown.backend.exception.BookNotFoundException;

public interface AdminProductService {
	
	public Book addBook(BookDTO bookDTO) throws BookNotAddedException;
	
	public String deleteById(Integer bookId) throws BookNotFoundException;
	
	public Book updateBook(BookDTO bookDTO) throws BookNotFoundException;
	
}
