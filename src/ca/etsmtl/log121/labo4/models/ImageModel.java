package ca.etsmtl.log121.labo4.models;

import java.util.ArrayList;
import java.util.Observable;


/**
 * 
 */
public class ImageModel extends Observable {
	
	/**
	 * 
	 */
	private final ArrayList<Perspective> perspective = new ArrayList<Perspective>();
	
	/**
	 * 
	 */
	public ImageModel(){
		
	}
	
	/**
	 * 
	 */
	public Perspective getPerspective(int index) {
		return perspective.get(index);
	}
}

