package com.cts.microservices.OrderService.service;

import com.cts.microservices.OrderService.OrderDao.OrderDao;
import com.cts.microservices.OrderService.entity.Orderdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private  OrderDao orderDao;
	
	public Orderdetails save(Orderdetails order) {
		return orderDao.save(order);
	}

}
