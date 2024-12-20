package com.i2i.fcbs;

public class CopyCommand extends Command{
	public CopyCommand(Editor editor) {
		super(editor);
	}
	@Override
	public void execute() {
		editor.clipboard = editor.textField.getSelectedText();
	}
}
