package com.i2i.fcbs.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Store {
	private final List<Book> books = new ArrayList<>();

	public void storeBook(String name, double price, String type, String distributor, String otherData) {
		BookType bookType = BookFactory.getBookType(type, distributor, otherData);
		books.add(new Book(name, price, bookType));
	}

	public void displayBooks() {
		for (Book book : books) {
			System.out.println(book);
		}
	}
}
