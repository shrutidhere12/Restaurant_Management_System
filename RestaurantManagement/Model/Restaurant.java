package com.example.RestaurantManagement.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;



/*In this class, we declare private attribute to represent restaurant details 
	and provide getter and setter for accessing these attributes.
*/


@Entity
@Table(name = "Restaurant_table")
@DynamicUpdate

public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantId;
	
	@Column(name="owner_Name", nullable = false)
	private String ownerName;
	
	@Column(name="Avg_Cost", nullable = false)
	private int avgCost;
	
	@Column(name="Restaurant_Name", nullable = false)
	private String restaurantName;
	
	@Column(name="Ratings", nullable = false)
	private int ratings;
	
	@Column(name="Veg_Restaurant", nullable = false)
	private Boolean isVegRestaurant;
	

	@Column(name="Location", nullable = false)
	private String location;
	
	
//	@OneToMany(targetEntity = Menu.class,cascade = CascadeType.ALL)
//	private List<Menu> menuList = new ArrayList<>();
	
	public Restaurant() {
		
	}

	
	public Restaurant(Integer restaurantId, String ownerName, int avgCost, String restaurantName, int ratings,
			Boolean isVegRestaurant, String location) {
		
		this.restaurantId = restaurantId;
		this.ownerName = ownerName;
		this.avgCost = avgCost;
		this.restaurantName = restaurantName;
		this.ratings = ratings;
		this.isVegRestaurant = isVegRestaurant;
		this.location = location;
	}



	public Integer getRestaurantId() {
		return restaurantId;
	}



	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}



	public Boolean getIsVegRestaurant() {
		return isVegRestaurant;
	}

	public void setIsVegRestaurant(Boolean isVegRestaurant) {
		this.isVegRestaurant = isVegRestaurant;
	}

	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public int getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(int avgCost) {
		this.avgCost = avgCost;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public int getRatings() {
		return ratings;
	}
	
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}



	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", ownerName=" + ownerName + ", avgCost=" + avgCost
				+ ", restaurantName=" + restaurantName + ", ratings=" + ratings + ", isVegRestaurant=" + isVegRestaurant
				+ ", location=" + location + "]";
	}

	
}
