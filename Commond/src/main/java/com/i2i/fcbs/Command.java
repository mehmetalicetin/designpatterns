package com.i2i.fcbs;

public abstract class Command {
	public Editor editor;
	private String backup;

	public Command(Editor editor) {
		this.editor = editor;
	}

	void backup() {
		backup = editor.textField.getText();
	}

	void undo(){
		editor.textField.setText(backup);
	}

	public abstract void execute();
}
