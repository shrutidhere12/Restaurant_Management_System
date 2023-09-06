package com.example.RestaurantManagement.RestaurantInterface;

import java.sql.Date;
import java.util.List;

import com.example.RestaurantManagement.Model.User;
import com.example.RestaurantManagement.RestaurantRepository.UserRepository;

import jakarta.mail.internet.ParseException;

public interface UserService {
	public void addUser(User obj);
	public List<User> findBookedUsersByRestId(long restaurantId);
	
	void deleteUserByDateRange(Date fromDate1, Date toDate2);
}
