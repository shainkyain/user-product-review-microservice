package com.devil.product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * this is a Product service (a part of user-product-review microservice)
 * db- mysql
 * @author  Devil
 * @version 0.0.1.0
 * @since   21 july 2024
 */


@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
