package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airline")
public class Productinvoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String username;
	private String pass;
	private String privileges;
	private String firstname;
	private String lastname;
	private Integer age;
	private String gender;
	private String mobile;
	private String email;
	private String arrivalCity;
	private String departureCity;
	private String travelDate;
	private String seatNo;
	private Integer numOfPassenger;
	private Integer numOfBags;
	private Integer totalFare;

	public Productinvoice() {
	}

	public Productinvoice(String username, String pass, String privileges, String firstname, String lastname,
			Integer age, String gender, String mobile, String email, String arrivalCity, String departureCity,
			String travelDate, String seatNo, Integer numOfPassenger, Integer numOfBags, Integer totalFare) {
		super();
		this.username = username;
		this.pass = pass;
		this.privileges = privileges;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.arrivalCity = arrivalCity;
		this.departureCity = departureCity;
		this.travelDate = travelDate;
		this.seatNo = seatNo;
		this.numOfPassenger = numOfPassenger;
		this.numOfBags = numOfBags;
		this.totalFare = totalFare;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
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

	public Integer getNumOfPassenger() {
		return numOfPassenger;
	}

	public void setNumOfPassenger(Integer numOfPassenger) {
		this.numOfPassenger = numOfPassenger;
	}

	public Integer getNumOfBags() {
		return numOfBags;
	}

	public void setNumOfBags(Integer numOfBags) {
		this.numOfBags = numOfBags;
	}

	public Integer getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Integer totalFare) {
		this.totalFare = totalFare;
	}

	
}
