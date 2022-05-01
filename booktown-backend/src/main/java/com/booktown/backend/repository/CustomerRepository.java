package com.booktown.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booktown.backend.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("select cust from Customer cust where cust.email=:email")
	public Customer findByEmail(@Param(value = "email") String email);
	
}
