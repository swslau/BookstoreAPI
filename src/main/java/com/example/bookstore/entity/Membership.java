package com.example.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookstore_membership")
public class Membership {
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "membership_name")
	private String membershipName;
	
	public Membership() {
		
	}
	
	public Membership(int id, String membershipName) {
		this.id = id;
		this.membershipName = membershipName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMembershipName() {
		return membershipName;
	}
	
	public void setMembershipName(String membershipName) {
		this.membershipName = membershipName;
	}
}
