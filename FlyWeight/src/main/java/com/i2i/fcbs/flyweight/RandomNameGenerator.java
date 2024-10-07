package com.i2i.fcbs.flyweight;

import java.util.Random;

public class RandomNameGenerator {
	// Predefined list of names
	private static final String[] NAMES = {
			"Alice", "Bob", "Charlie", "Diana", "Edward", "Fiona",
			"George", "Hannah", "Isaac", "Julia"
	};

	// Method to get a random name
	public static String getRandomName() {
		Random random = new Random();
		int index = random.nextInt(NAMES.length); // Get a random index within the range of the array
		return NAMES[index];
	}
}
