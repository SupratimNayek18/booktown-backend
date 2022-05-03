package com.booktown.backend.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktown.backend.admin.dto.AdminDTO;
import com.booktown.backend.admin.exception.AdminNotFoundException;
import com.booktown.backend.admin.exception.AdminRegistrationException;
import com.booktown.backend.admin.repository.AdminRepository;
import com.booktown.backend.entity.Admin;
import com.booktown.backend.utils.CustomPasswordEncoder;
import com.booktown.backend.utils.DtoToEntity;
import com.booktown.backend.utils.ValidationUtils;

@Service
public class AdminEntryServiceImpl implements AdminEntryService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	CustomPasswordEncoder customPasswordEncoder;

	
	//Method for admin login
	@Override
	public Admin login(AdminDTO adminDTO) throws AdminNotFoundException {
		//Getting the admin entity by username
		Admin admin = adminRepository.findByUsername(adminDTO.getUsername());
		
		if(admin!=null) {
			
			//Retrieving the stored hashed password from database
			String storedPassword = admin.getPassword();
			
			
			/**Matching stored passoword with given adminDTO password 
			 * and returning admin object if matched else throwing exception
			 */
			if(customPasswordEncoder.matches(adminDTO.getPassword(), storedPassword)) {
				return admin;
			}else {
				throw new AdminNotFoundException("Incorrect Password");
			}
			
		}else {
			throw new AdminNotFoundException("Admin not found with given credentials");
		}
	}

	
	//Method for admin registration
	@Override
	public Admin register(AdminDTO adminDTO) throws AdminRegistrationException {
		
		//Validating the username
		if(!ValidationUtils.usernamePatternMatches(adminDTO.getUsername())) {
			throw new AdminRegistrationException("Invalid username");
		}
		
		
		//Checking if admin exists with the given username
		Admin admin = adminRepository.findByUsername(adminDTO.getUsername());
		if(admin!=null) throw new AdminRegistrationException("Username already Exists");
		
		
		//Converting DTO to entity object
		admin = DtoToEntity.convertAdminDtoToEntity(adminDTO);
		
		
		//Hashing the password
		String hashedPassword = customPasswordEncoder.encode(adminDTO.getPassword());
		admin.setPassword(hashedPassword);
		
		
		//Saving admin info
		return adminRepository.save(admin);
		
	}

}
