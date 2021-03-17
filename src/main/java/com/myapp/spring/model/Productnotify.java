package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airline")
public class Productnotify {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String username;
	private String firstname;
	private String lastname;
	private String travelDate;
	private String seatNo;

	public Productnotify() {

	}

	public Productnotify(String username, String firstname, String lastname, String travelDate, String seatNo) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.travelDate = travelDate;
		this.seatNo = seatNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	
}
