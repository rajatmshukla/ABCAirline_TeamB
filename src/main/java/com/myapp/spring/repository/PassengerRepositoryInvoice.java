package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.Productinvoice;

public interface PassengerRepositoryInvoice {

	List<Productinvoice> findAllInv();

	Productinvoice getInvoice(String username);

}
