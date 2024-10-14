package com.i2i.fcbs.composite.ch01;

public class Product {
	private String title;
	private Double price;

	public Product(String title, Double price) {
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
