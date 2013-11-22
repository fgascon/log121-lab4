package ca.etsmtl.log121.labo4.commands;

import ca.etsmtl.log121.labo4.models.ModelState;

public class ClipBoard {
	
	private static final ClipBoard instance = new ClipBoard();
	
	public static ClipBoard getInstance() {
		return instance;
	}
	
	private ModelState content;
	
	public ModelState getContent() {
		return content;
	}
	
	public void setContent(ModelState value) {
		content = value;
	}
}
