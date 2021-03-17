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
	private String flightName;
	private String src;
	private String des;
	private String classf;
	private int kms;
	private int duration;
	private int fuelPrice;
	private int maintanenceCharges;
	private int foodBeverages;
	private int capacity;
	private int technicalExp;
	private int miscellaneous;
	private boolean splday;
	
	public ProductFare() {
	}
	
	public ProductFare(String flightname,String classf,int duration, int fuelprice,
			int maintanencecharges, int foodbeverages, int capacity, int technicalexp, int miscellaneous) {
		
		this.flightName = flightname;
		
		this.classf = classf;
		this.duration = duration;
		this.fuelPrice = fuelprice;
		this.maintanenceCharges = maintanencecharges;
		this.foodBeverages = foodbeverages;
		this.capacity=capacity;
		this.technicalExp = technicalexp;
		this.miscellaneous = miscellaneous;
		
	}
	public String getFlightname() {
		return flightName;
	}
	public void setFlightname(String flightname) {
		this.flightName = flightname;
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
	public int getFuelprice() {
		return fuelPrice;
	}
	public void setFuelprice(int fuelprice) {
		this.fuelPrice = fuelprice;
	}
	public int getMaintanencecharges() {
		return maintanenceCharges;
	}
	public void setMaintanencecharges(int maintanencecharges) {
		this.maintanenceCharges = maintanencecharges;
	}
	public int getFoodbeverages() {
		return foodBeverages;
	}
	public void setFoodbeverages(int foodbeverages) {
		this.foodBeverages = foodbeverages;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getTechnicalexp() {
		return technicalExp;
	}
	public void setTechnicalexp(int technicalexp) {
		this.technicalExp = technicalexp;
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
