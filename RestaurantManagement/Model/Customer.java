package com.example.RestaurantManagement.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	private String fullName;
	private Integer age;
	private String gender;
	private String mobileNumber;
	private String email;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private FoodCart foodcart;


	public Integer getCustomerId() {
		return customerId;
	}


	public String getFullName() {
		return fullName;
	}


	public Integer getAge() {
		return age;
	}


	public String getGender() {
		return gender;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public String getEmail() {
		return email;
	}


	public Address getAddress() {
		return address;
	}


	public FoodCart getFoodcart() {
		return foodcart;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public void setFoodcart(FoodCart foodcart) {
		this.foodcart = foodcart;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", age=" + age + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + ", foodcart="
				+ foodcart + "]";
	}
	
	
	


}
