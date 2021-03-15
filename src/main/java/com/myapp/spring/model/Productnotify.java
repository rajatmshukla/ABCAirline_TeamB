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
	private String Username;
	private String Firstname;
	private String Lastname;
	private String TravelDate;
	private String SeatNo;

	public Productnotify() {

	}

	public Productnotify(String Username, String Firstname, String Lastname, String TravelDate, String SeatNo) {
		this.Username = Username;
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.TravelDate = TravelDate;
		this.SeatNo = SeatNo;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}

	public String getTravelDate() {
		return TravelDate;
	}

	public void setTravelDate(String TravelDate) {
		this.TravelDate = TravelDate;
	}

	public String getSeatNo() {
		return SeatNo;
	}

	public void setSeatNo(String SeatNo) {
		this.SeatNo = SeatNo;
	}
}
