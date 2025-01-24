package com.cetin.pattern.after.step1;

import com.cetin.pattern.before.MenuItem;

import java.util.List;
import java.util.Objects;

public class Waitress {
	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;

	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}

	public void printMenu(){
		Iterator<MenuItem> dinerMenuIterator = dinerMenu.createIterator();
		Iterator<MenuItem> pancakeHouseMenuIterator = pancakeHouseMenu.createIterator();
		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeHouseMenuIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerMenuIterator);
	}

	private void printMenu(Iterator<MenuItem> iterator) {
		while(iterator.hasNext()){
			MenuItem menuItem = iterator.next();
			System.out.println(menuItem.getName());
			System.out.println(menuItem.getDescr());
			System.out.println(menuItem.getPrice());
		}
	}
}
