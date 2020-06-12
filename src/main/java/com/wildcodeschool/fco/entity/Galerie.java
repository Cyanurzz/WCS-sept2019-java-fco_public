package com.wildcodeschool.fco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Galerie {
  
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	@Column(length = 100)
	private String title;
	@Column(length = 100)
	private String photo;
	public Galerie() {
		super();
	}
	public Galerie(String title, String photo) {
		super();
		this.title = title;
		this.photo = photo;
	}
	
	
	public Galerie(Long id, String title, String photo) {
		super();
		this.id = id;
		this.title = title;
		this.photo = photo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
	
	
}
