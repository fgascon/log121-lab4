package ca.etsmtl.log121.labo4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observer;

import ca.etsmtl.log121.labo4.commands.*;
import ca.etsmtl.log121.labo4.models.*;


/**
 * 
 */
public class Controller
{
	
	/**
	 * 
	 */
	private final ImageModel imageModel;
	
	/**
	 * 
	 */
	private final ArrayList<Perspective> perspectives;
	
	/**
	 * 
	 */
	public Controller(int nbPerspective){
		imageModel = new ImageModel();
		perspectives = new ArrayList<Perspective>(nbPerspective);
		for(int i=0; i<nbPerspective; i++) {
			perspectives.add(new Perspective());
		}
	}
	
	public void observeImage(Observer observer) {
		imageModel.addObserver(observer);
	}
	
	public void observePerspective(int perspectiveIndex, Observer observer) {
		perspectives.get(0).addObserver(observer);
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
	public void copy(int perspectiveIndex) {
		Perspective perspective = perspectives.get(perspectiveIndex);
		CopyCommand copy = new CopyCommand(perspective);
		CommandManager.getInstance().execute(copy);
	}
	
	/**
	 * 
	 */
	public void paste(int perspectiveIndex) {
		Perspective perspective = perspectives.get(perspectiveIndex);
		PasteCommand paste = new PasteCommand(perspective);
		CommandManager.getInstance().execute(paste);
	}
	
	/**
	 * 
	 */
	public void translate(int perspectiveIndex, Coordonnee uneCoordonnee) {
		Perspective perspective = perspectives.get(perspectiveIndex);
		Coordonnee coordonnee = uneCoordonnee;
		TranslationCommand translation = new TranslationCommand(perspective, coordonnee);
		CommandManager commandManager = CommandManager.getInstance();
		commandManager.execute(translation);
	}
	
	/**
	 * 
	 */
	public void zoom(int perspectiveIndex, float unZoom) {
		Perspective perspective = perspectives.get(perspectiveIndex);
		ZoomCommand zoom = new ZoomCommand(perspective, unZoom);
		CommandManager commandManager = CommandManager.getInstance();
		commandManager.execute(zoom);
	}
	
	/**
	 * 
	 * @throws IOException 
	 */
	public void save(File file) throws IOException {
		String content = imageModel.serialize();
		for(int i=0; i<perspectives.size(); i++) {
			content += ";" + perspectives.get(i).serialize();
		}
		FileAccess.writeFile(file, content);
	}
	
	/**
	 * 
	 * @throws Exception 
	 */
	public void open(File file) throws Exception {
		String content = FileAccess.readFile(file);
		String[] contentParts = content.split(";");
		if(contentParts.length != 3) {
			throw new Exception("Invalid file format");
		}
		imageModel.unserialize(contentParts[0]);
		for(int i=0; i<2; i++) {
			perspectives.get(i).unserialize(contentParts[i+1]);
		}
	}
}