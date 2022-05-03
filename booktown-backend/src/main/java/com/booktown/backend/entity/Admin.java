package com.booktown.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Admin {
	
	/**
	 * @Id is used to denote the attribute as primary key
	 * @GenericGenerator is used to create an isolated sequence for this entity to avoid
	 * issues regarding hibernate sequence as hibernate creates an single sequence by default
	 * for all entities
	 */
	@Id
	@GeneratedValue(generator = "Admin_SequenceStyleGenerator")
	@GenericGenerator(name = "Admin_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "admin_SEQ"),
			@Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1") }
			)
	private Integer adminId;
	
	private String username;
	
	private String password;
	
	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAdminId() {
		return adminId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + ", name=" + name
				+ "]";
	}
	
}
