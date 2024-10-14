package com.i2i.fcbs.ch03;

public class CostCalculator {
	static double calculate(Cart cart) {
		double sum = 0;
		double discount = 0;
		for (Strategy s : cart.strategy) {
			discount += s.discount();
		}

		for (Product product : cart.products){
			sum += product.price;
		}

		return sum - discount;
	}
}
