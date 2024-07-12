package com.cetin.pattern.after.step1;

import com.cetin.pattern.before.MenuItem;

import java.util.List;

public class PanCakeHouseMenuIterator implements Iterator<MenuItem> {
	List<MenuItem> menuItems;
	int position = 0;

	public PanCakeHouseMenuIterator(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public boolean hasNext() {
		return !menuItems.isEmpty() && menuItems.size() > position;
	}

	@Override
	public MenuItem next() {
		MenuItem menuItem =  menuItems.get(position);
		position++;
		return menuItem;
	}
}
