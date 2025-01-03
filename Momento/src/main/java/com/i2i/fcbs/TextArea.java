package com.i2i.fcbs;

//Originator
public class TextArea {
	private String text;

	public void set(String text) {
		this.text = text;
	}

	public Memento takeSnapshot(){
		return new Memento(this.text);
	}

	public void restore(Memento memento){
		this.text = memento.getSavedText();
	}

	public static class Memento {
		private final String text;

		public Memento(String text) {
			this.text = text;
		}

		public String getSavedText() {
			return text;
		}
	}
}
