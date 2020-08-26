package com.cts.microservices.productcatalogservice.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.microservices.productcatalogservice.entity.Product;
import com.cts.microservices.productcatalogservice.entity.Review;


public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	
	List<Review> findByProduct(Product product); 

	
	Review save(Review review);
	

}
