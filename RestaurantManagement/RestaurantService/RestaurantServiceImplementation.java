package com.example.RestaurantManagement.RestaurantService;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.RestaurantManagement.Model.Restaurant;
import com.example.RestaurantManagement.RestaurantInterface.RestaurantService;
import com.example.RestaurantManagement.RestaurantRepository.RestaurantRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;


/* The RestaurantServiceImplementation class is a service class that provides the business logic 
   It implements the RestaurantService interface to perform operations(Insert, Read, Update, Delete) on items.
  */

@Service
public class RestaurantServiceImplementation  implements RestaurantService{
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	
	public RestaurantServiceImplementation(RestaurantRepository restRepository) {
		this.restaurantRepository = restRepository;
	}

	//save Restaurant data into database
	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant); 
	}

	//get all Restaurants from Database

	public List<Restaurant> getAllRestaurants(String name) {
		List<Restaurant> restaurant = new ArrayList<Restaurant>();

		if (name == null) 
			restaurantRepository.findAll().forEach(restaurant::add);
		else
			restaurantRepository.findByRestaurantNameContainingIgnoreCase(name).forEach(restaurant::add);
		
		return restaurant;
	}

		
	//get Restaurant by id
	@Override
	public Optional<Restaurant> getRestaurantById(int restaurantId) { 
		Optional<Restaurant> restaurant=restaurantRepository.findById(restaurantId);
		return restaurant;
	}
	

	//update restaurant by id through Database
	@Override
	public Restaurant updateRestaurantDetails( Optional<Restaurant> existingRestaurant,Restaurant newRestaurantData) {

		Restaurant restaurant=existingRestaurant.get();
		restaurant.setAvgCost(newRestaurantData.getAvgCost());
		restaurant.setOwnerName(newRestaurantData.getOwnerName());
		restaurant.setRatings(newRestaurantData.getRatings());
		restaurant.setRestaurantName(newRestaurantData.getRestaurantName());
		restaurant.setIsVegRestaurant(newRestaurantData.getIsVegRestaurant());
		restaurant.setLocation(newRestaurantData.getLocation());
		return restaurantRepository.save(restaurant);
	}
	

	//delete restaurant by id from Database
	@Override
	public void deleteRestaurantById(int restaurantId) {
		restaurantRepository.deleteById(restaurantId);
	}


	// get restaurant by name from Database
//	public Restaurant getRestaurantByName(String restaurantName) { 
//		
//	}
	
	
	//Delete All data from Database
	public void deleteAllRestaurants() {
		restaurantRepository.deleteAll();	
	}
	
	
	//get RestaurantDetails By RestaurantName from Restaurant database
	public List<Restaurant>getByRestaurantDetailsByRestaurantName(String restaurantName) {
		List<Restaurant> RestaurantList = new ArrayList<>();
		restaurantRepository.findByRestaurantNameContainingIgnoreCase(restaurantName).forEach(RestaurantList::add);
		return RestaurantList;
	}
	
	//search NonVegRestaurants and VegRestaurant Restaurant Data to the Database   
	public List<Restaurant> findByIsVegRestaurant(boolean status) {
		return restaurantRepository.findByIsVegRestaurant(status);
	}



	public List<Restaurant> getAllRestaurantsByLoc(String location) {
		
		List<Restaurant> restaurant = new ArrayList<Restaurant>();
		restaurantRepository.findByLocationContainingIgnoreCase(location).forEach(restaurant::add);
		return restaurant;
	}

	public List<Restaurant> getAllRestaurantsByPriceDesc(String direction, String price) {
		List<Restaurant> restaurant = restaurantRepository.findAll(Sort.by( getSortDirection(direction), price));
		return restaurant;
	}

	public List<Restaurant> getAllRestaurantsByRatingsDesc(String direction, String ratings) {
		List<Restaurant> restaurant = restaurantRepository.findAll(Sort.by(getSortDirection(direction), ratings));
		return restaurant;
	}
	
	private Sort.Direction getSortDirection(String direction) {
	    if (direction.equals("asc")) {
	    	System.out.println(" came here");
	      return Sort.Direction.ASC;
	    } else if (direction.equals("desc")) {
	    	System.out.println(" came here desc");
	      return Sort.Direction.DESC;
	    }
	 
	    return Sort.Direction.ASC;
	  }
}