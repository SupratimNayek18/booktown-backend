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
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	CustomPasswordEncoder customPasswordEncoder;

	@Override
	public Admin login(AdminDTO adminDTO) throws AdminNotFoundException {
		Admin admin = adminRepository.findByUsername(adminDTO.getUsername());
		if(admin!=null) {
			String storedPassword = admin.getPassword();
			if(customPasswordEncoder.matches(adminDTO.getPassword(), storedPassword)) {
				return admin;
			}else {
				throw new AdminNotFoundException("Incorrect Password");
			}
		}else {
			throw new AdminNotFoundException("Admin not found with given credentials");
		}
	}

	@Override
	public Admin register(AdminDTO adminDTO) throws AdminRegistrationException {
		
		if(!ValidationUtils.usernamePatternMatches(adminDTO.getUsername())) {
			throw new AdminRegistrationException("Invalid username");
		}
		
		Admin admin = DtoToEntity.convertAdminDtoToEntity(adminDTO);
		
		String hashedPassword = customPasswordEncoder.encode(adminDTO.getPassword());
		admin.setPassword(hashedPassword);
		return adminRepository.save(admin);
	}

}
