package com.booktown.backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class Customer {
	
	/**
	 * @Id is used to denote the attribute as primary key
	 * @GenericGenerator is used to create an isolated sequence for this entity to avoid
	 * issues regarding hibernate sequence as hibernate creates an single sequence by default
	 * for all entities
	 */
	@Id
	@GeneratedValue(generator = "Customer_SequenceStyleGenerator")
	@GenericGenerator(name = "Customer_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "customer_SEQ"),
			@Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1") }
			)
	@Column(name = "customer_id")
	private Integer customerId;
	
	private String name;
	
	private String address;
	
	private String country;
	
	private String email;
	
	private Integer membershipStatus;
	
	/**
	 * @JsonIgnore is used to avoid infinite loop during api testing
	 * @OneToOne is used to denote one to one mapping and cascadetype is set to all to delete usercreds too
	 * when customer info is deleted
	 */
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private UserCredentials userCredentials;

	
	//getter and setter methods
	
	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	//toString method

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", country=" + country
				+ ", membershipStatus=" + membershipStatus + "]";
	}
	
}
