package com.booktown.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktown.backend.dto.BlogDTO;
import com.booktown.backend.entity.Blog;
import com.booktown.backend.entity.Customer;
import com.booktown.backend.exception.BlogNotFoundException;
import com.booktown.backend.exception.CustomerNotFoundException;
import com.booktown.backend.repository.BlogRepository;
import com.booktown.backend.repository.CustomerRepository;
import com.booktown.backend.utils.DtoToEntity;

@Service
public class CustomerBlogServiceImpl implements CustomerBlogService {

	@Autowired
	BlogRepository blogRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Blog post(BlogDTO blogDTO, Integer customerId) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (!optionalCustomer.isPresent())
			throw new CustomerNotFoundException("Customer with customer id not found");

		Customer customer = optionalCustomer.get();

		Blog blog = DtoToEntity.convertBlogDtoToEntity(blogDTO);
		blog.setCustomer(customer);

		return blogRepository.save(blog);
	}

	@Override
	public Blog getBlogById(Integer blogId) throws BlogNotFoundException {
		Optional<Blog> optionalBlog = blogRepository.findById(blogId);

		if (!optionalBlog.isPresent())
			throw new BlogNotFoundException("Blog with blog id not found");
		
		return optionalBlog.get();
	}

	@Override
	public List<Blog> getBlogs(Integer customerId) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (!optionalCustomer.isPresent())
			throw new CustomerNotFoundException("Customer with customer id not found");

		Customer customer = optionalCustomer.get();
		return customer.getBlogs();
	}

}
