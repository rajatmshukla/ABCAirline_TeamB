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
		jdbcTemplate.update("insert into crm values (?,?,?,?,?,?,?,?)", product.getFirstname(), product.getLastname(),
				product.getEmail(), product.getMobile(), product.getFlightid(), product.getTraveldate(),
				product.getFeedback(), product.getRating());
		return product;
	}

	
	@Override
	public List<Product> findAll(String product) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select firstname from crm where firstname=?",
				new BeanPropertyRowMapper<>(Product.class),product);
	}
	@Override
	public Product findByName(String firstname) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from crm where firstname=?",
				new BeanPropertyRowMapper<>(Product.class), firstname);
	}

}