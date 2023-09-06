package com.example.RestaurantManagement.RestaurantService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestaurantManagement.Model.Restaurant;
import com.example.RestaurantManagement.Model.User;
import com.example.RestaurantManagement.RestaurantInterface.UserService;
import com.example.RestaurantManagement.RestaurantRepository.UserRepository;

import jakarta.mail.internet.ParseException;

import java.text.SimpleDateFormat;



@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	public void addUser(User obj) {
		
		this.userRepo.save(obj);
	}
	
	public List<User> findBookedUsersByRestId(long restaurantId) {
		
		return this.userRepo.findUsersByRestId(restaurantId);
	}
	
	
	

	@Override
	public void deleteUserByDateRange(Date fromDate1, Date toDate2){
				userRepo.deleteByDateBetween(fromDate1, toDate2);
		
	}

	
		
	/*
	 * 
	 * delete(from, to){
	 * userrepo.detequer();
	 */

}
