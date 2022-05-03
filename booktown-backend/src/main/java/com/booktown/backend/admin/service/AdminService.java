package com.booktown.backend.admin.service;

import com.booktown.backend.admin.dto.AdminDTO;
import com.booktown.backend.admin.exception.AdminNotFoundException;
import com.booktown.backend.admin.exception.AdminRegistrationException;
import com.booktown.backend.entity.Admin;

public interface AdminService {
	
	public Admin login(AdminDTO adminDTO) throws AdminNotFoundException;
	
	public Admin register(AdminDTO adminDTO) throws AdminRegistrationException;
	
}
