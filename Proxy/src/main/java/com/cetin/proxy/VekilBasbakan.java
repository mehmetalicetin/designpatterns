package com.cetin.proxy;

public class VekilBasbakan implements Basbakan{
	private final Basbakan basbakan;

	public VekilBasbakan(Basbakan basbakan) {
		this.basbakan = basbakan;
	}

	@Override
	public void dertDinle() {
		if (true){
			basbakan.dertDinle();
		}
	}
}
