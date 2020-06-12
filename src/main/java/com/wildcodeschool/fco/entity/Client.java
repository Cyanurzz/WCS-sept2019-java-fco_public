package com.wildcodeschool.fco.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Veuillez entrer un prénom !")
	@Pattern(regexp = "^[a-zA-Z]*", message = "Veuillez entrer un prénom valide !")
	@Column(length = 50)
	private String firstname;
	@Column(length = 50)
	@NotNull(message = "Veuillez entrer un nom")
	@Pattern(regexp = "^[a-zA-Z]*", message = "Veuillez entrer un nom valide !")
	private String lastname;
	@NotNull(message = "Veuillez entrer un numéro de téléphone !")
	@Pattern (regexp = "\\d{10}|\\+33\\d{9}|\\+33\\s\\d{1}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}|\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}", message = "Veuillez entrer un numéro valide !")
	private String phoneNumber;
	@Column(length = 100)
	@NotNull(message = "Veuillez entrer un email")
	@Pattern(regexp = "^(.+)@(.+)$", message = "Veuillez entrer un email valide !")
	private String email;
    @Column(columnDefinition = "TEXT")
	private String message;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	private Boolean isValid ;
	
	public Client() {
		super();
		this.isValid = false;
	}
    
	public Client(
			@NotNull(message = "Veuillez entrer un prénom !") @Pattern(regexp = "^[a-zA-Z]*", message = "Veuillez entrer un prénom valide !") String firstname,
			@NotNull(message = "Veuillez entrer un nom") @Pattern(regexp = "^[a-zA-Z]*", message = "Veuillez entrer un nom valide !") String lastname,
			@NotNull(message = "Veuillez entrer un numéro de téléphone !") @Pattern(regexp = "\\d{10}|\\+33\\d{9}|\\+33\\s\\d{1}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}|\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}", message = "Veuillez entrer un numéro valide !") String phoneNumber,
			String email, String message, Cart panier) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.message = message;
		this.cart = panier;
		this.isValid = false;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
   
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	
	
	

}
