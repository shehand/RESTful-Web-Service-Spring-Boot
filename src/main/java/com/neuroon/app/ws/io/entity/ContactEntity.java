package com.neuroon.app.ws.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "contacts")
public class ContactEntity implements Serializable {

	private static final long serialVersionUID = 78147042927148332L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String contactId;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 50)
	private int number;

	@Column(nullable = false, length = 120)
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public UserEntity getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserEntity userDetails) {
		this.userDetails = userDetails;
	}

	@Column(nullable = false)
	private String contactType;

	@ManyToOne
	@JoinColumn(name = "users_id")
	private UserEntity userDetails;

}
