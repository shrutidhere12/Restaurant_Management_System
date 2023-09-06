package com.example.RestaurantManagement.RestuarantController;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestaurantManagement.Model.OrderDetails;
import com.example.RestaurantManagement.RestaurantService.OrderDetailsServiceImplementation;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderDetailsController {
	
	@Autowired
	private  OrderDetailsServiceImplementation orderDetailsServiceImpl;
	
	

//	 @Autowired
//	    public OrderDetailsController(OrderDetailsServiceImplementation orderDetailsService) {
//	        this.orderDetailsServiceImpl = orderDetailsService;
//	    }
	 

    @PostMapping("/orderFood")
    public ResponseEntity<OrderDetails> createOrder(@RequestBody OrderDetails orderDetails) {
        OrderDetails createdOrder = orderDetailsServiceImpl.createOrder(orderDetails);
        return ResponseEntity.ok(createdOrder);
        
    }
    
    
    
    
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetails> getOrderDetails(@PathVariable Integer orderId) {
        OrderDetails orderDetails = orderDetailsServiceImpl.getOrderDetails(orderId);
        
        if (orderDetails != null) {
            return ResponseEntity.ok(orderDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @GetMapping("/user/details/{userID}")
    public List<OrderDetails> getOrderDetailfromUser(@PathVariable Integer userID) {
    	System.out.println("User ID: " + userID); 
    	
    	 List<OrderDetails> orderDetailsList = orderDetailsServiceImpl.getOrderDetailsfromuser(userID);
    	    
        
        if (orderDetailsList != null) {
        	 System.out.println("Retrieved Order Details: " + orderDetailsList);
        	 return orderDetailsList; 
        } else {
        	 return null; 
        }
    }
    
    
    
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId) {
        orderDetailsServiceImpl.deleteOrder(orderId);
    }
    
    


    @DeleteMapping("/deleteAllUsers")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        try {
        	orderDetailsServiceImpl.deleteAllUsers();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    
//    
//    @GetMapping("/user/{userId}/orders")
//    public ResponseEntity<List<OrderDetails>> getUserOrders(@PathVariable Integer userId) {
//        List<OrderDetails> userOrders = orderDetailsService.getUserOrders(userId);
//        
//        if (!userOrders.isEmpty()) {
//            return ResponseEntity.ok(userOrders);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
