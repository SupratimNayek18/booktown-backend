package com.booktown.backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "blog")
public class Blog {

	/**
	 * @Id is used to denote the attribute as primary key
	 * @GenericGenerator is used to create an isolated sequence for this entity to
	 *                   avoid issues regarding hibernate sequence as hibernate
	 *                   creates an single sequence by default for all entities
	 */
	@Id
	@GeneratedValue(generator = "Blog_SequenceStyleGenerator")
	@GenericGenerator(name = "Blog_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "blog_SEQ"), 
			@Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"), 
			@Parameter(name = "increment_size", value = "1") })
	private Integer blogId;

	private String title;

	private String description;

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "customer_fk",referencedColumnName = "customerId")
	private Customer customer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getBlogId() {
		return blogId;
	}
	
}
