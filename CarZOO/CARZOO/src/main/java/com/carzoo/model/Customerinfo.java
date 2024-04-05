package com.carzoo.model;

import org.hibernate.annotations.OnDelete;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customerinfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private int id;
	private String cust_name;
	private String dateofpurchase;
	private String phno;
	private String sellingprice;
	private String email;
	
	private int carid;
	public Customerinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customerinfo(int id, String cust_name, String dateofpurchase, String phno, String sellingprice,
			int carid) {
		super();
		this.id = id;
		this.cust_name = cust_name;
		this.dateofpurchase = dateofpurchase;
		this.phno = phno;
		this.sellingprice = sellingprice;
		this.carid = carid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSellingprice() {
		return sellingprice;
	}
	public void setSellingprice(String sellingprice) {
		this.sellingprice = sellingprice;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	
	
	
	
	
}
