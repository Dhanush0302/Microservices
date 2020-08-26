package com.cts.microservices.OrderService.OrderDao;

import com.cts.microservices.OrderService.entity.Orderdetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Orderdetails, Long>{

}
