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

	@Column(nullable = false)
	private String contactType;

	@ManyToOne
	@JoinColumn(name = "users_id")
	private UserEntity userDetails;

}
