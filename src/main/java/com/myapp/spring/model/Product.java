package com.myapp.spring.model;

public class Product {

	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private Integer flightid;
	private String traveldate;
	private String feedback;
	private Integer rating;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String firstname, String lastname, String email, String mobile, Integer flightid, String traveldate,
			String feedback, Integer rating) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.flightid = flightid;
		this.traveldate = traveldate;
		this.feedback = feedback;
		this.rating = rating;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getFlightid() {
		return flightid;
	}

	public void setFlightid(Integer flightid) {
		this.flightid = flightid;
	}

	public String getTraveldate() {
		return traveldate;
	}

	public void setTraveldate(String traveldate) {
		this.traveldate = traveldate;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
