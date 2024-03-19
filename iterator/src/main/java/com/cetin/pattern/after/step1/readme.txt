The Menus are not well encapsulated; we can see the Diner is using an Array and the Pancake House and ArrayList.

We need two loops to iterate through the MenuItems.

The Waitress is bound to concrete classes(MenuItem[] and ArrayList)

The waitress is bound to two different concrete Menu classes, despite their
interfaces being almost identical.



----------After Changes-------------
The Menu implementations are now encapsulated. The waitress has no idea how the Menus hold their collection of menu items.

All we need is a loop that polymorphic handles any collection of items as long as it implements iterator.

The Waitress now uses an interface.

The Menu interfaces are now exactly the same and, uh oh, we still don't have a common interfaces, which two concrete
Menu classes. We'd better fix that.