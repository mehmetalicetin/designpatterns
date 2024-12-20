package com.i2i.fcbs;

public class PasteCommand extends Command{
	public PasteCommand(Editor editor) {
		super(editor);
	}
	@Override
	public void execute() {
		backup();
		editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
	}
}
