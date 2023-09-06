package com.example.RestaurantManagement.RestaurantService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.RestaurantManagement.Model.Menu;

import com.example.RestaurantManagement.RestaurantInterface.MenuService;
import com.example.RestaurantManagement.RestaurantRepository.MenuRepository;
import com.example.RestaurantManagement.RestaurantRepository.OrderDetailsRepository;

@Service
public class MenuServiceImplementation implements MenuService{

	@Autowired
	private MenuRepository menuRepo;
	
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Override
	public void addfood(Menu obj) {
		this.menuRepo.save(obj);
		
	}

	@Override
	public List<Menu> getMenuItemsByRestaurantId(int restaurantId) {
		
		return this.menuRepo.getFoodByRestId(restaurantId);
	}

	@Override
	public Menu saveImage(MultipartFile file, Integer foodId) throws IOException {
		  Menu image = new Menu();
	      	image.setFoodId(foodId);
	        image.setImageData(file.getBytes());
	        return menuRepo.save(image);
	}

	@Override
	public Menu getImageById(int foodId) {
		 return menuRepo.findById(foodId).orElse(null);
		  
	}
	
	
	 public void deleteMenuItemById(int menuId) {
		  /*orderDetailsRepository.deleteOrderByFoodId(menuId);
	        Optional<Menu> menuOptional = menuRepo.findById((long) menuId);

	        if (menuOptional.isPresent()) {*/
	        	menuRepo.deleteById( menuId);
	           // return true;
	        //}

	        //return false;
	    }
	 
	 
	 
	 
	 
	  public void deleteAllMenuItems() {
		  menuRepo.deleteAll();
	    }

	  public Menu getFoodById(int foodId) {
		    Optional<Menu> menuOptional = menuRepo.findById(foodId);

		    if (menuOptional.isPresent()) {
		        return menuOptional.get();
		    }

		    return null;
		}
}
