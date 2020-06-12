package com.wildcodeschool.fco.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "convocation")
public class Convocation {

	@Id
	private Integer id;
	private Date dateMatch;
	private Date dateInvit;
	@Column(columnDefinition = "TEXT")
	private String locationM;
	@Column(columnDefinition = "TEXT")
	private String locationI;
	

	@OneToMany(mappedBy = "convocation", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Player> selection = new ArrayList<>();

	public Convocation() {

	}

	public Convocation(Integer id, Date dateMatch, Date dateInvit, String locationM, String locationI) {
		super();
		this.id = id;
		this.dateMatch = dateMatch;
		this.dateInvit = dateInvit;
		this.locationM = locationM;
		this.locationI = locationI;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}

	public Date getDateInvit() {
		return dateInvit;
	}

	public void setDateInvit(Date dateInvit) {
		this.dateInvit = dateInvit;
	}
	
	


	public String getLocationM() {
		return locationM;
	}

	public void setLocationM(String locationM) {
		this.locationM = locationM;
	}

	public String getLocationI() {
		return locationI;
	}

	public void setLocationI(String locationI) {
		this.locationI = locationI;
	}

	public List<Player> getSelection() {
		return selection;
	}

	public void setSelection(List<Player> selection) {
		this.selection = selection;
	}

}
