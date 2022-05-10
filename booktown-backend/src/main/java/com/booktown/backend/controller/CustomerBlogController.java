package com.booktown.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booktown.backend.entity.Blog;
import com.booktown.backend.service.CustomerBlogService;

@RestController
@RequestMapping("/blog")
public class CustomerBlogController {
	
	@Autowired
	CustomerBlogService customerBlogService;
	
	@PostMapping("/post")
	public ResponseEntity<Blog> post(@RequestBody Blog blog,@RequestParam Integer customerId){
		return new ResponseEntity<>(customerBlogService.post(blog, customerId),HttpStatus.OK);
	}
	
	@GetMapping("/getBlogs")
	public ResponseEntity<List<Blog>> getBlogs(@RequestParam Integer customerId){
		return new ResponseEntity<>(customerBlogService.getBlogs(customerId),HttpStatus.OK);
	}
	

}
