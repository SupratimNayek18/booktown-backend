package com.booktown.backend.service;

import java.util.List;

import com.booktown.backend.entity.Blog;

public interface CustomerBlogService {
	
	public Blog post(Blog blog,Integer customerId);
	
	public Blog getBlogById(Integer blogId);
	
	public List<Blog> getBlogs(Integer customerId);
}
