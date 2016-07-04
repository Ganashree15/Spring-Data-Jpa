package com.spring.main;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.entity.Product;
import com.spring.service.ProductService;

/**
 * Simple tester for Spring-Data-JPA.
 **/
public class SpringDataJPAMain {
	public static void main(String[] args) {

		// Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");

		// Get service from context.
		ProductService productService = ctx.getBean(ProductService.class);

		// Add some items
		productService.add(new Product(1, "Television"));
		productService.add(new Product(2, "Phone"));
		productService.addAll(Arrays.asList(new Product(3, "Peach"), new Product(4, "Strawberry"),
				new Product(5, "Melone"), new Product(6, "Onion")));

		// Test entity listing
		System.out.println("findAll=" + productService.findAll());

		// Test specified find methods
		System.out.println("findByName is 'Phone': " + productService.findByNameIs("Phone"));
		System.out
				.println("findByNameContainingIgnoreCase 'on': " + productService.findByNameContainingIgnoreCase("on"));

		ctx.close();
	}
}
