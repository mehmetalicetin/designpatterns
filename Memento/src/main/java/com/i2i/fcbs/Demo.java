package com.i2i.fcbs;

public class Demo {
	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.write("Like and");
		editor.getStateHistory().forEach(e->System.out.println(e.getSavedText()));
		editor.write("Like and subscribe");
		editor.getStateHistory().forEach(e->System.out.println(e.getSavedText()));
		editor.write("Like and subscribe to Cei");
		editor.getStateHistory().forEach(e->System.out.println(e.getSavedText()));

		editor.undo();

		editor.getStateHistory().forEach(e->System.out.println(e.getSavedText()));
	}
}
