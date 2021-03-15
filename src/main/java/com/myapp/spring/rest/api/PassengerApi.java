package com.myapp.spring.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.PassengerRepository;

@RestController
@RequestMapping("/airline")

public class PassengerApi {

	@Autowired
	private PassengerRepository repository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping
	public List<Product> getAll() {
		return repository.findAll();
	}

	@GetMapping("/login/notify/{Username}")
	public String Notifyuser(@PathVariable("Username") String Username) {

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

			return "<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br> <h3>Hello</h3>" + firstname + " " + lastname
					+ "<h3>Your Travel is Scheduled ON : <br>" + traveldate + "<h3>Your Seat No. Is : <br>" + seatno
					+ "<h3>THANK YOU FOR FLYING WITH US! <br>" + "</body> </html>";

		} catch (Exception e) {
			return "<html><body>"
					+ "<h1>We have run into an error!!</h1><br> <h3>Your Username is not present in our database.<br>Please check your username again</h3>"
					+ "</body></html>";
		}

	}

	@GetMapping("/error")
	public String error() {
		return "<html><body>" + "<h1>Checkin </h1><br> <h3>Your checin not done</h3>" + "</body></html>";
	}

}