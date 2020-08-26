package com.cts.microservices.cartService.service;

import com.cts.microservices.cartService.dao.CartDao;
import com.cts.microservices.cartService.dao.ItemDao;
import com.cts.microservices.cartService.entity.Cart;
import com.cts.microservices.cartService.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private  CartDao cartdao;
	@Autowired
	private  ItemDao itemdao;
	
	public Cart save(Cart cart) {
		return cartdao.save(cart);
	}

	public Item save(Item item) {
		return itemdao.save(item);
	}

	public Cart findByUser(String user) {
		return cartdao.findByUser(user);
	}

	public void delete(Cart cart) {
		cartdao.delete(cart);
	}

	public void delete(Item item) {
		itemdao.delete(item);
	}

}
