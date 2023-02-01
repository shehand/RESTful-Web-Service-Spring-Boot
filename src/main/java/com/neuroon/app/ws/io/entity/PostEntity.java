package com.neuroon.app.ws.io.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "posts")
public class PostEntity implements Serializable{
	private static final long serialVersionUID = 5986333090901386583L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "users_id")
	private UserEntity userDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserEntity getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserEntity userDetails) {
		this.userDetails = userDetails;
	}

}
