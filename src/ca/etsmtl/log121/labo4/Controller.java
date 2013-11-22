package ca.etsmtl.log121.labo4;

import java.io.IOException;

import ca.etsmtl.log121.labo4.commands.*;
import ca.etsmtl.log121.labo4.models.*;


/**
 * 
 */
public class Controller
{
	
	private final ImageModel imageModel = new ImageModel();
	
	/**
	 * 
	 */
	public Controller(){
		
	}
	
	public void loadImage(String path) throws IOException {
		imageModel.load(path);
	}

	/**
	 * 
	 */
	public void undo() {
		CommandManager commandManager = CommandManager.getInstance();
		if(commandManager.canUndo()) {
			commandManager.undo();
		}
	}
	
	/**
	 * 
	 */
	public void redo() {
		CommandManager commandManager = CommandManager.getInstance();
		if(commandManager.canRedo()) {
			commandManager.redo();
		}
	}
	
	/**
	 * 
	 */
	public void copy() {
		CopyCommand copy = new CopyCommand();
		CommandManager commandManager = CommandManager.getInstance();
		commandManager.execute(copy);
	}
	
	/**
	 * 
	 */
	public void paste() {
		PasteCommand paste = new PasteCommand();
		CommandManager commandManager = CommandManager.getInstance();
		commandManager.execute(paste);
	}
	
	/**
	 * 
	 */
	public void translate() {
		TranslationCommand translation = new TranslationCommand();
		CommandManager commandManager = CommandManager.getInstance();
		commandManager.execute(translation);
	}
	
	/**
	 * 
	 */
	public void zoom() {
		ZoomCommand zoom = new ZoomCommand();
		CommandManager commandManager = CommandManager.getInstance();
		commandManager.execute(zoom);
	}
}

