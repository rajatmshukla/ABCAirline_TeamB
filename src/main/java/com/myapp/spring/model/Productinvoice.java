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
	private String TravelDate;
	private String SeatNo;
	private Integer NumOfPassenger;
	private Integer NumOfBags;
	private Integer TotalFare;

	public Productinvoice() {
		// TODO Auto-generated constructor stub
	}

	public Productinvoice(String Username, String Password, String privileges, String Firstname, String Lastname,
			Integer Age, String Gender, Integer Mobile, String Email, String ArrivalCity, String DepartureCity,
			String TravelDate, String SeatNo, Integer NumOfPassenger, Integer NumOfBags, Integer TotalFare) {

		this.Username = Username;
		this.Password = Password;
		this.privileges = privileges;
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.Age = Age;
		this.Gender = Gender;
		this.Mobile = Mobile;
		this.Email = Email;
		this.ArrivalCity = ArrivalCity;
		this.DepartureCity = DepartureCity;
		this.TravelDate = TravelDate;
		this.SeatNo = SeatNo;
		this.NumOfPassenger = NumOfPassenger;
		this.NumOfBags = NumOfBags;
		this.TotalFare = TotalFare;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
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

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer Age) {
		this.Age = Age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	public Integer getMobile() {
		return Mobile;
	}

	public void setMobile(Integer Mobile) {
		this.Mobile = Mobile;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getArrivalCity() {
		return ArrivalCity;
	}

	public void setArrivalCity(String ArrivalCity) {
		this.ArrivalCity = ArrivalCity;
	}

	public String getDepartureCity() {
		return DepartureCity;
	}

	public void setDepartureCity(String DepartureCity) {
		this.DepartureCity = DepartureCity;
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

	public Integer getNumOfPassenger() {
		return NumOfPassenger;
	}

	public void setNumOfPassenger(Integer NumOfPassenger) {
		this.NumOfPassenger = NumOfPassenger;
	}

	public Integer getNumOfBags() {
		return NumOfBags;
	}

	public void setNumOfBags(Integer NumOfBags) {
		this.NumOfBags = NumOfBags;
	}

	public Integer getTotalFare() {
		return TotalFare;
	}

	public void setTotalFare(Integer TotalFare) {
		this.TotalFare = TotalFare;
	}

}
