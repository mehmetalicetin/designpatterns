package com.cetin.pattern.before;

public class DinerMenu {
	private static final int MAX_ITEMS = 6;

	int numberOfItems = 0;

	private  MenuItem[] menuItems = new MenuItem[MAX_ITEMS];

	public DinerMenu() {
		addItem("Vegetarian BLT", "Bacon with lettuce & tomato on whole what", true,2.99);
	}

	private void addItem(String name, String descr, boolean vegetariean, double price) {
		MenuItem menuItem = new MenuItem(name, descr,  vegetariean, price);

		if(numberOfItems >= MAX_ITEMS){
			System.out.println("Sorry, menu is full");
		} else{
			menuItems[numberOfItems] = menuItem;
			numberOfItems++;
		}
	}

	public MenuItem[] getMenuItems() {
		return menuItems;
	}
}
