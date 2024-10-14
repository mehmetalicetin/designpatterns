package com.i2i.fcbs.composite.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeBox implements Box{
	private final List<Box> children = new ArrayList<>();

	public CompositeBox(Box... boxes) {
		children.addAll(Arrays.asList(boxes));
	}

	@Override
	public double calculatingPrice() {
		double sum = 0.0;
		for (Box box : children) {
			sum += box.calculatingPrice();
		}
		return sum;
	}
}
