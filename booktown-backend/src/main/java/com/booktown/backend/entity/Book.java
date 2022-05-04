package com.booktown.backend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "books")
public class Book {

	/**
	 * @Id is used to denote the attribute as primary key
	 * @GenericGenerator is used to create an isolated sequence for this entity to
	 *                   avoid issues regarding hibernate sequence as hibernate
	 *                   creates an single sequence by default for all entities
	 */
	@Id
	@GeneratedValue(generator = "Book_SequenceStyleGenerator")
	@GenericGenerator(name = "Book_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "book_SEQ"), @Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	private Integer bookId;

	private String title;

	private String description;

	/**
	 * @ElementCollection signifies that the instance is of type list and also must
	 *                    be used when @CollectionTable is used which in turn
	 *                    specifies the table to store the collection
	 */
	
	@ElementCollection
	@CollectionTable(name = "listOfIsbn")
	private List<String> isbnList = new ArrayList<>();

	private Integer stock;

	private String author;
	
	private Double price;

	private String audiobookUrl;

	private String videoUrl;

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
	public List<String> getISBNList() {
		return isbnList;
	}

	public void setISBNList(List<String> iSBNList) {
		isbnList = iSBNList;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAudiobookUrl() {
		return audiobookUrl;
	}

	public void setAudiobookUrl(String audiobookUrl) {
		this.audiobookUrl = audiobookUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Integer getBookId() {
		return bookId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<String> getIsbnList() {
		return isbnList;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", description=" + description + ", stock=" + stock
				+ ", author=" + author + ", price=" + price + ", audiobookUrl=" + audiobookUrl + ", videoUrl="
				+ videoUrl + "]";
	}

}
