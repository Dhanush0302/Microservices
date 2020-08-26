package com.cts.microservices.OrderService.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orderdetails {

	@Id
	@GeneratedValue
	private int		id;
	private LocalDateTime date;
	private double	amount;
	private String	user;

	public Orderdetails() {
		super();
	}

	
	public Orderdetails(int id,LocalDateTime date,double amount,String user) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.user = user;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	public LocalDateTime getDate() {
		return date;
	}


	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
