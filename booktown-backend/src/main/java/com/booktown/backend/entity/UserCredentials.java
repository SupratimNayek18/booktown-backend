package com.booktown.backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usercredentials")
public class UserCredentials {
	
	/**
	 * @Id is used to denote the attribute as primary key
	 * @GenericGenerator is used to create an isolated sequence for this entity to avoid
	 * issues regarding hibernate sequence as hibernate creates an single sequence by default
	 * for all entities
	 */
	@Id
	@GeneratedValue(generator = "UserCredentials_SequenceStyleGenerator")
	@GenericGenerator(name = "UserCredentials_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "userCredentials_SEQ"),
			@Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1") }
			)
	private Integer id;
	
	private String username;
	
	private String password;
	
	/**
	 * @JsonIgnore is used to avoid infinite loop during api testing(Swagger or Postman is used in this case)
	 * @OneToOne is used to denote one to one mapping and cascadetype is set to all to delete usercreds too
	 * when customer info is deleted
	 * @JoinColumn denotes the column to be added as foreign key to refer the column in reverse side of the
	 * relationship (i.e. Customer in this case)
	 */
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_fk",referencedColumnName = "customer_id")
	private Customer customer;

	
	//getter and setter methods
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	//toString method
	
	@Override
	public String toString() {
		return "UserCredentials [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
