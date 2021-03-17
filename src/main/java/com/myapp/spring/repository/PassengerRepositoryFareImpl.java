package com.myapp.spring.repository;



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
	public ProductFare Notifyuser(String flightname,String classf) {
		return jdbcTemplate.queryForObject("select duration,fuel_price,maintanence_charges,food_beverages,capacity,technical_exp,miscellaneous from farecalc where (Flight_name=? and classf=?)",
				new BeanPropertyRowMapper<>(ProductFare.class), flightname,classf);
	}


	@Override
	public int calcFuelCost(ProductFare p1) {
		return (p1.getDuration()*p1.getFuelprice()*2508);
	}

	@Override
	public int addExpense(ProductFare p1) {
		return (p1.getMaintanencecharges()+p1.getFoodbeverages()+p1.getTechnicalexp()+p1.getMiscellaneous());
	}

	@Override
	public int perSeatCalc(ProductFare p1) {
		if(p1.getCapacity()!=0)
		{
		return ((p1.getMaintanencecharges()+p1.getFoodbeverages()+p1.getTechnicalexp()+p1.getMiscellaneous())/p1.getCapacity());
		}
		else
			return 0;
	}

	            

	@Override
	public String dispFare(String Flight_name, String classf) {
		ProductFare p2=Notifyuser(Flight_name,classf);
		int ans=(calcFuelCost(p2)+addExpense(p2)+perSeatCalc(p2));
		if (classf.equalsIgnoreCase("business"))
		{
			ans=ans*3;
		}
		
		
		 return Integer.toString(ans);
		
	}

}