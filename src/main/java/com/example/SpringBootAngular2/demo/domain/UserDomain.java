package com.example.SpringBootAngular2.demo.domain;

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
	private String des;
	
	public UserDomain() {

	}
	
	public UserDomain(int id, String name, String des) {
		super();
		this.id =id;
		this.name = name;
		this.des = des;
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


	public String getDes() {
		return des;
	}


	public void setDes(String des) {
		this.des = des;
	}

}
