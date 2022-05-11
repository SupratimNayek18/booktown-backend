package com.booktown.backend.exception;

public class BlogNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlogNotFoundException(String message) {
		super(message);
	}

}
