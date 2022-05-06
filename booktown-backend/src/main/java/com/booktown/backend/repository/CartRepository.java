package com.booktown.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booktown.backend.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Modifying
	@Query("Delete from Cart cart where cart.customerId=:customerId")
	public void emptyCart(@Param("customerId") Integer customerId);
	
	@Query("select cart from Cart cart where cart.customerId=:customerId and cart.bookId=:bookId")
	public Cart searchBook(@Param("customerId") Integer customerId,@Param("bookId") Integer bookId);
	
	@Query("select cart from Cart cart where cart.customerId=:customerId")
	public List<Cart> getCart(@Param("customerId") Integer customerId);
}
