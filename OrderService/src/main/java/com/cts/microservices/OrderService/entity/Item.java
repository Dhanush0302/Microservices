package com.cts.microservices.OrderService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	private double itemTotal;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	

	public Item() {
		super();
	}


	public Item(int id,String name,double price,double itemTotal) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.itemTotal = itemTotal;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}


	
	@Override
	public String toString() {
	StringBuffer str = new StringBuffer();
	str.append("id::"+this.id);
	str.append(":name::"+this.name);
	str.append(":price::"+this.price);
	
	return str.toString();
	}

	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	public double getItemTotal() {
		return itemTotal;
	}


	
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}



}
