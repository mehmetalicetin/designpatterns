package com.i2i.fcbs.observer;

import java.io.File;

//Client
public class Editor {
	private EventManager events;
	private File         file;

	public Editor() {
		this.events = new EventManager("open", "save");
	}

	public void openFile(String filePath) {
		this.file = new File(filePath);
		events.notify("open", file);
	}

	public void saveFile() throws Exception {
		if (this.file != null) {
			events.notify("save", file);
		} else {
			throw new Exception("Please open a file first.");
		}
	}

	public void addEventListener(String eventType, EventListener listener) {
		events.subscribe(eventType, listener);
	}
}
