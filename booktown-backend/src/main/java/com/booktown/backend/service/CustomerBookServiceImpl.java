package com.booktown.backend.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktown.backend.admin.repository.BookRepository;
import com.booktown.backend.entity.Book;
import com.booktown.backend.entity.Cart;
import com.booktown.backend.entity.Customer;
import com.booktown.backend.repository.CartRepository;
import com.booktown.backend.repository.CustomerRepository;

@Service
@Transactional
public class CustomerBookServiceImpl implements CustomerBookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Cart addToCart(Integer bookId,Integer customerId) {
		
		Cart searchCart = cartRepository.searchBook(customerId, bookId);
		if(searchCart!=null) {
			searchCart.setQuantity(searchCart.getQuantity()+1);
			return cartRepository.save(searchCart);
		}
		
		Cart cart = new Cart();
		Optional<Book> book = bookRepository.findById(bookId);
		if(book.isPresent()) {
			cart.setBookId(bookId);
		}
		
		Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer.isPresent()) {
			cart.setCustomerId(customerId);
		}
		
		cart.setQuantity(1);
		
		return cartRepository.save(cart);
	}

	@Override
	public String emptyCart(Integer customerId) {
		cartRepository.emptyCart(customerId);
		return "Cart Emptied Successfully";
	}

}
