package com.booktown.backend.admin.service;

import com.booktown.backend.admin.exception.BookNotAddedException;
import com.booktown.backend.admin.exception.BookNotFoundException;
import com.booktown.backend.dto.BookDTO;
import com.booktown.backend.entity.Book;

public interface AdminProductService {
	
	public Book addBook(BookDTO bookDTO) throws BookNotAddedException;
	
	public String deleteById(Integer bookId) throws BookNotFoundException;
	
	public Book updateBook(BookDTO bookDTO) throws BookNotFoundException;
	
}
