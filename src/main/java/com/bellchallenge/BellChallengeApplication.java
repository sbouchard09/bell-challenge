package com.bellchallenge;

import com.bellchallenge.model.Cart;
import com.bellchallenge.model.Product;
import com.bellchallenge.service.CartServiceImpl;
import com.bellchallenge.service.ProductService;
import com.bellchallenge.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BellChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BellChallengeApplication.class, args);
	}

	/**
	 * Add 5 products to product catalog
	 * More can be added if desired
	 *
	 * @param productService
	 * @return
	 */
	@Bean
	CommandLineRunner productRunner(ProductServiceImpl productService) {
		return args -> {
			productService.addProduct(new Product(1L, "Bread", 3.99));
			productService.addProduct(new Product(2L, "Dog food", 29.89));
			productService.addProduct(new Product(3L, "Ice Cream", 4.96));
			productService.addProduct(new Product(4L, "Coffee", 9.98));
			productService.addProduct(new Product(5L, "Bacon", 6.49));
		};
	}

	/**
	 *
	 *
	 * @param cartService
	 * @return
	 */
	@Bean
	CommandLineRunner cartRunner(CartServiceImpl cartService) {
		return args -> {
			cartService.addCart(new Cart(1L));
			cartService.addCart(new Cart(2L));
		};
	}

}
