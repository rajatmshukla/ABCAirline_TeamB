package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.ProductLogin;

public interface PassengerRepositoryLogin {

	ProductLogin saveProductLog(ProductLogin product);

	List<ProductLogin> findAllLog();

	ProductLogin findByUsernameLog(String username, String pass);

}
