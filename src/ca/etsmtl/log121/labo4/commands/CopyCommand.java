/******************************************************
Cours:  LOG121
Projet: Laboratoire 4
Nom du fichier: CopyManager.java
Date cr��: 2013-11-22
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Shaun-David Sauro, Gabriel St-Hilaire, Fr�d�ric Gascon
 *@date 2013-11-22
 *******************************************************/
package ca.etsmtl.log121.labo4.commands;

import ca.etsmtl.log121.labo4.ClipBoard;
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