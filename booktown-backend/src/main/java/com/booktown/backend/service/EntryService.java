package com.booktown.backend.service;

import com.booktown.backend.dto.RegistrationDetailsDTO;
import com.booktown.backend.dto.UserCredentialsDTO;
import com.booktown.backend.entity.Customer;
import com.booktown.backend.exception.CustomerNotFoundException;
import com.booktown.backend.exception.CustomerRegistrationException;

public interface EntryService {
	
	public Customer login(UserCredentialsDTO userCredentialsDTO) throws CustomerNotFoundException;
	
	public Customer registration(RegistrationDetailsDTO registrationDetailsDTO) throws CustomerRegistrationException;
	

}
