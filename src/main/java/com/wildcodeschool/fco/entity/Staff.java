package com.wildcodeschool.fco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String lastname;
	private String firstname;
	private String fonction;
	private String category;
	private String picture;
	@Column(length = 500)
	private String description;
	
	public Staff() {}
	
	public Staff(Integer id, String lastname, String firstname, String fonction, String category, String picture, String description) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.fonction = fonction;
		this.category = category;
		this.picture = picture;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getFonction() {
		return fonction;
	}
	
	public void setFonction(String function) {
		this.fonction = function;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
}
