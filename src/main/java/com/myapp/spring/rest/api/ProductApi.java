package com.myapp.spring.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.PassengerRepository;

@RestController
@RequestMapping("/airline")
public class ProductApi {

	@Autowired
	private PassengerRepository repository;

	@GetMapping
	public List<Product> getAll() {
		return repository.findAll();

	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostMapping
	public Product saveNewProduct(@RequestBody Product product) {
		return repository.saveProduct(product);
	}

}
