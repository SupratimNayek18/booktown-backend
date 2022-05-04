package com.booktown.backend.admin.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktown.backend.admin.exception.BookNotAddedException;
import com.booktown.backend.admin.repository.BookRepository;
import com.booktown.backend.dto.BookDTO;
import com.booktown.backend.entity.Book;
import com.booktown.backend.exception.BookNotFoundException;
import com.booktown.backend.utils.DtoToEntity;

@Service
@Transactional
public class AdminProductServiceImpl implements AdminProductService {
	
	@Autowired
	BookRepository bookRepository;

	
	//Method for adding book into database
	@Override
	public Book addBook(BookDTO bookDTO) throws BookNotAddedException {
		
		//Convering bookDTO into entity and then saving in database
		Book book = DtoToEntity.convertBookDtoToEntityForAddition(bookDTO);
		
		
		//If saving is successfull return book object else throwing error
		try {
			return bookRepository.save(book);
		}catch(Exception e) {
			throw new BookNotAddedException("Failed to add book in database");
		}
		
	}

	@Override
	public String deleteById(Integer bookId) throws BookNotFoundException {
		
		//Trying to delete book and if deletion not successfull throwing exception
		try {
			bookRepository.deleteById(bookId);
		}catch(Exception e) {
			throw new BookNotFoundException("Book not found.Please check book id and try again");
		}
		
		//Return success message
		return "Book Deleted Successfully";
	}

	@Override
	public Book updateBook(BookDTO bookDTO) throws BookNotFoundException {
		
		//Retriving book from database which gives us Optional object
		Optional<Book> optionalBook = bookRepository.findById(bookDTO.getBookId());
		
		//If book present updating bookDTO into entity and saving else throwing exception
		if(optionalBook.isPresent()) {
			Book book = DtoToEntity.convertBookDtoToEntityForUpdate(bookDTO, optionalBook.get());
			return bookRepository.save(book);
		}else {
			throw new BookNotFoundException("Book not found. Please check book id and try again");
		}
		
	}

}
