package com.example.RestaurantManagement.RestaurantRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RestaurantManagement.Model.Item;

@Repository
public interface ItemDAO extends JpaRepository<Item,Integer>{

}