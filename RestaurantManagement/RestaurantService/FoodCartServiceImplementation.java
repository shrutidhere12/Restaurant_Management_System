package com.example.RestaurantManagement.RestaurantService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestaurantManagement.Model.FoodCart;
import com.example.RestaurantManagement.Model.Menu;
import com.example.RestaurantManagement.RestaurantRepository.FoodCartDAO;
import com.example.RestaurantManagement.RestaurantRepository.ItemDAO;
import com.example.RestaurantManagement.RestaurantRepository.MenuRepository;
import java.util.List;
import java.util.ArrayList;



@Service
public class FoodCartServiceImplementation {
//	
//		@Autowired
//		FoodCartDAO  cartDAO;
//
//		@Autowired
//		MenuRepository menuRepo;
//		
//		
//		//@Override
//		public FoodCart saveCart(FoodCart cart) throws Exception {
//			Optional<FoodCart> opt = cartDAO.findById(cart.getCartId());
//			if(opt.isPresent()) {
//				throw new Exception("Cart already exists..");
//			}else {
//				 return cartDAO.save(cart);
//			}
//		}
//
//
//		//@Override
//		public FoodCart clearCart(Integer cartId) throws Exception{
//			Optional<FoodCart> opt = cartDAO.findById(cartId);
//			if(opt.isPresent()) {
//				FoodCart cart = opt.get();
//				cartDAO.delete(cart);
//				return cart;
//			}else {
//				throw new Exception("No Cart found with ID: "+cartId);
//			}
//		}
//
//
//		//@Override
//		public FoodCart viewCart(Integer cartId) throws Exception {
//			Optional<FoodCart> opt = cartDAO.findById(cartId);
//			if(opt.isPresent()) {
//				FoodCart cart = opt.get();
//				return cart;
//			}else {
//				throw new Exception("No Cart found with ID: "+cartId);
//			}
//		}
//
//
//		//@Override
//		public FoodCart addItem(Integer cartId, long foodId) throws Exception, Exception {
//			Optional<FoodCart> cOpt = cartDAO.findById(cartId);
//			if(cOpt.isPresent()) {
//				
//				Optional<Menu> iOpt = menuRepo.findById(foodId);
//				if(iOpt.isPresent()) {
//					
//					FoodCart cart = cOpt.get();
//					Menu menu = iOpt.get();
//					List<Menu> list = new ArrayList<>();
//					list.addAll(cart.getMenuList());
//					list.add(menu);
//					cart.setMenuList(list);
//					
//					return cart;
//					
//				}else {
//					throw new Exception("No Item found with ID: "+foodId);
//				}
//				
//			}else {
//				throw new Exception("No Cart found with ID: "+cartId);
//			}
//		}
//
//
//
//
//

	}


