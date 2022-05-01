package com.booktown.backend.utils;

import com.booktown.backend.dto.RegistrationDetailsDTO;
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

}
