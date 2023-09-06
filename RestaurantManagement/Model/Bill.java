package com.example.RestaurantManagement.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Bill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer billId;
	private Integer totalBill;
	
	public Integer getBillId() {
		return billId;
	}
	
	public Integer getTotalBill() {
		return totalBill;
	}
	
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	
	public void setTotalBill(Integer totalBill) {
		this.totalBill = totalBill;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", totalBill=" + totalBill + "]";
	}
	
	

}
