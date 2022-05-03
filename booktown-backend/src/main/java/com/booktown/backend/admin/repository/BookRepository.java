package com.booktown.backend.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booktown.backend.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
