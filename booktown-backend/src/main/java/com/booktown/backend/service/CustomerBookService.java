package com.booktown.backend.service;

import com.booktown.backend.entity.Cart;

public interface CustomerBookService {
	
	public Cart addToCart(Integer bookId,Integer customerId);
	
	public String emptyCart(Integer customerId);

}
