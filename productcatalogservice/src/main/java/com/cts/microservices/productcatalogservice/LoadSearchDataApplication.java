package com.cts.microservices.productcatalogservice;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.microservices.productcatalogservice.DAO.ProductRepository;
import com.cts.microservices.productcatalogservice.DAO.ReviewRepository;
import com.cts.microservices.productcatalogservice.entity.Product;
import com.cts.microservices.productcatalogservice.entity.Review;

@SpringBootApplication
public class LoadSearchDataApplication {

	public static void main(String[] args) {
		
		ApplicationContext ac = SpringApplication.run(LoadSearchDataApplication.class, args);
	
		ProductRepository repo = ac.getBean(ProductRepository.class);
		
		ReviewRepository reviewrepo = ac.getBean(ReviewRepository.class);

		List<Product> product = new ArrayList<>();
	
		List<Review> review = new ArrayList<>();

		Product p1=new Product(1, "Bag", 200, "Hand bag for daily use, with nice shades of colors.");
		
		Product p2=new Product(2, "Shoes", 2500, "Shoes - comfortable, durable, stylish");
		
		product.add(p1);
		product.add(p2);
		product.add(new Product(3, "Laptop - HP", 45000, "HP Elitebook"));
		product.add(new Product(4, "Headset", 1500, "Powered by HearSoud music "));
		product.add(new Product(5, "Mobile cover", 250, "Designer cover"));
		
		repo.saveAll(product);
		
		
		review.add(new Review(1, 5, "Nikki", "Good quality bag", p1 ));
		
		review.add(new Review(2, 2, "Henry", "Color not expected, was faded", p2 ));
		
		reviewrepo.saveAll(review);
		

	}

}
