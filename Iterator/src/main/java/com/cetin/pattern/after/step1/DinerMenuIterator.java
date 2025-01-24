package com.cetin.pattern.after.step1;

import com.cetin.pattern.before.MenuItem;

public class DinerMenuIterator implements Iterator<MenuItem> {
	MenuItem[] menuItems;
	int position = 0;

	public DinerMenuIterator(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public boolean hasNext() {
		return position < menuItems.length && menuItems[position] != null;
	}

	@Override
	public MenuItem next() {
		MenuItem menuItem = menuItems[position++];
		position++;
		return menuItem;
	}
}
