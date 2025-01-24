package com.i2i.designpattern.visitor;

//Element (Öğe Arayüzü) → accept(Visitor visitor) metodunu tanımlar.
public interface Shape {
	void accept(ShapeVisitor visitor);
}
