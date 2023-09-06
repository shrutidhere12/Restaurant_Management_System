package com.example.RestaurantManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




/* @SpringBootApplication: A convenience annotation that combines @Configurati`11on
@EnableConfiguration and @ComponentScan. It enables auto-configuration and 
component scanning within the package and its sub-packages.

*/

//@ComponentScan(basePackages = "com.example.RestaurantManagement")
//configure //enableautoconfig //component scan in the same package
@SpringBootApplication
@EntityScan(basePackages = "com.example.RestaurantManagement.Model")
public class RestApiProjectApplication {
	
		public static void main(String[] args) {
			SpringApplication.run(RestApiProjectApplication.class, args);
	}
}
