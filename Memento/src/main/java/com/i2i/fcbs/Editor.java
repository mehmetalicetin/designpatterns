package com.i2i.fcbs;

import java.util.ArrayDeque;
import java.util.Deque;

//CareTaker
public class Editor {
	private final Deque<TextArea.Memento> stateHistory;
	private final TextArea textArea;

	public Editor() {
		stateHistory = new ArrayDeque<>();
		textArea = new TextArea();
	}

	public void write(String text) {
		textArea.set(text);
		stateHistory.add(textArea.takeSnapshot());
	}

	public void undo() {
		textArea.restore(stateHistory.pop());
	}

	public Deque<TextArea.Memento> getStateHistory() {
		return stateHistory;
	}
}
