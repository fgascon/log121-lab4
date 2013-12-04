package ca.etsmtl.log121.labo4.commands;

import ca.etsmtl.log121.labo4.ClipBoard;
import ca.etsmtl.log121.labo4.models.Model;
import ca.etsmtl.log121.labo4.models.ModelState;

public class PasteEchelle implements Command {
	
	private Model model;
	private ModelState previousState;
	
	public PasteEchelle(Model model){
		this.model = model;		
	}
	
	public void execute() {
		ModelState stateInClipBoard = ClipBoard.getInstance().getContent();
		if(stateInClipBoard != null) {
			previousState = model.saveState();
			model.restoreState(stateInClipBoard);
		}
	}
	
	public void unexecute(){
		ModelState stateInClipBoard = ClipBoard.getInstance().getContent();
		if(stateInClipBoard != null) {
			model.restoreState(previousState);
		}
	}
	
}
