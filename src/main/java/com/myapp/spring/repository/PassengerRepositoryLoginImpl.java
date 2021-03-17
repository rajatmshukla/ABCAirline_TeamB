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
	public List<ProductLogin> findAllLog() {

		return jdbcTemplate.query("select * from registry", new BeanPropertyRowMapper<>(ProductLogin.class));
	}

	@Override
	public ProductLogin findByUsernameLog(String username, String pass) {

		return jdbcTemplate.queryForObject("select * from registry where username=? and pass=?",
				new BeanPropertyRowMapper<>(ProductLogin.class), username, pass);
	}

	@Override
	public ProductLogin saveProductLog(ProductLogin product) {

		jdbcTemplate.update("insert into registry values (?,?)", product.getUsername(), product.getPass());
		return product;
	}

}