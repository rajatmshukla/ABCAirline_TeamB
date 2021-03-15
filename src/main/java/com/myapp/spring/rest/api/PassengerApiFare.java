package com.myapp.spring.rest.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.repository.PassengerRepositoryFare;

@RestController
@RequestMapping("/calc")

public class PassengerApiFare {

	@Autowired

	private PassengerRepositoryFare repository;
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@GetMapping("/{Flight_name}/{classf}")
	public String dispFare (@PathVariable("Flight_name") String Flight_name, @PathVariable("classf") String classf) 
	{
		try
		{
		return "<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br> <h3>Hello current fare for flight:" + Flight_name + " for " + classf
				+ " class</h3><h5> as ON : "+"   is:</h5><h3> Rs. " + repository.dispFare(Flight_name,classf)+ "</h3><h3>HAVE A NICE DAY </h3>" + "</body> </html>";
		}
		catch (Exception e){
			return "<html><body>"
					+ "<h1>We have run into an error!!</h1><br> <h3>Your Flightname/class is not present in our database.<br>Please check your flightname/class again</h3>"
					+ "</body></html>";
		}
	}


}
