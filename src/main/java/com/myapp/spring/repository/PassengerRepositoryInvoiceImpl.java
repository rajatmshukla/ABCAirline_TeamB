package com.myapp.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Productinvoice;

@Repository
public class PassengerRepositoryInvoiceImpl implements PassengerRepositoryInvoice {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Productinvoice> findAllInv() {
		return jdbcTemplate.query("select * from airline", new BeanPropertyRowMapper<>(Productinvoice.class));
	}

	@Override
	public Productinvoice getInvoice(String username) {
		return jdbcTemplate.queryForObject(
				"select Username,Password,privileges,Firstname,Lastname,Age,Gender,Mobile,Email,Arrivalcity,Departurecity,TravelDate,SeatNo,NumOfPassenger,NumOfBags,TotalFare from airline where Username=?",
				new BeanPropertyRowMapper<>(Productinvoice.class), username);
	}
}