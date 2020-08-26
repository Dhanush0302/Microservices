package com.cts.microservices.productcatalogservice.entity;

import javax.persistence.*;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private int reviewId;
	public Review() {
		super();
	}
	public Review(int reviewId, int stars, String author, String body, Product product) {
		this.reviewId = reviewId;
		this.stars = stars;
		this.author = author;
		this.body = body;
		this.product = product;
	}
	/**
	 * @return the reviewId
	 */
	public int getReviewId() {
		return reviewId;
	}
	/**
	 * @param reviewId the reviewId to set
	 */
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	/**
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}
	/**
	 * @param stars the stars to set
	 */
	public void setStars(int stars) {
		this.stars = stars;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	private int stars;
	private String author;
	private String body;
	@ManyToOne
	@JoinColumn(name = "id")
	private Product product;
	
	
}
