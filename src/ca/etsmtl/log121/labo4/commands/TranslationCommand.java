package ca.etsmtl.log121.labo4.commands;

import ca.etsmtl.log121.labo4.models.Perspective;
import ca.etsmtl.log121.labo4.Coordonnee;
import java.math.*;

/**
 * 
 */
public class TranslationCommand implements Command
{
	private Coordonnee currentCoo;
	private int xFactor,yFactor;
	private Perspective unePerspective;
	/**
	 * @param perspective 
	 * 
	 */
	public TranslationCommand(Perspective perspective, Coordonnee coordonnee){
		unePerspective = perspective;
		currentCoo = perspective.getPosition();
		int xFactor = coordonnee.getX() - currentCoo.getX(); //défini la translation en X
		int yFactor = coordonnee.getY() - currentCoo.getY(); //défini la translation en Y
	}

	/**
	 * 
	 */
	public void execute() {
		
		
		int translationX = currentCoo.getX()+xFactor;
		int translationY = currentCoo.getY()+yFactor;
		
		unePerspective.setPosition(translationX, translationY);
		
	}
	
	/**
	 * 
	 */
	public void unexecute() {
		int translationX = currentCoo.getX()-xFactor;
		int translationY = currentCoo.getY()-yFactor;
		
		unePerspective.setPosition(translationX, translationY);	
	}
}