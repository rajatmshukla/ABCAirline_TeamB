package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airline")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String Username;
	private String Password;
	private String privileges;
	private String Firstname;
	private String Lastname;
	private Integer Age;
	private String Gender;
	private Integer Mobile;
	private String Email;
	private String ArrivalCity;
	private String DepartureCity;
	private Integer TravelDate;
	private Integer Type;
	private String SeatNo;
	private Integer NumOfPassenger;
	private Integer NumOfBags;
	private Integer TotalFare;

	public Product() {

	}

	public String getUsername(String string) {
		return Username;
	}

	public Product(String Username, String Password, Integer TotalFare, String Firstname, String Lastname,
			Integer TravelDate, String SeatNo) {
		this.Username = Username;
		this.Password = Password;
		this.TotalFare = TotalFare;
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.SeatNo = SeatNo;
		this.TravelDate = TravelDate;

	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public Integer TotalFare() {
		return TotalFare;
	}

	public void setTotalFare(Integer TotalFare) {
		this.TotalFare = TotalFare;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void Firstname(String Firstname) {
		this.Firstname = Firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void Lastname(String Lastname) {
		this.Lastname = Lastname;
	}

	public String getSeatNo() {
		return SeatNo;
	}

	public void setSeatNo(String SeatNo) {
		this.SeatNo = SeatNo;
	}

	public Integer getTravelDate() {
		return TravelDate;
	}

	public void setTravelDate(Integer TravelDate) {
		this.TravelDate = TravelDate;
	}

}
