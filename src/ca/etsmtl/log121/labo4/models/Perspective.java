package ca.etsmtl.log121.labo4.models;

import java.util.Observable;

import ca.etsmtl.log121.labo4.Coordonnee;


/**
 * 
 */
public class Perspective extends Observable {
	
	private final Coordonnee coordonnee ;
	
	
	private float zoom;
	

	public Perspective() {
		coordonnee = new Coordonnee(0,0);
		zoom = 1;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public float getZoom() {
		return zoom;
	}
	
	public void setZoom(float unZoom){
		zoom = unZoom;
	}
	
	public void setPosition(int posX, int posY){
		coordonnee.setX(posX);
		coordonnee.setY(posY);
	}
	
	/**
	 * 
	 * @return
	 */
	public Coordonnee getPosition() {
		return coordonnee.copy();
	}
}