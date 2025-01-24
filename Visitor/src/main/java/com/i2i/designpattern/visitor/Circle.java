package com.i2i.designpattern.visitor;

//ConcreteElement (Somut Öğe) → Belirli bir nesneyi temsil eder ve accept(Visitor visitor) metodunu uygular.
public class Circle implements Shape {
	private final double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visit(this);
	}

	public double getRadius() {
		return radius;
	}
}
