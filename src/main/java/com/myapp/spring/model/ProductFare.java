package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farecalc")
public class ProductFare {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String flight_name;
	private String src;
	private String des;
	private String classf;
	private int kms;
	private int duration;
	private int fuel_price;
	private int maintanence_charges;
	private int food_beverages;
	private int capacity;
	private int technical_exp;
	private int miscellaneous;
	private boolean splday;
	
	public ProductFare() {
		
	}
	
	public ProductFare(String flight_name, String src, String des, String classf, int kms, int duration, int fuel_price,
			int maintanence_charges, int food_beverages, int capacity, int technical_exp, int miscellaneous,boolean splday) {
		
		this.flight_name = flight_name;
		this.src = src;
		this.des = des;
		this.classf = classf;
		this.kms = kms;
		this.duration = duration;
		this.fuel_price = fuel_price;
		this.maintanence_charges = maintanence_charges;
		this.food_beverages = food_beverages;
		this.setCapacity(capacity);
		this.technical_exp = technical_exp;
		this.miscellaneous = miscellaneous;
		this.splday=splday;
	}
	public String getFlight_name() {
		return flight_name;
	}
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getClassf() {
		return classf;
	}
	public void setClassf(String classf) {
		this.classf = classf;
	}
	public int getKms() {
		return kms;
	}
	public void setKms(int kms) {
		this.kms = kms;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFuel_price() {
		return fuel_price;
	}
	public void setFuel_price(int fuel_price) {
		this.fuel_price = fuel_price;
	}
	public int getMaintanence_charges() {
		return maintanence_charges;
	}
	public void setMaintanence_charges(int maintanence_charges) {
		this.maintanence_charges = maintanence_charges;
	}
	public int getFood_beverages() {
		return food_beverages;
	}
	public void setFood_beverages(int food_beverages) {
		this.food_beverages = food_beverages;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getTechnical_exp() {
		return technical_exp;
	}
	public void setTechnical_exp(int technical_exp) {
		this.technical_exp = technical_exp;
	}
	public int getMiscellaneous() {
		return miscellaneous;
	}
	public void setMiscellaneous(int miscellaneous) {
		this.miscellaneous = miscellaneous;
	}
	public boolean isSplday() {
		return splday;
	}
	public void setSplday(boolean splday) {
		this.splday = splday;
	}
	
	
	
	
}
