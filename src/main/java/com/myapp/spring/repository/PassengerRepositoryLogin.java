package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.ProductLogin;

public interface PassengerRepositoryLogin {

	ProductLogin saveProduct(ProductLogin product);

	List<ProductLogin> findAll();

	ProductLogin findByUsername(String Username, String Password);

}
