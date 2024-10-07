package com.i2i.fcbs.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BookFactory {
	private static final Map<String, BookType> bookTypes = new HashMap<>();

	public static BookType getBookType(String bookType, String distributor, String otherData){
		if(!bookTypes.containsKey(bookType)){
			bookTypes.put(bookType, new BookType(bookType, distributor, otherData));
		}
		return bookTypes.get(bookType);
	}
}
