package com.cetin.proxy;

public class Vatandas {
	private final Basbakan basbakan;

	public Vatandas(BasbakanlikKalemi basbakanlikKalemi) {
		System.out.println("Bana basbakanı ver");
		this.basbakan = basbakanlikKalemi.banaBasbakaniVer();
	}

	public void dertAnlat(){
		basbakan.dertDinle();
	}
}
