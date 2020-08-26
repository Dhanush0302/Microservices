package com.cts.microservices.productcatalogservice.service;

import java.util.List;

import com.cts.microservices.productcatalogservice.entity.Product;
import com.cts.microservices.productcatalogservice.entity.Review;

public interface ReviewService {
	
	List<Review> findById(Product prod); 

	Review saveReview(Review review);
}
