package com.i2i.fcbs.observer;

public class Demo {
	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.addEventListener("open", new LogOpenListener("/path/to/log/file.txt"));
		editor.addEventListener("save", new EmailNotificationListener("admin@example.com"));

		try {
			editor.openFile("test.txt");
			editor.saveFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
