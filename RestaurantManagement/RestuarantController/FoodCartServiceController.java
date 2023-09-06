package com.example.RestaurantManagement.RestuarantController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestaurantManagement.Model.FoodCart;
import com.example.RestaurantManagement.RestaurantService.FoodCartServiceImplementation;

@RestController
@RequestMapping("/cart")
public class FoodCartServiceController {
	
//
//		@Autowired
//		FoodCartServiceImplementation FoodcartserviceImp;
//
//		
//		@PostMapping("/register")
//		public ResponseEntity<FoodCart> saveCartDetails(@RequestParam String key,@RequestBody FoodCart fc) throws Exception 
//		{
//					
//					
//					if(fc!=null) {
//		            FoodCart f= FoodcartserviceImp.saveCart(fc);
//		            	return new ResponseEntity<FoodCart>(f,HttpStatus.CREATED);
//		            }
//					return new ResponseEntity<FoodCart>(HttpStatus.OK);
//		}
//		
//		
////		@PutMapping("/add/{cartId}/{itemId}")
////		public ResponseEntity<FoodCart> addItemToCart(@PathVariable("cartId") Integer cartId, @PathVariable("itemId") Integer itemId){
////			//FoodCart updatedCart = FoodcartserviceImp.addItem(cartId, itemId);
////			return new ResponseEntity<FoodCart>(updatedCart, HttpStatus.ACCEPTED);
////		}
//		
//		
//		@DeleteMapping("/remove/{cartId}")
//		public ResponseEntity<FoodCart> removeCart(@PathVariable("cartId") Integer cartId) throws Exception {
//			FoodCart removedCart = FoodcartserviceImp.clearCart(cartId);
//			return new ResponseEntity<FoodCart>(removedCart, HttpStatus.OK);
//		}
//		
//		
//		@GetMapping("/view/{cartId}")
//		public FoodCart getCartByCartId(@PathVariable ("cartId") Integer cartId) throws Exception{
//			
//				return FoodcartserviceImp.viewCart(cartId);
//				
//		}

	}


