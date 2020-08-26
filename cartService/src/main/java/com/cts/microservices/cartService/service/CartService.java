package com.cts.microservices.cartService.service;

import com.cts.microservices.cartService.entity.Cart;
import com.cts.microservices.cartService.entity.Item;

public interface CartService {

	public Cart save(Cart cart);

	public Item save(Item item);

	public Cart findByUser(String user);

	public void delete(Cart cart);

	public void delete(Item item);

}
