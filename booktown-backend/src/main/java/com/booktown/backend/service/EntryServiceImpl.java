package com.booktown.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktown.backend.admin.repository.BookRepository;
import com.booktown.backend.dto.RegistrationDetailsDTO;
import com.booktown.backend.dto.UserCredentialsDTO;
import com.booktown.backend.entity.Book;
import com.booktown.backend.entity.Customer;
import com.booktown.backend.entity.UserCredentials;
import com.booktown.backend.exception.BookNotFoundException;
import com.booktown.backend.exception.CustomerNotFoundException;
import com.booktown.backend.exception.CustomerRegistrationException;
import com.booktown.backend.repository.CustomerRepository;
import com.booktown.backend.repository.UserCredentialsRepository;
import com.booktown.backend.utils.CustomPasswordEncoder;
import com.booktown.backend.utils.DtoToEntity;
import com.booktown.backend.utils.ValidationUtils;

@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	UserCredentialsRepository userCredentialsRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomPasswordEncoder customPasswordEncoder;
	
	@Autowired
	BookRepository bookRepository;

	
	// Method for customer login
	@Override
	public Customer login(UserCredentialsDTO userCredentialsDTO) throws CustomerNotFoundException {
		UserCredentials userCredentials = userCredentialsRepository.findByUsername(userCredentialsDTO.getUsername());

		// Throwing an exception here if customer not available
		if (userCredentials == null)
			throw new CustomerNotFoundException(
					"Customer with username" + userCredentialsDTO.getUsername() + "does not exist");

		// Getting password in dto and matching it with stored password in db
		String storedHashedPassword = userCredentials.getPassword();
		if (customPasswordEncoder.matches(userCredentialsDTO.getPassword(), storedHashedPassword)) {
			return userCredentials.getCustomer();
		} else {
			throw new CustomerNotFoundException("Incorrect password. Please try again");
		}

	}

	
	// Method for customer registration
	@Override
	public Customer registration(RegistrationDetailsDTO registrationDetailsDTO) throws CustomerRegistrationException {
		
		Customer customer = DtoToEntity.convertCustomerDtoToEntity(registrationDetailsDTO);
		
		
		// email validation here and checking redundancy
		if (ValidationUtils.emailPatternMatches(registrationDetailsDTO.getEmail())) {
			if (customerRepository.findByEmail(registrationDetailsDTO.getEmail()) != null) {
				throw new CustomerRegistrationException("Email Already Exists");
			}
			customer.setEmail(registrationDetailsDTO.getEmail());
		} else {
			throw new CustomerRegistrationException("Invalid Email Address");
		}

		
		// saving the customer
		Customer savedCustomer = null;
		try {
			savedCustomer = customerRepository.save(customer);
		} catch (Exception e) {
			throw new CustomerRegistrationException("Registration Failed Please Try Again");
		}

		
		// creating usercredentials object
		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setCustomer(savedCustomer);

		
		// Username validation here and checking redundancy
		if (ValidationUtils.usernamePatternMatches(registrationDetailsDTO.getUsername())) {
			if (userCredentialsRepository.findByUsername(registrationDetailsDTO.getUsername()) != null) {
				throw new CustomerRegistrationException("Username Already Exists");
			}
			userCredentials.setUsername(registrationDetailsDTO.getUsername());
		} else {
			throw new CustomerRegistrationException("Invalid Username");
		}

		userCredentials.setPassword(customPasswordEncoder.encode(registrationDetailsDTO.getPassword()));

		
		// saving usercredentials
		try {
			savedCustomer.setUserCredentials(userCredentials);
			userCredentialsRepository.save(userCredentials);
		} catch (Exception e) {
			throw new CustomerRegistrationException("Registration Failed Please Try Again");
		}

		
		// return the saved customer
		return savedCustomer;
	}


	//Method to fetch all books regardless of login
	@Override
	public List<Book> getBooks() throws BookNotFoundException {
		List<Book> bookList = bookRepository.findAll();
		if(bookList.isEmpty()) throw new BookNotFoundException("No Books To Show");
		else return bookList;
	}

}
