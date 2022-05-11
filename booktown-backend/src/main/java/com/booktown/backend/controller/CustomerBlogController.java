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

import com.booktown.backend.dto.BlogDTO;
import com.booktown.backend.entity.Blog;
import com.booktown.backend.exception.BlogNotFoundException;
import com.booktown.backend.exception.CustomerNotFoundException;
import com.booktown.backend.service.CustomerBlogService;

@RestController
@RequestMapping("/blog")
public class CustomerBlogController {
	
	@Autowired
	CustomerBlogService customerBlogService;
	
	@PostMapping("/post")
	public ResponseEntity<Blog> post(@RequestBody BlogDTO blogDTO,@RequestParam Integer customerId) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerBlogService.post(blogDTO, customerId),HttpStatus.OK);
	}
	
	@GetMapping("/getBlogs")
	public ResponseEntity<List<Blog>> getBlogs(@RequestParam Integer customerId) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerBlogService.getBlogs(customerId),HttpStatus.OK);
	}
	
	@GetMapping("/getBlogById")
	public ResponseEntity<Blog> getBlogById(@RequestParam Integer blogId) throws BlogNotFoundException{
		return new ResponseEntity<>(customerBlogService.getBlogById(blogId),HttpStatus.OK);
	}
	

}
