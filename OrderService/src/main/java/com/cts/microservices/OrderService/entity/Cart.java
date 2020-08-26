package com.cts.microservices.OrderService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private int cartId;
	private int qty;
	@ManyToOne
	@JoinColumn(name = "id")
	private Item item;
	private String user;
	
	public Cart() {
		super();
	}
	public Cart(int quantity,Item item,String user) {
		super();
		this.qty = quantity;
		this.item = item;
		this.user = user;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

}
