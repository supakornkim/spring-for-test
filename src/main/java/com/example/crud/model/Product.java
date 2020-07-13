package com.example.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_price")
	private Double productPrice;

	@Column(name = "product_qty")
	private int productQty;

	@Column(name = "product_status")
	private int productStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public int getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}

}