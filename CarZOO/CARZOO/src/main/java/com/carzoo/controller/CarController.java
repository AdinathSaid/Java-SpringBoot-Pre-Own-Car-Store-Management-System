package com.carzoo.controller;

import java.util.List;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.carzoo.model.CarInfo;
import com.carzoo.model.Customerinfo;
import com.carzoo.service.CarService;
import com.carzoo.service.EmailSenderService;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Controller
public class CarController {
	@Autowired
	CarService carService;
	@Autowired
	EmailSenderService emailSenderService;
	
	 @GetMapping("/")
	 public String display() {
		return "home";
	 }
	 @GetMapping("/registercar")
	 public String registercar() {
		return "Registercar";
	 }
	 @PostMapping("/save")
	 public String savecarinfo(@ModelAttribute CarInfo carInfo) {
		 carService.savecardetails(carInfo);
		 return "Registercar";
	 }
//	 @GetMapping("/searchcar")
//		public String getMyCars(org.springframework.ui.Model model,
//				@Param("keyword") String keyword)
//		{
//		 	
//			List<CarInfo> list=carService.getcar(keyword);
//			model.addAttribute("car",list);
//			return "searchcar";
//		}
	 
	 @GetMapping("/sellcar/{id}")
	    public String sellcar(@PathVariable("id") int id,org.springframework.ui.Model model) {//model is used to send the data from controller to view
	    	CarInfo c=carService.getcar(id);
	    	System.out.println(id);
	    	model.addAttribute("unsoldcar", c);
	    	return "sell";
	  	}
	 @PostMapping("/savecustomer")
	 public String savecustomerdetails(@ModelAttribute CarInfo carInfo) {
		 System.out.println(carInfo.getId());
		 System.out.println(carInfo.getCust_name());
		 CarInfo temp=carService.getcarbyid(carInfo.getId());
		 carService.savecustomerinfo(carInfo);
		 String to=carInfo.getEmail();
		 String customername=carInfo.getCust_name();
		 emailSenderService.sendemail(to,"Welcome to CARZOO.Thank You for Your Purchase!","Dear,"+customername+","
		 		+ "Thank you for choosing CARZOO! We appreciate your trust in us for your recent purchase of the "+temp.getBrand_name()+ " "+temp.getCarname()+
		 		" If you need any assistance, feel free to reach out us at carzoo2024@gmail.com"+""
		 				+"[Note:Car engine is under six-month warranty from the date of purchase.]");
		 
		 
		 long profit=temp.getSellingprice()-temp.getBuyprice();
		 
		 emailSenderService.sendemail("carzoo2024@gmail.com"," Car Sold:","[Car_ID:"+temp.getId()
		 																	+ " || Company:"+temp.getBrand_name()				
		 																	+ " || Car Name:"+temp.getCarname()
		 																	
		 																	+ " || Buying price:₹"+temp.getBuyprice()
		 																	+ " || Selling price:₹"+temp.getSellingprice()
		 																	+ " || Total Profit:"+profit+"₹ only]");
		 				
		 return "receipt";
	 }
	 
	 //display unsold cars
	 @GetMapping("/unsoldcar")
	 public String getunsoldcars(org.springframework.ui.Model model,@Param("keyword")String keyword) {

			List<CarInfo> unsoldlist=carService.getunsoldcar(keyword);
			model.addAttribute("unsoldcar",unsoldlist);
			return "unsoldcar";
	 }
	 @GetMapping("/soldcar")
	 public String getsoldcars(org.springframework.ui.Model model,@Param("keyword")String keyword) {

			List<CarInfo> soldlist=carService.getsoldcar(keyword);
			model.addAttribute("soldcar",soldlist);
			return "soldcar";
	 }
	 
	 @PostMapping("/logout")
	 public String logout() {
		 return "";
	 }
	 @PostMapping("/searchbyprice")
	 public String searchbyprice(org.springframework.ui.Model model,@Param("buyprice")int buyprice) {

			List<CarInfo> unsoldlist=carService.getunsoldcarbyprice(buyprice);
			model.addAttribute("unsoldcar",unsoldlist);
			return "unsoldcar";
	 }
	 
	 
	 
	 
	 
	 
	 
	
	 
	 
	 
	 
	 
	 
}
