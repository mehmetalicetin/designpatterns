package com.i2i.fcbs.builder.ch05;

import com.i2i.fcbs.builder.ch06.Book;

public class Test {
	public static void main(String[] args) {
		Book book = new Book.Builder("isbn","title")
				.description("descr")
				.author("author")
				.build();
		System.out.println(book);
	}
}
