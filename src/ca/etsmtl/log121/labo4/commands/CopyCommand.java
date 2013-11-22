package ca.etsmtl.log121.labo4.commands;

import ca.etsmtl.log121.labo4.models.Model;
import ca.etsmtl.log121.labo4.models.ModelState;

/**
 * 
 */
public class CopyCommand implements Command {
	
	private Model model;
	private ModelState previousState;
	
	/**
	 * 
	 */
	public CopyCommand(Model model){
		this.model = model;
	}

	/**
	 * 
	 */
	public void execute() {
		ClipBoard clipBoard = ClipBoard.getInstance();
		
		previousState = clipBoard.getContent();
		clipBoard.setContent(model.saveState());
	}
	
	/**
	 * 
	 */
	public void unexecute() {
		ClipBoard.getInstance().setContent(previousState);
	}
}