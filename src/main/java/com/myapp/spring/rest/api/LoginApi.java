package com.myapp.spring.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.ProductLogin;
import com.myapp.spring.repository.PassengerRepositoryLogin;

@RestController
@RequestMapping("/airline")
public class LoginApi {

	@Autowired
	private PassengerRepositoryLogin repository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/login/{Username}/{Password}")
	public String findByUsername(@PathVariable("Username") String Username, @PathVariable("Password") String Password) {

		try {
			String query = "select Username from registry where Username=?";
			Object[] inputs = new Object[] { Username };
			String username1 = jdbcTemplate.queryForObject(query, String.class, inputs);
			String query1 = "select Password from registry where Password=?";
			Object[] inputs1 = new Object[] { Password };
			String password2 = jdbcTemplate.queryForObject(query1, String.class, inputs1);

			return "<html><body>" + "<h1>login Details</h1><br> <h3>Your Username" + username1 + password2
					+ " is present in our database.<br>Congratulations your login Done!</h3>" + "</body></html>";
		} catch (Exception e) {
			return "<html><body>"
					+ "<h1>login Details</h1><br> <h3>Your username is not present in our database.<br>Unfortunatly your login is NOT DONE</h3>"
					+ "</body></html>";
		}
	}

	@GetMapping("/login")
	public String welcome() {
		return "<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br> <h3>login </h3>" + "</body></html>";
	}

	@GetMapping
	public List<ProductLogin> getAll() {
		return repository.findAll();
	}

	@PostMapping
	public ProductLogin saveNewProduct(@RequestBody ProductLogin product) {
		return repository.saveProduct(product);
	}

}