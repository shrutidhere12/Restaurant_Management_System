package com.example.RestaurantManagement.RestaurantInterface;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.RestaurantManagement.Model.Menu;
import com.example.RestaurantManagement.Model.Restaurant;
import com.example.RestaurantManagement.Model.User;


public interface MenuService {

	public void addfood(Menu obj);
	
	List<Menu> getMenuItemsByRestaurantId(int restaurantId);
	
	public Menu saveImage(MultipartFile file, Integer foodId) throws IOException;
	
	public Menu getImageById(int foodId);
}
