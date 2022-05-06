package com.booktown.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booktown.backend.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
