package com.i2i.fcbs.composite.ch02;

public abstract class Product implements Box{
	protected final String title;
	protected final double price;

	protected Product(String title, double price) {
		this.title = title;
		this.price = price;
	}
}
