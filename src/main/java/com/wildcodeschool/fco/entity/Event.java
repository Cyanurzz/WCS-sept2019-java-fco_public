package com.wildcodeschool.fco.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String picture;
	@Column(columnDefinition = "TEXT")
	private String content;
	private Date date;
	private Integer places;
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private List<Entrant> entrants;
	
	public Event() {}
	
	public Event(Integer id, String title, String picture, String content, Date date, Integer places) {
		this.id = id;
		this.title = title;
		this.picture = picture;
		this.content = content;
		this.date = date;
		this.places = places;
	}		

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPlaces() {
		return places;
	}
	
	public void setPlaces(Integer places) {
		this.places = places;
	}

	public List<Entrant> getEntrants() {
		return entrants;
	}

	public void setEntrants(List<Entrant> entrants) {
		this.entrants = entrants;
	}
	
}
