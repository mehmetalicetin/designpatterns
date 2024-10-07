package com.i2i.fcbs.flyweight;

import static com.i2i.fcbs.flyweight.RandomNameGenerator.getRandomName;
import static com.i2i.fcbs.flyweight.RandomPriceGenerator.getRandomPrice;

public class Launch {

	private static final int BOOK_TYPES = 2;
	private static final int BOOKS_TO_INSERT = 10_000_000;


	public static void main(String[] args) {
		Store store = new Store();
		for (int i = 0; i < BOOKS_TO_INSERT / BOOK_TYPES; i++) {
			store.storeBook(getRandomName(), getRandomPrice(1, 1000000), "Action", "Follett", "Stuff");
			store.storeBook(getRandomName(), getRandomPrice(1, 1000000), "Fantasy", "Ingram", "Extra");
		}
		store.displayBooks();
		System.out.println(BOOKS_TO_INSERT + " books inserted");
		System.out.println("------------------------");
		System.out.println("Memory Usage:");
		System.out.println("Book Size (20 bytes) * " + BOOKS_TO_INSERT + " + BookTypes Size (30 bytes) * "+BOOK_TYPES + "");
		System.out.println("------------------------");
		System.out.println("Total:  "+((BOOKS_TO_INSERT* 20 + BOOK_TYPES * 30) / 1024 /1024) + "MB (instead of "+((BOOKS_TO_INSERT* 50) / 1024 / 1024) + "MB)");
	}
}
