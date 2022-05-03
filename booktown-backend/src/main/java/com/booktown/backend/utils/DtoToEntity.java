package com.booktown.backend.utils;

import com.booktown.backend.admin.dto.AdminDTO;
import com.booktown.backend.dto.RegistrationDetailsDTO;
import com.booktown.backend.entity.Admin;
import com.booktown.backend.entity.Customer;

public class DtoToEntity {
	
	private DtoToEntity() {}

	public static Customer convertCustomerDtoToEntity(RegistrationDetailsDTO registrationDetailsDTO) {
		Customer customer = new Customer();
		customer.setAddress(registrationDetailsDTO.getAddress());
		customer.setCountry(registrationDetailsDTO.getCountry());
		customer.setName(registrationDetailsDTO.getName());
		customer.setMembershipStatus(0);
		return customer;
	}
	
	public static Admin convertAdminDtoToEntity(AdminDTO adminDTO) {
		Admin admin = new Admin();
		admin.setName(adminDTO.getName());
		admin.setUsername(adminDTO.getUsername());
		return admin;
	}

}
