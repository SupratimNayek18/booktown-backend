package com.booktown.backend.admin.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktown.backend.admin.repository.BookRepository;
import com.booktown.backend.dto.BookDTO;
import com.booktown.backend.entity.Book;
import com.booktown.backend.utils.DtoToEntity;

@Service
@Transactional
public class AdminProductServiceImpl implements AdminProductService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public Book addBook(BookDTO bookDTO) {
		Book book = DtoToEntity.convertBookDtoToEntityForAddition(bookDTO);
		return bookRepository.save(book);
	}

	@Override
	public String deleteById(Integer bookId) {
		bookRepository.deleteById(bookId);
		return "Book Deleted Successfully";
	}

	@Override
	public Book updateBook(BookDTO bookDTO) {
		Book book = bookRepository.findById(bookDTO.getBookId()).get();
		book = DtoToEntity.convertBookDtoToEntityForUpdate(bookDTO, book);
		return bookRepository.save(book);
	}

}
