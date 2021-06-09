package com.example.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "bookstore_order")
public class Order {
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Book book;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Employee employee;
	
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "payment_amount")
	private double paymentAmount;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "membership_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Membership membership;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Branch branch;
	
	public Order() {
		
	}
	
	public Order(int id, Book book, Employee employee, String paymentMethod, double paymentAmount, Membership membership, Branch branch) {
		this.id = id;
		this.book = book;
		this.employee = employee;
		this.paymentMethod = paymentMethod;
		this.paymentAmount = paymentAmount;
		this.membership = membership;
		this.branch = branch;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public double getPaymentAmount() {
		return paymentAmount;
	}
	
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	public Membership getMembership() {
		return membership;
	}
	
	public void setMembership(Membership membership) {
		this.membership = membership;
	}
	
	public Branch getBranch() {
		return branch;
	}
	
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
}
