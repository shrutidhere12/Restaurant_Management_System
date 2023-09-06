package com.example.RestaurantManagement.RestaurantInterface;
import java.util.List;
import java.util.Optional;

import com.example.RestaurantManagement.Model.Restaurant;


/* The RestaurantService is service interface 
 * and abstract method declaration
  */
public interface RestaurantService {
	
	Restaurant saveRestaurant(Restaurant restaurant);
	List<Restaurant>getAllRestaurants(String allRestaurant);
	Optional<Restaurant> getRestaurantById(int restaurantId);
	Restaurant updateRestaurantDetails(Optional<Restaurant> existingRestaurant, Restaurant newRestaurantData);
	void deleteRestaurantById(int restaurantId);
	void deleteAllRestaurants();
}
