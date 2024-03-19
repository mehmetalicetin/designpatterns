package com.cetin.pattern.after.step1;

import com.cetin.pattern.before.MenuItem;

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

	public Iterator<MenuItem> createIterator(){
		return new PanCakeHouseIterator(menuItems);
	}
}
