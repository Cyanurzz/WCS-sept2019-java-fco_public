package com.wildcodeschool.fco.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
public class Entrant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Veuillez entrer un prénom !")
	@Pattern(regexp = "^[a-zA-Z]*", message = "Veuillez entrer un prénom valide !")
	private String firstname;
	@NotNull(message = "Veuillez entrer un nom")
	@Pattern(regexp = "^[a-zA-Z]*", message = "Veuillez entrer un nom valide !")
	private String lastname;
	@NotNull(message = "Veuillez entrer un age !")
	@Positive(message = "Veuillez entrer un age valide !")
	private Integer age;
	@NotNull(message = "Veuillez entrer un numéro de téléphone !")
	@Pattern (regexp = "\\d{10}|\\+33\\d{9}|\\+33\\s\\d{1}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}|\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}", message = "Veuillez entrer un numéro valide !")
	private String phoneNumber;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "event_id")
	private Event event;
	
	public Entrant() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
}
