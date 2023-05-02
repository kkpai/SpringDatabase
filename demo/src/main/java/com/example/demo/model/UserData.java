package com.example.demo.model;

import java.io.Serializable;

 import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * The persistent class for the user database table.
 * 
 */
 @Entity
 @Table(name="user")
public class UserData implements Serializable {
	private static final long serialVersionUID = 1L;

	private String emailid;

	 @Id
	private int id;

	private String name;


	public String getEmailId() {
		return this.emailid;
	}

	public void setEmailId(String emailId) {
		this.emailid = emailId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


}