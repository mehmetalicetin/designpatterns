package com.i2i.designpattern.visitor;

//ObjectStructure (Nesne Yapısı) → Birden fazla öğeyi (element) barındırır ve onları ziyaretçiye kabul ettirir.
public class Rectangle implements Shape{
	private final double width;
	private final double height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visit(this);
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
}
