package com.i2i.fcbs.composite.ch02;

public class Book extends Product{
	protected Book(String title, double price) {
		super(title, price);
	}

	@Override
	public double calculatingPrice() {
		return price;
	}
}
