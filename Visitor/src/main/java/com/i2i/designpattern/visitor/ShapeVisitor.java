package com.i2i.designpattern.visitor;


public interface ShapeVisitor {
	void visit(Rectangle rectangle);
	void visit(Circle circle);
}
