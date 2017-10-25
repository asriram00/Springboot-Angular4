package com.example.SpringBootAngular4.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserDomain implements Serializable {
	
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String password;
	private String comment;
	private int enabled;
	private boolean admin;
	

	public UserDomain() {

	}
	public UserDomain(UserDomain user) {
		super();
		this.id = user.id;
		this.name = user.name;
		this.comment = user.comment;
		this.password = user.password;
		this.enabled = user.enabled;
		this.admin = user.admin;
	}
	
	public UserDomain(int id, String name, String comment, String password, int enabled, boolean admin) {
		super();
		this.id =id;
		this.name = name;
		this.comment = comment;
		this.password = password;
		this.enabled = enabled;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getEnabled() {
		return enabled;
	}
	
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
