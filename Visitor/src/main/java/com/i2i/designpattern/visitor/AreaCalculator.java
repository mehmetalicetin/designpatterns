package com.i2i.designpattern.visitor;

//ConcreteVisitor (Somut Ziyaretçi) → Farklı nesne türleri için işlemlerin implementasyonunu içerir.
public class AreaCalculator implements ShapeVisitor{
	@Override
	public void visit(Circle circle) {
		double area = Math.PI * circle.getRadius() * circle.getRadius();
		System.out.println("Circle Area: " + area);
	}

	@Override
	public void visit(Rectangle rectangle) {
		double area = rectangle.getWidth() * rectangle.getHeight();
		System.out.println("Rectangle Area: " + area);
	}
}
