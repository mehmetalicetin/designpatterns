package com.cetin.proxy;

public class BasbakanlikKalemi {
	private final Basbakan basbakan;

	public BasbakanlikKalemi(Basbakan basbakan) {
		this.basbakan = new VekilBasbakan(basbakan);
	}

	public Basbakan banaBasbakaniVer() {
		System.out.println("Basbakanlik kalemi: Tabi efendim...");
		return basbakan;
	}
}
