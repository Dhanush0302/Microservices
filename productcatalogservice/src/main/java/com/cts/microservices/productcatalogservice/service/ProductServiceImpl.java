package com.cts.microservices.productcatalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.microservices.productcatalogservice.DAO.ProductRepository;
import com.cts.microservices.productcatalogservice.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productDao;

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product findById(int id) {
		System.out.println("id:: "+id);
		return productDao.findById(id);
	}

	@Override
	public List<Product> findByNameEndsWith(String letter) {
		return productDao.findByNameEndsWith(letter);
	}

	@Override
	public List<Product> saveProduct(List<Product> products) {
		// TODO Auto-generated method stub
		return productDao.saveAll(products);
	}

	@Override
	public Product saveProduct(Product products) {
		// TODO Auto-generated method stub
		return productDao.save(products);
	}
	
	
}
