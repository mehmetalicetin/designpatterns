package com.cetin.pattern.before;

public class MenuItem {
	private String name;
	private String descr;
	private boolean vegetariean;
	private double price;

	public MenuItem(String name, String descr, boolean vegetariean, double price) {
		this.name = name;
		this.descr = descr;
		this.vegetariean = vegetariean;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescr() {
		return descr;
	}

	public boolean isVegetariean() {
		return vegetariean;
	}

	public double getPrice() {
		return price;
	}
}
