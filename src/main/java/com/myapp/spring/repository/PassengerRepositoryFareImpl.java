package com.myapp.spring.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.ProductFare;

@Repository
public class PassengerRepositoryFareImpl implements PassengerRepositoryFare {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ProductFare Notifyuser(String Flight_name,String classf) {
		return jdbcTemplate.queryForObject("select duration,fuel_price,maintanence_charges,food_beverages,capacity,technical_exp,miscellaneous from farecalc where (Flight_name=? and classf=?)",
				new BeanPropertyRowMapper<>(ProductFare.class), Flight_name,classf);
	}


	@Override
	public int calcFuelCost(ProductFare p1) {
		
		return (p1.getDuration()*p1.getFuel_price()*2508);
	}

	@Override
	public int addExpense(ProductFare p1) {
		return (p1.getMaintanence_charges()+p1.getFood_beverages()+p1.getTechnical_exp()+p1.getMiscellaneous());
	}

	@Override
	public int perSeatCalc(ProductFare p1) {
		return ((p1.getMaintanence_charges()+p1.getFood_beverages()+p1.getTechnical_exp()+p1.getMiscellaneous())/p1.getCapacity());
	}

	@Override
	public int exclusiveCalc(ProductFare p1) {
		if(p1.getClassf().equals("business"))
		{
		return 0;
		}
		else
			return 1;
	}

	@Override
	public int splDayCalc(ProductFare p1) {
		if(p1.isSplday()==true)
			return 400;
		else
			return 0;
	}

	@Override
	public String dispFare(String Flight_name, String classf) {
		ProductFare p2=Notifyuser(Flight_name,classf);
		double ans=(calcFuelCost(p2)+addExpense(p2)+perSeatCalc(p2)+splDayCalc(p2))/100000;
		if (classf.equalsIgnoreCase("business"))
		{
			ans=ans*3.5;
		}
		
		
		String ans1=Double.toString(ans);
		return ans1;
	}

}