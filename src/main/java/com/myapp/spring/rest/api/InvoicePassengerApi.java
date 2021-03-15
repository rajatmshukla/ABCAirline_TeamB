package com.myapp.spring.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Productinvoice;
import com.myapp.spring.repository.PassengerRepositoryInvoice;

@RestController
@RequestMapping("/airline")

public class InvoicePassengerApi {

	@Autowired
	private PassengerRepositoryInvoice repository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping
	public List<Productinvoice> getAll() {
		return repository.findAll();
	}

	@GetMapping("/invoice/{Username}")
	public String getInvoice(@PathVariable("Username") String Username) {

		try {
			Object[] inputs = new Object[] { Username };
			String query = "select Username from airline where Username=?";
			String username = jdbcTemplate.queryForObject(query, String.class, inputs);

			String query1 = "select Firstname from airline where Username=?";
			String firstname = jdbcTemplate.queryForObject(query1, String.class, inputs);

			String query2 = "select Lastname from airline where Username=?";
			String lastname = jdbcTemplate.queryForObject(query2, String.class, inputs);

			String query3 = "select TravelDate from airline where Username=?";
			String traveldate = jdbcTemplate.queryForObject(query3, String.class, inputs);

			String query4 = "select SeatNo from airline where Username=?";
			String seatno = jdbcTemplate.queryForObject(query4, String.class, inputs);

			String query5 = "select Age from airline where Username=?";
			String age = jdbcTemplate.queryForObject(query5, String.class, inputs);

			String query6 = "select Gender from airline where Username=?";
			String gender = jdbcTemplate.queryForObject(query6, String.class, inputs);

			String query7 = "select Mobile from airline where Username=?";
			String mobile = jdbcTemplate.queryForObject(query7, String.class, inputs);

			String query8 = "select Email from airline where Username=?";
			String email = jdbcTemplate.queryForObject(query8, String.class, inputs);

			String query9 = "select Arrivalcity from airline where Username=?";
			String arrivalcity = jdbcTemplate.queryForObject(query9, String.class, inputs);

			String query10 = "select Departurecity from airline where Username=?";
			String departurecity = jdbcTemplate.queryForObject(query10, String.class, inputs);

			String query11 = "select privileges from airline where Username=?";
			String privileges = jdbcTemplate.queryForObject(query11, String.class, inputs);

			String query12 = "select NumOfPassenger from airline where Username=?";
			String numofpassenger = jdbcTemplate.queryForObject(query12, String.class, inputs);

			String query13 = "select NumOfBags from airline where Username=?";
			String numofbags = jdbcTemplate.queryForObject(query13, String.class, inputs);

			String query14 = "select TotalFare from airline where Username=?";
			String totalfare = jdbcTemplate.queryForObject(query14, String.class, inputs);

			return "<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br>" + "<h3>Hello " + firstname + " " + lastname
					+ "<br>" + "<h3>Your Travel is scheduled for " + traveldate + "<br>" + "<h3>Your Seat No. is "
					+ seatno + "<br>" + "<h3>Privileges : " + privileges + "<br>" + "<h3>Age : " + age + "<br>"
					+ "<h3>Gender : " + gender + "<br>" + "<h3>Mobile : " + mobile + "<br>" + "<h3>Email : " + email
					+ "<br>" + "<h3>Arrival City : " + arrivalcity + "<br>" + "<h3>Departure City : " + departurecity
					+ "<br>" + "<h3>Num of Passengers : " + numofpassenger + "<br>" + "<h3> Num of Bags : " + numofbags
					+ "<br>" + "<h3>Total Fare : " + totalfare + "<br>" + "<h3>Thank you for flying with us... <br>"
					+ "</body> </html>";

		} catch (Exception e) {
			return "<html><body>"
					+ "<h1>We have run into an error!!</h1><br> <h3>Your Username is not present in our database.<br>Please check your username again</h3>"
					+ "</body></html>";
		}

	}

}