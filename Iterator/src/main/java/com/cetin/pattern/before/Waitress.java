package com.cetin.pattern.before;

import java.util.List;
import java.util.Objects;

public class Waitress {
	private final PancakeHouseMenu pancakeHouseMenu;
	private final DinerMenu        dinerMenu;

	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}


	public void printMenu(){
		List<MenuItem> pancakeHouseMenuMenuItems = pancakeHouseMenu.getMenuItems();
		MenuItem[] dinerMenuMenuItems = dinerMenu.getMenuItems();
		printPancakeHouse(pancakeHouseMenuMenuItems);
		printDiner(dinerMenuMenuItems);
	}

	private void printPancakeHouse(List<MenuItem> pancakeHouseMenuMenuItems) {
		for (MenuItem menuItem : pancakeHouseMenuMenuItems){
			System.out.println(menuItem.getName());
			System.out.println(menuItem.getDescr());
			System.out.println(menuItem.getPrice());
		}
	}

	private void printDiner(MenuItem[] dinerMenuMenuItems) {
		for (MenuItem menuItem : dinerMenuMenuItems){
			if(Objects.isNull(menuItem))
				continue;
			System.out.println(menuItem.getName());
			System.out.println(menuItem.getDescr());
			System.out.println(menuItem.getPrice());
		}
	}
}
