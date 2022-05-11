package com.booktown.backend.service;

import java.util.List;

import com.booktown.backend.dto.BlogDTO;
import com.booktown.backend.entity.Blog;
import com.booktown.backend.exception.BlogNotFoundException;
import com.booktown.backend.exception.CustomerNotFoundException;

public interface CustomerBlogService {
	
	public Blog post(BlogDTO blogDTO,Integer customerId) throws CustomerNotFoundException;
	
	public Blog getBlogById(Integer blogId) throws BlogNotFoundException;
	
	public List<Blog> getBlogs(Integer customerId) throws CustomerNotFoundException;
}
