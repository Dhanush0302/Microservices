package com.cts.microservices.OrderService.service;

import com.cts.microservices.OrderService.entity.Orderdetails;

import org.springframework.stereotype.Service;


public interface OrderService {

	Orderdetails save(Orderdetails order);

}
