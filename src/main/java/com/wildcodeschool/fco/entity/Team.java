package com.wildcodeschool.fco.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String image;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "pole_id")
	private Pole pole;
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Player> players;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
	private Training training;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "convocation_id", referencedColumnName = "id")
	private Convocation convocation;
	
	public Team() {}
	
	public Team(Integer id, String name, String image, Pole pole) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.pole = pole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Convocation getConvocation() {
		return convocation;
	}

	public void setConvocation(Convocation convocation) {
		this.convocation = convocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Pole getPole() {
		return pole;
	}

	public void setPole(Pole pole) {
		this.pole = pole;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}
	
}
