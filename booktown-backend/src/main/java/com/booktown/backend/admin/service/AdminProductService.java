package com.booktown.backend.admin.service;

import com.booktown.backend.dto.BookDTO;
import com.booktown.backend.entity.Book;

public interface AdminProductService {
	
	public Book addBook(BookDTO bookDTO);
	
	public String deleteById(Integer bookId);
	
	public Book updateBook(BookDTO bookDTO);
	
}
