package com.example.RestaurantManagement.RestuarantController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestaurantManagement.Model.Restaurant;
import com.example.RestaurantManagement.RestaurantService.EmailService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	@RequestMapping("/")
	public ResponseEntity<String> checkEmail(@RequestParam(required = false) String userEmail, @RequestBody Restaurant restDetails )  //user email, rest obj(@request Body 
	{
		String restName=restDetails.getRestaurantName();
		String strMsg = restDetails.getLocation()+" "+restDetails.getRestaurantName()+" "+restDetails.getIsVegRestaurant();
		
	System.out.println(restDetails);	
	emailService.sendEmail(userEmail, "Your table booking is confirmed!", "We are happy to inform you that your booking for a table in "
			+ " Restaurant Name:"+ restName +" is confirmed! You can find your party’s booking information below.\n"
			+strMsg+" ");
	return new ResponseEntity<>("Message Send",HttpStatus.CREATED);
	}
}
