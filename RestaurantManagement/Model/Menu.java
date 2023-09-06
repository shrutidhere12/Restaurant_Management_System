package com.example.RestaurantManagement.Model;
import javax.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Menu_table")
@DynamicUpdate
public class Menu {

		@Id
		private Integer foodId;
		private String foodName;
		private Integer foodPrice;
		private Integer foodQuantity;
		
		@Lob
	    private byte[] imageData;
		
		public byte[] getImageData() {
			return imageData;
		}

		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}

		@ManyToOne
		@JoinColumn(name="restaurantId")
		@OnDelete(action = OnDeleteAction.CASCADE)
		private Restaurant restDetails;
		
		
		

//		
//		@ManyToOne
//	    @JoinColumn(name = "orderId")
//	    private OrderDetails orderDet;
		
		
		
		
		
//		public OrderDetails getOrderDet() {
//			return orderDet;
//		}
//
//		public void setOrderDet(OrderDetails orderDet) {
//			this.orderDet = orderDet;
//		}

		

		public Menu() {
			
		}

		public Integer getFoodId() {
			return foodId;
		}

		public String getFoodName() {
			return foodName;
		}

		public Integer getFoodPrice() {
			return foodPrice;
		}

		public Integer getFoodQuantity() {
			return foodQuantity;
		}

		public Restaurant getRestDetails() {
			return restDetails;
		}

		public void setFoodId(Integer foodId) {
			this.foodId = foodId;
		}

		public void setFoodName(String foodName) {
			this.foodName = foodName;
		}

		public void setFoodPrice(Integer foodPrice) {
			this.foodPrice = foodPrice;
		}

		public void setFoodQuantity(Integer foodQuantity) {
			this.foodQuantity = foodQuantity;
		}

		
		public void setRestDetails(Restaurant restDetails) {
			this.restDetails = restDetails;
		}

		@Override
		public String toString() {
			return "Menu [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", foodQuantity="
					+ foodQuantity + ", imageData=" + Arrays.toString(imageData) + ", restDetails=" + restDetails + "]";
		}

		

		
}
