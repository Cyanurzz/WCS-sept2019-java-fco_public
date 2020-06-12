package com.wildcodeschool.fco.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	private String role;
	private Integer number;
	private String photo;
	@Pattern (regexp = "\\d{10}|\\+33\\d{9}|\\+33\\s\\d{1}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}|\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}", message = "Veuillez entrer un numéro valide !")
	private String phoneNumber;
	private String category;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "team_id")
	private Team team;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "convocation_id")
	private Convocation convocation;
	
	public Player() {}

	public Player(Integer id, String firstname, String lastname, String role, Integer number, String photo,
			@Pattern(regexp = "\\d{10}|\\+33\\d{9}|\\+33\\s\\d{1}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}|\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}", message = "Veuillez entrer un numéro valide !") String phoneNumber,
			String category, Team team) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.number = number;
		this.photo = photo;
		this.phoneNumber = phoneNumber;
		this.category = category;
		this.team = team;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Convocation getConvocation() {
		return convocation;
	}

	public void setConvocation(Convocation convocation) {
		this.convocation = convocation;
	}
	
	
}
