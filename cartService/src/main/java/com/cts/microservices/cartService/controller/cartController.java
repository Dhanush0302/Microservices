package com.cts.microservices.cartService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cts.microservices.cartService.entity.Cart;
import com.cts.microservices.cartService.entity.Item;
import com.cts.microservices.cartService.entity.Product;
import com.cts.microservices.cartService.service.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class cartController {
	
	@Autowired
	private  CartService cartservice;
	
	
	@GetMapping("/test") //TEST URL http://localhost:8081/api/1
	public String temp() {
		return "Welcome To Cart Service";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/cart/{user}")
	@ResponseBody
	public String addToCart(@RequestBody Cart cart,@PathVariable("user") String user) {
		System.out.println("<<<<< Rest Controller >>>>> ~" + cart.getItem());
		Item item = cart.getItem();
		String result = "";
		System.out.println("Price "+ item.getPrice());
		if(item.getPrice() == 0) {
			Map<String, String> urivariables = new HashMap<String, String>(); 
			String id = Integer.toString(item.getId());
			urivariables.put("id", id);
			ResponseEntity<Product> resEntity = new RestTemplate().getForEntity("http://localhost:8081/api/products/{id}", 
					Product.class, urivariables); 
			Product prod = resEntity.getBody(); 
			double price = prod.getPrice(); 
			item.setPrice(price);
		}
		item.setItemTotal(item.getPrice()*cart.getQty());
		cart.setItem(item);
		cart.setUser(user);
		Item itemObj = cartservice.save(cart.getItem());
		Cart cartObj = cartservice.save(cart);
		System.out.println(cartObj);
		ObjectMapper Obj = new ObjectMapper(); 
		try {
			result = Obj.writeValueAsString(cartObj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@GetMapping("/delete/{user}") //TEST URL http://localhost:8081/api/1
	public String deleteCart(@PathVariable("user") String user) {
		Cart cart = cartservice.findByUser(user);
		cartservice.delete(cart);
		cartservice.delete(cart.getItem());
		System.out.println("Cart = "+cart.getQty());
		return "success";
	}
	
	@GetMapping("/findByUser/{user}") //TEST URL http://localhost:8081/api/1
	public Cart findByUser(@PathVariable("user") String user) {
		return cartservice.findByUser(user);
	}
}
