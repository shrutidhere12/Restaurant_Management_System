package com.example.RestaurantManagement.Model;

import javax.persistence.Entity;

import java.util.ArrayList;



import OneToMany.Courses;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.*;


@Entity
public class FoodCart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cartId;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private User user;
//	
//	
//	@OneToMany(targetEntity = Menu.class,cascade = CascadeType.ALL)
//	private List<Menu>menuList;


	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public List<Menu> getMenuList() {
//		return menuList;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public void setMenuList(List<Menu> menuList) {
//		this.menuList = menuList;
//	}
//
//	@Override
//	public String toString() {
//		return "FoodCart [cartId=" + cartId + ", user=" + user + ", menuList=" + menuList + "]";
//	}

	public FoodCart() {
	
	}


	

	

}
