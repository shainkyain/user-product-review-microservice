package com.devil.reviewRating_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * this is a Review service (a part of user-product-review microservice)
 * In review we call other two services (User-Service & Product-service)
 * using webclient architecture to make connection.
 * db- mysql
 * @author  Devil
 * @version 0.0.1.0
 * @since   21 july 2024
 */



@SpringBootApplication
public class ReviewRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewRatingServiceApplication.class, args);
	}

}
