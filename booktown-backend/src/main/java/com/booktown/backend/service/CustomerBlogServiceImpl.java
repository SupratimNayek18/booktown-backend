package com.booktown.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktown.backend.entity.Blog;
import com.booktown.backend.entity.Customer;
import com.booktown.backend.repository.BlogRepository;
import com.booktown.backend.repository.CustomerRepository;

@Service
public class CustomerBlogServiceImpl implements CustomerBlogService {
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Blog post(Blog blog, Integer customerId) {
		Customer customer = customerRepository.findById(customerId).get();
		blog.setCustomer(customer);
		return blogRepository.save(blog);
	}

	@Override
	public Blog getBlogById(Integer blogId) {
		return blogRepository.findById(blogId).get();
	}

	@Override
	public List<Blog> getBlogs(Integer customerId) {
		Customer customer = customerRepository.findById(customerId).get();
		return customer.getBlogs();
	}

}
