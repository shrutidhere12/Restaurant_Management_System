package com.example.RestaurantManagement.RestaurantService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestaurantManagement.Model.Admin;
import com.example.RestaurantManagement.RestaurantRepository.adminRepository;

@Service
public class adminServiceImplementation{

	@Autowired
	private adminRepository adminRepo;
	
	public void addadmin(Admin admin) {
		
		this.adminRepo.save(admin);
		
	}

	public Optional<Admin> getadminByEmail(String email) {
		
		return this.adminRepo.findByadminEmail(email);
		
	}


}