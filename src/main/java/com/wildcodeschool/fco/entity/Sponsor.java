package com.wildcodeschool.fco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sponsor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 70)
	private String name;
	@Column(length = 100)
	private String urlPageSponsor;
	@Column(length = 100)
	private String urlPhoto;
	private int priority;
	
	public Sponsor(Integer id, String name, String urlPageSponsor, String urlPhoto, int priority) {
		super();
		this.id = id;
		this.name = name;
		this.urlPageSponsor = urlPageSponsor;
		this.urlPhoto = urlPhoto;
		this.priority = priority;
	}
	
	public Sponsor() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    

	public String getUrlPageSponsor() {
		return urlPageSponsor;
	}

	public void setUrlPageSponsor(String urlPageSponsor) {
		this.urlPageSponsor = urlPageSponsor;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
