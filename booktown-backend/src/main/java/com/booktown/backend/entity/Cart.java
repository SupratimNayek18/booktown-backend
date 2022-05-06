package com.booktown.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "cart")
public class Cart {
	
	/**
	 * @Id is used to denote the attribute as primary key
	 * @GenericGenerator is used to create an isolated sequence for this entity to avoid
	 * issues regarding hibernate sequence as hibernate creates an single sequence by default
	 * for all entities
	 */
	@Id
	@GeneratedValue(generator = "Cart_SequenceStyleGenerator")
	@GenericGenerator(name = "Cart_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "cart_SEQ"),
			@Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1") }
			)
	private Integer cartId;
	
	
	/**
	 * @JsonIgnore is used to avoid infinite loop during api testing
	 * @OneToOne is used to denote one to one mapping and cascadetype is set to all to delete usercreds too
	 * when customer info is deleted
	 * @OneToMany is used to denote one to many mapping but cascade type is set to all except delete
	 * because we dont want to delete books when we delete from cart
	 */
//	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//	@JsonIgnore
//	private List<Book> books = new ArrayList<>();
	
	private Integer bookId;
	
	private Integer customerId;
	
	private Integer quantity;
	
	private Double price;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCartId() {
		return cartId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookId=" + bookId + ", customerId=" + customerId + ", quantity=" + quantity
				+ "]";
	}
	
}
