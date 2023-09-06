package com.example.RestaurantManagement.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.RestaurantManagement.Model.Restaurant;

import jakarta.mail.internet.*;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	@Async
	public void sendEmail(String toEmail,String subject,String message)
	{
	SimpleMailMessage mailMessage=new SimpleMailMessage();
	mailMessage.setTo(toEmail);
	mailMessage.setSubject(subject);
	mailMessage.setText(message);
	
	mailMessage.setFrom("shrutidhere2001@gmail.com");
	javaMailSender.send(mailMessage);
	

}
}