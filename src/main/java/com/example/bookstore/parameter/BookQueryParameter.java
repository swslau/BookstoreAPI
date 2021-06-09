package com.example.bookstore.parameter;

public class BookQueryParameter {
	private String isbn;
	private String orderBy;
	private String sortRule;
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getOrderBy() {
		return orderBy;
	}
	
	public String getSortRule() {
		return sortRule;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public void setSortRule(String sortRule) {
		this.sortRule = sortRule;
	}
}
