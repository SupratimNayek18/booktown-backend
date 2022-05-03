package com.booktown.backend.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booktown.backend.admin.dto.AdminDTO;
import com.booktown.backend.admin.exception.AdminNotFoundException;
import com.booktown.backend.admin.exception.AdminRegistrationException;
import com.booktown.backend.admin.service.AdminEntryService;
import com.booktown.backend.entity.Admin;

@RestController
@RequestMapping("/admin")
public class AdminEntryController {
	
	@Autowired
	AdminEntryService adminService;

	@PostMapping("/login")
	public ResponseEntity<Admin> login(@RequestBody AdminDTO adminDTO) throws AdminNotFoundException {
		return new ResponseEntity<>(adminService.login(adminDTO), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Admin> register(@RequestBody AdminDTO adminDTO) throws AdminRegistrationException {
		return new ResponseEntity<>(adminService.register(adminDTO), HttpStatus.OK);
	}

}
