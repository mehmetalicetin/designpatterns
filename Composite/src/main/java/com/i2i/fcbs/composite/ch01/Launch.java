package com.i2i.fcbs.composite.ch01;

import java.util.Arrays;
import java.util.Collections;

//what if more product type introduce with more complex pricing mechanism,  in this example we only have product.class.
//what if more boxes or more items were to be added into the mother box.
//Our development clearly violates open-closed principle.
public class Launch {
	public static void main(String[] args) {
		Box box = new Box(
				Arrays.asList(
						new Box(Collections.EMPTY_LIST,
								Arrays.asList(
										new Product("1",100.0d),
										new Product("2",200.0d),
										new Product("3",300.0d)
								)
						),
						new Box(Collections.EMPTY_LIST,
								Arrays.asList(
										new Product("4",400.0d),
										new Product("5",500.0d),
										new Product("6",600.0d)
								))
				),
				Arrays.asList(
						new Product("7", 100.0d),
						new Product("8", 100.0d)
				)
		);
		System.out.println(box.calculatePrice());
	}
}
