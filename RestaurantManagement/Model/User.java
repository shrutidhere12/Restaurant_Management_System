package com.example.RestaurantManagement.Model;

import java.sql.Date;
import java.util.List;

import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_table")
@DynamicUpdate
public class User {

		
	@Id
		private Integer userID;
		private String userName;
		private Date date;  //lended date  //localdate --> 23-09-1994
		private String userEmail;
		
		@ManyToOne()
		@JoinColumn(name="restaurantId")
		private Restaurant restDetails;
		
		
  
//		@OneToOne(mappedBy = "user")
//		private OrderDetails orderDet;
//		
//
//		public OrderDetails getOrderDet() {
//			return orderDet;
//		}
//
//		public void setOrderDet(OrderDetails orderDet) {
//			this.orderDet = orderDet;
//		}

		
		public User() {
			
		}

		public Integer getUserID() {
			return userID;
		}

		public String getUserName() {
			return userName;
		}

		public Date getDate() {
			return date;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public Restaurant getRestDetails() {
			return restDetails;
		}


		public void setUserID(Integer userID) {
			this.userID = userID;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public void setDate(Date date) {
			this.date = date;
		}


		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}


		public void setRestDetails(Restaurant restDetails) {
			this.restDetails = restDetails;
		}

		@Override
		public String toString() {
			return "User [userID=" + userID + ", userName=" + userName + ", date=" + date + ", userEmail=" + userEmail
					+ ", restDetails=" + restDetails + "]";
		}

		
}
