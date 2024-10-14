package com.i2i.fcbs.ch03;

import java.util.LinkedList;
import java.util.List;

public class Cart {
	List<Product> products = new LinkedList();
	List<Strategy> strategy = new LinkedList<>();

	public void addProduct(Product product) {
		if (product == null) {
			return;
		}

		products.add(product);
		long appleCount = products.stream().map(Product::getName).filter(e->e.equalsIgnoreCase("apple")).count();
		if (appleCount == 3) {
			strategy.add(new Offer1Strategy(product.getPrice()));
		}

		boolean isExistOneApple = products.stream().map(Product::getName).filter(e->e.equalsIgnoreCase("apple")).count() == 1;
		boolean isExistOnePear = products.stream().map(Product::getName).filter(e->e.equalsIgnoreCase("pear")).count() == 1;
		if (isExistOneApple && isExistOnePear) {
			double sum = products.stream().mapToDouble(Product::getPrice).sum();
			strategy.add(new Offer2Strategy(sum));
		}
	}
}
