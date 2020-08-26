package com.cts.microservices.priceService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cts.microservices.priceService.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class PriceController {
	
//	@Autowired
//	private  CartService cartservice;
	
	
	@GetMapping("/test") //TEST URL http://localhost:8081/api/1
	public String temp() {
		return "Welcome To Price Service";
	}
	
	@GetMapping("/price/{id}") //TEST URL http://localhost:8081/api/1
	public String getPrice(@PathVariable("id") String id) {
		Map<String, String> urivariables = new HashMap<String, String>(); 
		urivariables.put("id", id);
		ResponseEntity<Product> resEntity = new RestTemplate().getForEntity("http://localhost:8081/api/products/{id}", 
				Product.class, urivariables); 
		Product prod = resEntity.getBody(); 
		int price = (int) prod.getPrice(); 
		String priceStr = Integer.toString(price);
		System.out.println("Price : "+priceStr);
		return priceStr;
	}
	
}
