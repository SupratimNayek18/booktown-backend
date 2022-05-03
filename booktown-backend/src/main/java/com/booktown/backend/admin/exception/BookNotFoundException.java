package com.booktown.backend.admin.exception;

public class BookNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String message) {
		super(message);
	}

}
