package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.Product;

public interface PassengerRepository {

	Product saveProductcrm(Product product);

	List<Product> findAllcrm(String product);
	
	Product findByNamecrm(String firstname);

	
}
