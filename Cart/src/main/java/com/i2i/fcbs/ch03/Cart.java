package com.i2i.fcbs.ch03;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Cart {
	public static final String APPLE = "apple";
	public static final String PEAR = "pear";
	List<Product> products = new LinkedList<>();
	List<Strategy> strategy = new LinkedList<>();

	public void addProduct(Product product) {
		if (product == null) {
			return;
		}
		products.add(product);
	}

	public void addStrategy() {
		long appleCount = products.stream().map(Product::getName).filter(e->e.equalsIgnoreCase(APPLE)).count();
		if (appleCount == 3) {
			Double price = products.stream()
					.filter(getPredicate(APPLE))
					.findAny()
					.map(Product::getPrice)
					.orElse(0.0d);
			strategy.add(new Offer1Strategy(price));
		}

		boolean isExistOneApple = isAnyMatch(APPLE);
		boolean isExistOnePear = isAnyMatch(PEAR);
		if (isExistOneApple && isExistOnePear) {
			double sum = products
					.stream()
					.mapToDouble(Product::getPrice)
					.sum();
			strategy.add(new Offer2Strategy(sum));
		}
	}

	private boolean isAnyMatch(String apple) {
		return products.stream().anyMatch(getPredicate(apple));
	}

	private static Predicate<Product> getPredicate(String apple) {
		return e -> e.getName().equalsIgnoreCase(apple);
	}
}
