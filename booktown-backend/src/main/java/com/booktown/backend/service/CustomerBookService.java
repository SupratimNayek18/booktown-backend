package com.booktown.backend.service;

import java.util.List;

import com.booktown.backend.entity.Cart;
import com.booktown.backend.entity.Order;
import com.booktown.backend.exception.CartEmptyException;

public interface CustomerBookService {
	
	public Cart addToCart(Integer bookId,Integer customerId);
	
	public String emptyCart(Integer customerId);

	public List<Cart> getCart(Integer customerId) throws CartEmptyException;
	
	public Order order(Integer customerId) throws CartEmptyException;
	
}
