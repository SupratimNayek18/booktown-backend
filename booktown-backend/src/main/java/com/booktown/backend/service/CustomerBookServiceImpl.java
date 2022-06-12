package com.booktown.backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktown.backend.admin.repository.BookRepository;
import com.booktown.backend.entity.Book;
import com.booktown.backend.entity.Cart;
import com.booktown.backend.entity.Customer;
import com.booktown.backend.entity.Order;
import com.booktown.backend.entity.OrderItems;
import com.booktown.backend.exception.CartEmptyException;
import com.booktown.backend.repository.CartRepository;
import com.booktown.backend.repository.CustomerRepository;
import com.booktown.backend.repository.OrderRepository;

@Service
@Transactional
public class CustomerBookServiceImpl implements CustomerBookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Cart addToCart(Integer bookId,Integer customerId) {
		
		//Searching if book exists in cart previously
		Cart searchCart = cartRepository.searchBook(customerId, bookId);
		if(searchCart!=null) {
			
			//Incrementing the quantity by 1
			searchCart.setQuantity(searchCart.getQuantity()+1);
			
			//Getting the price of one book and multiplying with total quantity to get incremented price
			searchCart.setPrice(searchCart.getQuantity()*(searchCart.getPrice()/(searchCart.getQuantity()-1)));
			
			return cartRepository.save(searchCart);
		}
		
		//If book does not exist we are creating a new cart entity object 
		Cart cart = new Cart();
		Optional<Book> book = bookRepository.findById(bookId);
		if(book.isPresent()) {
			cart.setBookId(bookId);
			cart.setPrice(book.get().getPrice());
			cart.setBookName(book.get().getTitle());
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

	@Override
	public List<Cart> getCart(Integer customerId) throws CartEmptyException {
		List<Cart> cartItems = cartRepository.getCart(customerId);
		if(cartItems.isEmpty()) throw new CartEmptyException("Cart feels empty. Try adding something");
		return cartItems;
	}

	@Override
	public Order order(Integer customerId) throws CartEmptyException {
		
		//Creating a new Order entity object
		Order order = new Order();
		order.setCustomerId(customerId);
		
		//Creating a variable to calculate total price of the order
		Double totalPrice = 0.0;
		
		List<Cart> cartItems = cartRepository.getCart(customerId);
		
		//Throwing exception if cart is empty
		if(cartItems.isEmpty()) throw new CartEmptyException("Order cannot be placed if cart is empty");
		
		//Iterating through cart items and adding them in order item list
		for(Cart cartitem : cartItems) {
			OrderItems orderItems = new OrderItems();
			orderItems.setBookId(cartitem.getBookId());
			orderItems.setQuantity(cartitem.getQuantity());
			orderItems.setOrder(order);
			totalPrice += cartitem.getPrice();
			order.getOrderItems().add(orderItems);
		}
		
		//Here we will get invoice id from payment gateway
		order.setInvoiceId("invoice");
		
		//Setting calculated total price
		order.setPrice(totalPrice);
		
		//Emptying the cart after order is successfully placed
		cartRepository.emptyCart(customerId);
		
		return orderRepository.save(order);
	}

}
