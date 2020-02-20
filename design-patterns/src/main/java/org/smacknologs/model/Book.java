package org.smacknologs.model;

public class Book {

	private String author;

	private String title;
	private Double price;

	public Book(String author, String title, Double price) {
		this.author = author;
		this.title = title;
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public Double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s - %.2f", this.title, this.author, this.price);
	}
}
