package com.booktown.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booktown.backend.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
