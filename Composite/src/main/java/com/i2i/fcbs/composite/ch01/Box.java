package com.i2i.fcbs.composite.ch01;

import java.util.List;

public class Box {
	private List<Box> boxes;
	private List<Product> products;

	public Box(List<Box> boxes, List<Product> products) {
		this.boxes = boxes;
		this.products = products;
	}

	public double calculatePrice() {
		double sum = products.stream().mapToDouble(Product::getPrice).sum();

		for (Box box : boxes) {
			sum += box.calculatePrice();
		}
		return sum;
	}
}
