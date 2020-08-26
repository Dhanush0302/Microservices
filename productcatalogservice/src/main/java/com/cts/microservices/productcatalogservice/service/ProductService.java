package com.cts.microservices.productcatalogservice.service;

import java.util.List;

import com.cts.microservices.productcatalogservice.entity.Product;

public interface ProductService {
	
	
	List<Product> findAll();
	
	Product findById(int id); 
	
	List<Product> findByNameEndsWith(String letter);

	
	List<Product> saveProduct(List<Product> products);

	Product saveProduct(Product products);
}
