package com.cts.microservices.OrderService.controller;

import com.cts.microservices.OrderService.entity.Cart;
import com.cts.microservices.OrderService.entity.Orderdetails;
import com.cts.microservices.OrderService.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private  OrderService orderservice;
	
	@GetMapping("/test") //TEST URL http://localhost:8081/api/1
	public String temp() {
		return "Welcome To Price Service";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/orders/{user}")
	@ResponseBody
	public Orderdetails order(@PathVariable("user") String user) {
		String result = "";
		//find cart details
		Map<String, String> urivariables = new HashMap<String, String>(); 
		urivariables.put("user", user);
		ResponseEntity<Cart> resEntity = new RestTemplate().getForEntity("http://localhost:8083/api/findByUser/{user}", 
				Cart.class, urivariables); 
		Cart cart = resEntity.getBody(); 
		
		//save order here
		Orderdetails order = new Orderdetails();
		order.setUser(cart.getUser());
		order.setDate(LocalDateTime.now());
		order.setAmount(cart.getItem().getItemTotal());
		order = orderservice.save(order);
		System.out.println(order);
		ObjectMapper Obj = new ObjectMapper(); 
		try {
			result = Obj.writeValueAsString(order);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		//delete cart data
		Map<String, String> urivariablesDelete = new HashMap<String, String>();
		urivariablesDelete.put("user", user);
		ResponseEntity resEntityDelete = new RestTemplate().getForEntity("http://localhost:8083/api/delete/{user}",null, urivariablesDelete); 

	    //return order data
		return order;
	}
}
