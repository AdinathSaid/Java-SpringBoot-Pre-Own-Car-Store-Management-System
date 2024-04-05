package com.carzoo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carzoo.model.CarInfo;
import com.carzoo.repository.CarRepository;
@Service
public class CarService  {
	@Autowired
	CarRepository carRepository;
	
	public void savecardetails(CarInfo carInfo) {
		carRepository.save(carInfo);
	}
	public List<CarInfo> getcar(String keyword){
		if(keyword!=null) {
			return carRepository.findAll(keyword);
		}
		return carRepository.findAll();
	}
	public CarInfo getcar(int id) {
		return carRepository.findById(id).get();
	}
	
	String date = LocalDate.now().toString();
	 
	public void savecustomerinfo(CarInfo carInfo) {
		carRepository.updateCarInfoDetails(carInfo.getId(),carInfo.getCust_name(),date,
				carInfo.getSellingprice(),carInfo.getEmail(), carInfo.getTransactionid(), carInfo.getPhno(),carInfo.getStatus());
	}
	public List<CarInfo> getunsoldcar(String keyword){
		if(keyword!=null) {
			return carRepository.findAll(keyword);
		}
		return carRepository.findBystatus();
		
	}
	public List<CarInfo> getsoldcar(String keyword){
		if(keyword!=null) {
			return carRepository.findAllsoldcars(keyword);
		}
		return carRepository.findBysoldstatus();
		
	}
	public List<CarInfo> getunsoldcarbyprice(int buyprice) {
		if(buyprice>=0) {
			return carRepository.findUnsoldCarsBelowBudget(buyprice);
		}
		return carRepository.findBystatus();
	}
	public List<CarInfo> getallunsoldcars(){
		return carRepository.findAll();
	}
	
	public CarInfo getcarbyid(int id) {
		return carRepository.getById(id);
	}
	
}
