package com.cts.microservices.productcatalogservice.DAO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.microservices.productcatalogservice.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findAll();
	
	Product findById(int id); 
	
	List<Product> findByNameEndsWith(String letter);

	

}
