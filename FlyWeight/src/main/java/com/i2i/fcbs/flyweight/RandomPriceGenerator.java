package com.i2i.fcbs.flyweight;

import java.util.Random;

public class RandomPriceGenerator {
	// Method to get a random price between a given range
	public static double getRandomPrice(double min, double max) {
		Random random = new Random();
		return min + (max - min) * random.nextDouble(); // Generate a random price within the range
	}
}
