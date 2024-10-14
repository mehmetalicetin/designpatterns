package com.i2i.fcbs.ch03;

public class Main {
	public static void main(String[] args) {
		Product elma = new Product();
		elma.name = "apple";
		elma.price = 5.0;

		Product armut = new Product();
		armut.name = "pear";
		armut.price = 2.0;

		Cart cart = new Cart();
		cart.addProduct(elma);
		cart.addProduct(armut);

		System.out.println("Sum: " + CostCalculator.calculate(cart));
	}
}
