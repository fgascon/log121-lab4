package ca.etsmtl.log121.labo4.models;

import ca.etsmtl.log121.labo4.Coordonnee;


/**
 * 
 */
public class Perspective {
	
	/**
	 * 
	 */
	private Coordonnee coordonnee;
	
	/**
	 * 
	 */
	private int zoom;
	
	/**
	 * 
	 */
	public Perspective() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public int getZoom() {
		return zoom;
	}
	
	/**
	 * 
	 * @return
	 */
	public Coordonnee getPosition() {
		return coordonnee.copy();
	}
}