package com.wildcodeschool.fco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String picture;
	private double price;
	private Integer quantity;
	private Integer quantityXs;
	private Integer quantityS;
	private Integer quantityM;
	private Integer quantityL;
	private Integer quantityXl;
	private Integer quantityXxl;

	
	public Product() {}

	
	public Product(Integer id, String name, String description, String picture, double price, Integer quantity, Integer quantityXs, Integer quantityS, Integer quantityM, Integer quantityL, Integer quantityXl, Integer quantityXxl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.price = price;
		this.quantity = quantity;
		this.quantityXs = quantityXs;
		this.quantityS = quantityS;
		this.quantityM = quantityM;
		this.quantityL = quantityL;
		this.quantityXl = quantityXl;
		this.quantityXxl = quantityXxl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Integer getQuantityXs() {
		return quantityXs;
	}



	public void setQuantityXs(Integer quantityXs) {
		this.quantityXs = quantityXs;
	}



	public Integer getQuantityS() {
		return quantityS;
	}



	public void setQuantityS(Integer quantityS) {
		this.quantityS = quantityS;
	}



	public Integer getQuantityM() {
		return quantityM;
	}



	public void setQuantityM(Integer quantityM) {
		this.quantityM = quantityM;
	}



	public Integer getQuantityL() {
		return quantityL;
	}



	public void setQuantityL(Integer quantityL) {
		this.quantityL = quantityL;
	}



	public Integer getQuantityXl() {
		return quantityXl;
	}



	public void setQuantityXl(Integer quantityXl) {
		this.quantityXl = quantityXl;
	}



	public Integer getQuantityXxl() {
		return quantityXxl;
	}



	public void setQuantityXxl(Integer quantityXxl) {
		this.quantityXxl = quantityXxl;
	}
	
	
	
}
