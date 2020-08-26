package com.cts.microservices.productcatalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cts.microservices.productcatalogservice.entity.Product;
import com.cts.microservices.productcatalogservice.entity.Review;
import com.cts.microservices.productcatalogservice.service.ProductService;
import com.cts.microservices.productcatalogservice.service.ReviewService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private  ProductService productservice;
	
	@Autowired
	private ReviewService	reviewservice;
	
	@GetMapping("/1") //TEST URL http://localhost:8081/api/1
	public String temp() {
		return "hiio";
	}
	
	////http://localhost:8081/api/products
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productservice.findAll();
	}

	//http://localhost:8081/api/products/1
	@GetMapping("/products/{id}")
	public Product getByProdId(@PathVariable("id") int id) {
		return productservice.findById(id);
	}
	//http://localhost:8081/api/products/byName/Bag
	@GetMapping("/products/byName/{name}") 
	public List<Product> getByProdName(@PathVariable("name") String name) {
		return productservice.findByNameEndsWith(name);
	}
	//http://localhost:8081/api/products/1/reviews
	@GetMapping("/products/{id}/reviews") 
	public List<Review> getReviews(@PathVariable("id") int id) {
		
		Product product = productservice.findById(id);
		return  reviewservice.findById(product);
	}
	
	@PostMapping("/products/{id}/reviews")
	public Review postReview(@RequestBody Review review,@PathVariable("id") int id ) {
		Product product = productservice.findById(id);
		review.setProduct(product);
		
		return reviewservice.saveReview(review);
	}

	@PostMapping("/products")
	public Product postProducts(@RequestBody Product product) {
		return productservice.saveProduct(product);
	}
	
	@PostMapping("/products/all")
	public List<Product> postProductAll(@RequestBody List<Product> product) {
		return productservice.saveProduct(product);
	}
	
}
