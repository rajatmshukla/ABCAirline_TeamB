package com.myapp.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Productnotify;

@Repository
public class PassengerRepositoryNotifyImpl implements PassengerRepositorynotify {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Productnotify> findAll() {
		return jdbcTemplate.query("select * from airline", new BeanPropertyRowMapper<>(Productnotify.class));
	}

	@Override
	public Productnotify Notifyuser(String Username) {
		return jdbcTemplate.queryForObject("select Firstname,Lastname,TravelDate,SeatNo from airline where Username=?",
				new BeanPropertyRowMapper<>(Productnotify.class), Username);
	}
}