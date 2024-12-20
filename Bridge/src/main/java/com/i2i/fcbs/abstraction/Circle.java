package com.i2i.fcbs.abstraction;

import com.i2i.fcbs.implementation.Color;

// Refined Abstractions
public class Circle extends Shape {
	public Circle(Color color) {
		super(color);
	}

	@Override
	public void draw() {
		color.fill();
	}
}
