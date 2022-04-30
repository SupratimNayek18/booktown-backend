package com.booktown.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(generator = "Customer_SequenceStyleGenerator")
	@GenericGenerator(name = "Customer_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "customer_SEQ"),
			@Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1") }
			)
	private Integer customerId;
	
	private String name;
	
	private String address;
	
	private String country;
	
	private Integer membershipStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(Integer membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", country=" + country
				+ ", membershipStatus=" + membershipStatus + "]";
	}
	
}
