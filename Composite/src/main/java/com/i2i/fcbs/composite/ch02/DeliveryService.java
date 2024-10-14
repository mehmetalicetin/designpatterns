package com.i2i.fcbs.composite.ch02;

public class DeliveryService {
	private Box box;

	public DeliveryService() {
	}

	public void setUpOrder(Box ... boxes){
		this.box = new CompositeBox(boxes);
	}

	public double calculatePrice(){
		return box.calculatingPrice();
	}
}
