package com.cts.microservices.cartService.dao;

import com.cts.microservices.cartService.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao  extends JpaRepository<Item, Long>{

	Item save(Item item);

}
