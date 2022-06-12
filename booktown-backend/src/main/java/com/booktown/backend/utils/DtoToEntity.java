package com.booktown.backend.utils;

import java.util.List;

import com.booktown.backend.admin.dto.AdminDTO;
import com.booktown.backend.dto.BlogDTO;
import com.booktown.backend.dto.BookDTO;
import com.booktown.backend.dto.RegistrationDetailsDTO;
import com.booktown.backend.entity.Admin;
import com.booktown.backend.entity.Blog;
import com.booktown.backend.entity.Book;
import com.booktown.backend.entity.Customer;

public class DtoToEntity {
	
	private DtoToEntity() {}

	public static Customer convertCustomerDtoToEntity(RegistrationDetailsDTO registrationDetailsDTO) {
		Customer customer = new Customer();
		customer.setAddress(registrationDetailsDTO.getAddress());
		customer.setCountry(registrationDetailsDTO.getCountry());
		customer.setName(registrationDetailsDTO.getName());
		customer.setMembershipStatus(0);
		return customer;
	}
	
	public static Admin convertAdminDtoToEntity(AdminDTO adminDTO) {
		Admin admin = new Admin();
		admin.setName(adminDTO.getName());
		admin.setUsername(adminDTO.getUsername());
		return admin;
	}
	
	public static Book convertBookDtoToEntityForAddition(BookDTO bookDTO) {
		Book book = new Book();
		book.setTitle(bookDTO.getTitle());
		book.setDescription(bookDTO.getDescription());
		book.setAuthor(bookDTO.getAuthor());
		book.setStock(bookDTO.getIsbnList().size());
		book.setAudiobookUrl(bookDTO.getAudiobookUrl());
		book.setISBNList(bookDTO.getIsbnList());
		book.setPrice(bookDTO.getPrice());
		book.setImageUrl(bookDTO.getImageUrl());
		return book;
	}
	
	public static Book convertBookDtoToEntityForUpdate(BookDTO bookDTO,Book book) {
		
		if(bookDTO.getTitle()!=null)
			book.setTitle(bookDTO.getTitle());
		
		if(bookDTO.getDescription()!=null)
			book.setDescription(bookDTO.getDescription());
		
		if(bookDTO.getAuthor()!=null)
			book.setAuthor(bookDTO.getAuthor());
		
		if(bookDTO.getPrice()!=null) {
			book.setPrice(bookDTO.getPrice());
		}
		
		if(bookDTO.getAudiobookUrl()!=null)
			book.setAudiobookUrl(bookDTO.getAudiobookUrl());
		
		if(!bookDTO.getIsbnList().isEmpty()) {
			List<String> storedIsbnList = book.getISBNList();
			for(String isbn : bookDTO.getIsbnList()) {
				storedIsbnList.add(isbn);
			}
			book.setISBNList(storedIsbnList);
		}
		
		if(bookDTO.getImageUrl()!=null)
			book.setImageUrl(bookDTO.getImageUrl());
		
		book.setStock(book.getISBNList().size());
		
		return book;
	}
	
	public static Blog convertBlogDtoToEntity(BlogDTO blogDTO) {
		Blog blog = new Blog();
		blog.setTitle(blogDTO.getTitle());
		blog.setDescription(blogDTO.getDescription());
		return blog;
	}

}
