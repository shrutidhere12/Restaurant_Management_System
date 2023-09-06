package com.example.RestaurantManagement.RestaurantRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.RestaurantManagement.Model.Menu;

import jakarta.transaction.Transactional;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

	@Modifying
	@Transactional
	@Query(value = "SELECT * FROM Menu_table p WHERE p.restaurant_id = ?1",nativeQuery = true)
	public List<Menu> getFoodByRestId(long restaurantId);
	
//	@Transactional
//	void deleteByrestaurantId(int restId);

}
