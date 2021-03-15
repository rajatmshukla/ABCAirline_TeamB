package com.myapp.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.ProductLogin;

@Repository
public class PassengerRepositoryLoginImpl implements PassengerRepositoryLogin {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ProductLogin> findAll() {

		return jdbcTemplate.query("select * from registry", new BeanPropertyRowMapper<>(ProductLogin.class));
	}

	@Override
	public ProductLogin findByUsername(String Username, String Password) {

		return jdbcTemplate.queryForObject("select * from registry where Username=? and Password=?",
				new BeanPropertyRowMapper<>(ProductLogin.class), Username, Password);
	}

	@Override
	public ProductLogin saveProduct(ProductLogin product) {

		jdbcTemplate.update("insert into registry values (?,?)", product.getUsername(), product.getPassword());
		return product;
	}

}