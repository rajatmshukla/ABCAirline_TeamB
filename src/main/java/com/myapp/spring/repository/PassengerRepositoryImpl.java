package com.myapp.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Product;

@Repository
public class PassengerRepositoryImpl implements PassengerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		// return null;
		return jdbcTemplate.query("select * from airline", new BeanPropertyRowMapper<>(Product.class));
	}

	@Override
	public Product Notifyuser(String Username) {
		return jdbcTemplate.queryForObject("select Firstname,Lastname,TravelDate,SeatNo from airline where Username=?",
				new BeanPropertyRowMapper<>(Product.class), Username);
	}
}