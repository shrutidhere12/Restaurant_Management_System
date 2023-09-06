package com.example.RestaurantManagement.RestuarantController;

import org.springframework.http.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.RestaurantManagement.Model.Menu;
import com.example.RestaurantManagement.Model.User;
import com.example.RestaurantManagement.RestaurantRepository.RestaurantRepository;
import com.example.RestaurantManagement.RestaurantService.MenuServiceImplementation;
import com.example.RestaurantManagement.RestaurantService.RestaurantServiceImplementation;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/food")
public class MenuController {
	
	@Autowired
	private MenuServiceImplementation menuServeImp;
	
	@Autowired
	private RestaurantRepository restRepo;
	
	

	 @GetMapping("/viewmenu/{restId}")
	    public ResponseEntity<List<Menu>> getMenuItemsByRestaurantId(@PathVariable int restId) {
	        List<Menu> menuItems = menuServeImp.getMenuItemsByRestaurantId(restId);

	        if (menuItems.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<>(menuItems, HttpStatus.OK);
	    }
	 
	 
	 
	 @DeleteMapping("/deletemenu/{foodId}")
	 public void deleteMenuItemById(@PathVariable int foodId) {
	      menuServeImp.deleteMenuItemById(foodId);

	    /* if (deleted) {
	         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	     } else {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }*/
	 }

	 
	  @DeleteMapping("/deleteAll")
	    public ResponseEntity<Void> deleteAllMenuItems() {
		  menuServeImp.deleteAllMenuItems();
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	 
	
	@PostMapping("/addFood/{restId}")
	public ResponseEntity<Map<String, String>> addFood(@PathVariable("restId") int restId,
	                                                   @ModelAttribute Menu menu,
	                                                   @RequestParam("file") MultipartFile file) {
	    try {
	        Random rand = new Random();
	        
	        Menu obj = new Menu();
	        obj.setFoodId(rand.nextInt(11111)); // Assign a unique foodId
	        obj.setFoodName(menu.getFoodName());
	        obj.setFoodPrice(menu.getFoodPrice());
	        obj.setFoodQuantity(menu.getFoodQuantity());
	        obj.setRestDetails(this.restRepo.findById(restId).get());
	        
	        // Set image data to the same 'obj' instance
	        obj.setImageData(file.getBytes());
	        
	        this.menuServeImp.addfood(obj); // Implement this method
	        
	        Map<String, String> response = new HashMap<>();
	        response.put("status", "success");
	        response.put("message", "Food item added successfully!");

	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	    } catch (IOException e) {
	        // Handle IO exception
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("status", "error");
	        errorResponse.put("message", "Error uploading image or adding food item.");
	        
	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	  
	  
	  
	  @GetMapping("/foodWithImage/{foodId}")
	  public ResponseEntity<Menu> getFoodWithImage(@PathVariable int foodId) {
	      try {
	          Menu foodItem = menuServeImp.getFoodById(foodId); // Implement this method to get food by ID
	          
	          if (foodItem != null && foodItem.getImageData() != null) {
	              return ResponseEntity
	                      .ok()
	                      .contentType(MediaType.APPLICATION_JSON) // Adjust the content type as needed
	                      .body(foodItem);
	          } else {
	              return ResponseEntity.notFound().build();
	          }
	      } catch (Exception e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	      }
	  }


	
	
	
	
	
	@PostMapping("/image/upload/{id}")
    public String uploadImage( @PathVariable("id") int foodId,@RequestParam("file") MultipartFile file) throws IOException {
		menuServeImp.saveImage(file,foodId);
        return "Image uploaded successfully!";
    }

    @GetMapping("/image/{id}")
    public void getImage(@PathVariable("id") int foodId, HttpServletResponse response) throws IOException {
        Menu image = menuServeImp.getImageById(foodId);

        if (image != null) {
            response.setContentType("image/jpeg"); // Adjust content type as needed
            response.getOutputStream().write(image.getImageData());
            response.getOutputStream().close();
        }
    }


}
