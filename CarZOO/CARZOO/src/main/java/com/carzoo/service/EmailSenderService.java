package com.carzoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	
	public void sendemail(String to,String subject,String body) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("admin mail id");
		msg.setTo(to);
		msg.setText(body);
		msg.setSubject(subject);
		
		
		javaMailSender.send(msg);
		
		System.out.println("Mail sned successfully to "+ to);
	}
}
