package com.booktown.backend.dto;

import java.util.ArrayList;
import java.util.List;

public class BookDTO {
	
	private Integer bookId;
	
	private String title;

	private String description;

	private List<String> isbnList = new ArrayList<>();

	private String author;
	
	private Double price;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	private String audiobookUrl;

	private String videoUrl;
	
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public List<String> getIsbnList() {
		return isbnList;
	}

	public void setIsbnList(List<String> isbnList) {
		this.isbnList = isbnList;
	}

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

}
