package com.cetin.pattern.before;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseMenu {
	private List<MenuItem> menuItems = new ArrayList<>();

	public PancakeHouseMenu() {
		addItem("K&B's Pancake breakfast","Pancakes with scrambled eggs, and toast", true, 2.99);
	}

	public void addItem(String name, String descr, boolean vegetariean, double price){
		MenuItem menuItem = new MenuItem(name, descr, vegetariean, price);
		menuItems.add(menuItem);
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
}
