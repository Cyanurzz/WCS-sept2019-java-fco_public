package com.wildcodeschool.fco.entity;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Time MondayStart;
	private Time MondayEnd;
	private Time TuesdayStart;
	private Time TuesdayEnd;
	private Time WednesdayStart;
	private Time WednesdayEnd;
	private Time ThursdayStart;
	private Time ThursdayEnd;
	private Time FridayStart;
	private Time FridayEnd;
	private Time SaturdayStart;
	private Time SaturdayEnd;
	private Time SundayStart;
	private Time SundayEnd;
	
	
	
	public Training(){}



	public Training(Time mondayStart, Time mondayEnd, Time tuesdayStart, Time tuesdayEnd, Time wednesdayStart,
			Time wednesdayEnd, Time thursdayStart, Time thursdayEnd, Time fridayStart, Time fridayEnd,
			Time saturdayStart, Time saturdayEnd, Time sundayStart, Time sundayEnd) {
		MondayStart = mondayStart;
		MondayEnd = mondayEnd;
		TuesdayStart = tuesdayStart;
		TuesdayEnd = tuesdayEnd;
		WednesdayStart = wednesdayStart;
		WednesdayEnd = wednesdayEnd;
		ThursdayStart = thursdayStart;
		ThursdayEnd = thursdayEnd;
		FridayStart = fridayStart;
		FridayEnd = fridayEnd;
		SaturdayStart = saturdayStart;
		SaturdayEnd = saturdayEnd;
		SundayStart = sundayStart;
		SundayEnd = sundayEnd;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Time getMondayStart() {
		return MondayStart;
	}



	public void setMondayStart(Time mondayStart) {
		MondayStart = mondayStart;
	}



	public Time getMondayEnd() {
		return MondayEnd;
	}



	public void setMondayEnd(Time mondayEnd) {
		MondayEnd = mondayEnd;
	}



	public Time getTuesdayStart() {
		return TuesdayStart;
	}



	public void setTuesdayStart(Time tuesdayStart) {
		TuesdayStart = tuesdayStart;
	}



	public Time getTuesdayEnd() {
		return TuesdayEnd;
	}



	public void setTuesdayEnd(Time tuesdayEnd) {
		TuesdayEnd = tuesdayEnd;
	}



	public Time getWednesdayStart() {
		return WednesdayStart;
	}



	public void setWednesdayStart(Time wednesdayStart) {
		WednesdayStart = wednesdayStart;
	}



	public Time getWednesdayEnd() {
		return WednesdayEnd;
	}



	public void setWednesdayEnd(Time wednesdayEnd) {
		WednesdayEnd = wednesdayEnd;
	}



	public Time getThursdayStart() {
		return ThursdayStart;
	}



	public void setThursdayStart(Time thursdayStart) {
		ThursdayStart = thursdayStart;
	}



	public Time getThursdayEnd() {
		return ThursdayEnd;
	}



	public void setThursdayEnd(Time thursdayEnd) {
		ThursdayEnd = thursdayEnd;
	}



	public Time getFridayStart() {
		return FridayStart;
	}



	public void setFridayStart(Time fridayStart) {
		FridayStart = fridayStart;
	}



	public Time getFridayEnd() {
		return FridayEnd;
	}



	public void setFridayEnd(Time fridayEnd) {
		FridayEnd = fridayEnd;
	}



	public Time getSaturdayStart() {
		return SaturdayStart;
	}



	public void setSaturdayStart(Time saturdayStart) {
		SaturdayStart = saturdayStart;
	}



	public Time getSaturdayEnd() {
		return SaturdayEnd;
	}



	public void setSaturdayEnd(Time saturdayEnd) {
		SaturdayEnd = saturdayEnd;
	}



	public Time getSundayStart() {
		return SundayStart;
	}



	public void setSundayStart(Time sundayStart) {
		SundayStart = sundayStart;
	}



	public Time getSundayEnd() {
		return SundayEnd;
	}



	public void setSundayEnd(Time sundayEnd) {
		SundayEnd = sundayEnd;
	}
	
}
