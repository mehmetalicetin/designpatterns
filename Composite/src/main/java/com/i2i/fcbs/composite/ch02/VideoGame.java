package com.i2i.fcbs.composite.ch02;

public class VideoGame extends Product{
	protected VideoGame(String title, double price) {
		super(title, price);
	}

	@Override
	public double calculatingPrice() {
		return price;
	}
}
