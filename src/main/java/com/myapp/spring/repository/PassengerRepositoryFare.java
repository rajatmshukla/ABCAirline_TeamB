package com.myapp.spring.repository;



import com.myapp.spring.model.ProductFare;

public interface PassengerRepositoryFare {

	int calcFuelCost(ProductFare p1);

	int addExpense(ProductFare p1);
	
	int perSeatCalc(ProductFare p1);
	
	int exclusiveCalc(ProductFare p1);
	
	int splDayCalc (ProductFare p1);
	
	String dispFare(String Flight_name, String classf);

	ProductFare Notifyuser(String Flight_name , String classf);
	

	
}
