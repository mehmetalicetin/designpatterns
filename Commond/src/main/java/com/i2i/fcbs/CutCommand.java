package com.i2i.fcbs;

public class CutCommand extends Command{
	public CutCommand(Editor editor) {
		super(editor);
	}
	@Override
	public void execute() {
		backup();
		String source = editor.textField.getText();
		editor.clipboard = editor.textField.getSelectedText();
		editor.textField.setText(cutString(source));
	}

	private String cutString(String source) {
		String start = source.substring(0, editor.textField.getSelectionStart());
		String end = source.substring(editor.textField.getSelectionEnd());
		return start + end;
	}
}
