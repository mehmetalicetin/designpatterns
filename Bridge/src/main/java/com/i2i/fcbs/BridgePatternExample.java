package com.i2i.fcbs;

import com.i2i.fcbs.abstraction.Circle;
import com.i2i.fcbs.abstraction.Shape;
import com.i2i.fcbs.implementation.RedColor;

public class BridgePatternExample {
	public static void main(String[] args) {
		// Create instances with different combinations of shapes and colors
		Shape redCircle = new Circle(new RedColor());

		redCircle.draw();    // Output: Drawing a circle. Filling with red color
	}
}
