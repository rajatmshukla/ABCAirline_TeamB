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

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;

@RestController
@RequestMapping("/airline")
public class ProductApi {

	@Autowired
	private ProductRepository repository;

	@GetMapping
	public List<Product> getAll() {
		return repository.findAll();

	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/login/{Username}/{Password}")
	public String findByUsername(@PathVariable("Username") String Username, @PathVariable("Password") String Password) {

		try {
			String query = "select Username from registry where Username=?";
			Object[] inputs = new Object[] { Username };
			String username = jdbcTemplate.queryForObject(query, String.class, inputs);
			String query1 = "select Password from registry where Password=?";
			Object[] inputs1 = new Object[] { Password };
			String password = jdbcTemplate.queryForObject(query1, String.class, inputs1);

			// return Integer.toString(empName);
			return "<html><body>" + "<h1>Welcome To Abc Airline Service</h1><br> <h3>Mr. " + username
					+ " You can serach for our flight</h3>" + "</body></html>";

		} catch (Exception e) {
			return "<html><body>"
					+ "<h1>Sorry!</h1><br> <h3>This Username is not registered <br> Please register soon.</h3>"
					+ "</body></html>";
		}

	}

	@PostMapping
	public Product saveNewProduct(@RequestBody Product product) {
		return repository.saveProduct(product);
	}

}
