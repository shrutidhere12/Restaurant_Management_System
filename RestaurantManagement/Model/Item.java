package com.example.RestaurantManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemId;
	private String itemName;
	private Integer quantity;
	private Double cost;
	
	
	
	
	public Integer getItemId() {
		return itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public Double getCost() {
		return cost;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", cost=" + cost + "]";
	}


}
