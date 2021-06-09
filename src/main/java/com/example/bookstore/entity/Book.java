package com.example.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookstore_books")
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String isbn;
	private String name;
	private String author;
	private String publisher;
	private int publishYear;
	private int price;
	
	public Book() {
		
	}
	
	public Book(int id, String isbn, String name, String author, String publisher, int publishYear, int price) {
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getPublishYear() {
		return publishYear;
	}
	
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
