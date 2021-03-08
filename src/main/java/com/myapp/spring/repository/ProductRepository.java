package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.Product;

public interface ProductRepository {

	Product saveProduct(Product product);

	List<Product> findAll();

	Product findByUsername(String Username, String Password);

}
