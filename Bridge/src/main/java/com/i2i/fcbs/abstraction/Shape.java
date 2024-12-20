package com.i2i.fcbs.abstraction;

import com.i2i.fcbs.implementation.Color;

//Abstractions
public abstract class Shape {
	protected final Color color;

	protected Shape(Color color) {
		this.color = color;
	}

	public abstract void draw();
}
