package com.i2i.fcbs.observer;

import java.io.File;

//Subscriber
public interface EventListener {
	void update(String eventType, File file);
}
