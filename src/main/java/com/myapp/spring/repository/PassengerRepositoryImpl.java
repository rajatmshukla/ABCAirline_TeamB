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
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into registry values (?,?)", product.getUsername(), product.getPassword());
		return product;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from registry", new BeanPropertyRowMapper<>(Product.class));
	}

	@Override
	public Product findByUsername(String Username, String Password) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from registry where Username=? and Password=?",
				new BeanPropertyRowMapper<>(Product.class), Username, Password);
	}

}