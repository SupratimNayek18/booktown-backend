package com.booktown.backend.utils;

import java.util.regex.Pattern;

public class ValidationUtils {
	
	private ValidationUtils() {}
	
	private static final String EMAIL_REGEX_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String USERNAME_REGEX_PATTERN =
            "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
	
	public static boolean emailPatternMatches(String emailAddress) {
	    return Pattern.compile(EMAIL_REGEX_PATTERN)
	      .matcher(emailAddress)
	      .matches();
	}
	
	public static boolean usernamePatternMatches(String username) {
	    return Pattern.compile(USERNAME_REGEX_PATTERN)
	      .matcher(username)
	      .matches();
	}

}
