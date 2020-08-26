package com.cts.microservices.cartService.dao;

import com.cts.microservices.cartService.entity.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart, Long>{

//	Cart save(Cart cart);

	Cart findByUser(String user);

}
