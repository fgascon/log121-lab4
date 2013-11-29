package ca.etsmtl.log121.labo4.commands;

import ca.etsmtl.log121.labo4.models.Perspective;
import ca.etsmtl.log121.labo4.Coordonnee;

/**
 * 
 */
public class TranslationCommand implements Command
{
	
	private Coordonnee currentCoo;
	private Coordonnee deplacement;
	private Perspective unePerspective;
	
	/**
	 * @param perspective perspective sur laquelle appliquer la translation
	 * @param coordonnee 
	 */
	public TranslationCommand(Perspective perspective, Coordonnee deplacement) {
		unePerspective = perspective;
		currentCoo = perspective.getPosition();
		this.deplacement = deplacement;
	}

	/**
	 * Applique la translation sur la perspective
	 */
	public void execute() {
		Coordonnee newPosition = currentCoo.add(deplacement);
		unePerspective.setPosition(newPosition);
	}
	
	/**
	 * Annule la translation sur la perspective
	 */
	public void unexecute() {
		unePerspective.setPosition(currentCoo);	
	}
}