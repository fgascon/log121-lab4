package ca.etsmtl.log121.labo4.commands;

import ca.etsmtl.log121.labo4.models.Perspective;
import ca.etsmtl.log121.labo4.Coordonnee;

/**
 * 
 */
public class TranslationCommand implements Command
{
	
	private Coordonnee currentCoo;
	private int xFactor,
				yFactor;
	private Perspective unePerspective;
	
	/**
	 * @param perspective perspective sur laquelle appliquer la translation
	 * @param coordonnee 
	 */
	public TranslationCommand(Perspective perspective, Coordonnee coordonnee) {
		unePerspective = perspective;
		currentCoo = perspective.getPosition();
		xFactor = coordonnee.getX() - currentCoo.getX(); //défini la translation en X
		yFactor = coordonnee.getY() - currentCoo.getY(); //défini la translation en Y
	}

	/**
	 * Applique la translation sur la perspective
	 */
	public void execute() {
		int translationX = currentCoo.getX()+xFactor;
		int translationY = currentCoo.getY()+yFactor;
		
		unePerspective.setPosition(translationX, translationY);
	}
	
	/**
	 * Annule la translation sur la perspective
	 */
	public void unexecute() {
		int translationX = currentCoo.getX()-xFactor;
		int translationY = currentCoo.getY()-yFactor;
		
		unePerspective.setPosition(translationX, translationY);	
	}
}