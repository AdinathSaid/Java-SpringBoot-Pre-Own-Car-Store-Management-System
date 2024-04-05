package com.carzoo.model;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DynamicInsert
public class CarInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand_name;
	private String owner;
	private String engine_type;
	private String engine_cylinder;
	private String transmission;
	private String accidental;
	private String year;
	private String mileage;
	private long buyprice;
	private String carname;
	private long driven;
	@Column(unique = true)
	private String car_number;
	private String car_insurance;
	private String color;
	@ColumnDefault("unsold")
	private String status;
	
	
	
	private String cust_name;
	private String dateofpurchase;
	private String phno;
	private long sellingprice;
	private String email;
	private String transactionid;
	public CarInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarInfo(int id, String brand_name, String owner, String engine_type, String engine_cylinder,
			String transmission, String accidental, String year, String mileage, long buyprice, String carname,
			long driven, String car_number, String car_insurance, String color, String status, String cust_name,
			String dateofpurchase, String phno, long sellingprice, String email, String transactionid) {
		super();
		this.id = id;
		this.brand_name = brand_name;
		this.owner = owner;
		this.engine_type = engine_type;
		this.engine_cylinder = engine_cylinder;
		this.transmission = transmission;
		this.accidental = accidental;
		this.year = year;
		this.mileage = mileage;
		this.buyprice = buyprice;
		this.carname = carname;
		this.driven = driven;
		this.car_number = car_number;
		this.car_insurance = car_insurance;
		this.color = color;
		this.status = status;
		this.cust_name = cust_name;
		this.dateofpurchase = dateofpurchase;
		this.phno = phno;
		this.sellingprice = sellingprice;
		this.email = email;
		this.transactionid = transactionid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getEngine_type() {
		return engine_type;
	}
	public void setEngine_type(String engine_type) {
		this.engine_type = engine_type;
	}
	public String getEngine_cylinder() {
		return engine_cylinder;
	}
	public void setEngine_cylinder(String engine_cylinder) {
		this.engine_cylinder = engine_cylinder;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getAccidental() {
		return accidental;
	}
	public void setAccidental(String accidental) {
		this.accidental = accidental;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public long getBuyprice() {
		return buyprice;
	}
	public void setBuyprice(long buyprice) {
		this.buyprice = buyprice;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public long getDriven() {
		return driven;
	}
	public void setDriven(long driven) {
		this.driven = driven;
	}
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	public String getCar_insurance() {
		return car_insurance;
	}
	public void setCar_insurance(String car_insurance) {
		this.car_insurance = car_insurance;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getDateofpurchase() {
		return dateofpurchase;
	}
	public void setDateofpurchase(String dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public long getSellingprice() {
		return sellingprice;
	}
	public void setSellingprice(long sellingprice) {
		this.sellingprice = sellingprice;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}


	
	
	
	
	
	
}
