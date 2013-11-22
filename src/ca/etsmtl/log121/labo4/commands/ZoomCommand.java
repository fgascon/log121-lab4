package ca.etsmtl.log121.labo4.commands;

import ca.etsmtl.log121.labo4.models.Perspective;


/**
 * 
 */
public class ZoomCommand implements Command {
	
	private final float baseZoom;
	private final float zoomFactor;
	private final Perspective laPerspective;
	
	/**
	 * Crée un zoom à appliquer sur une perspective
	 * @param perspective perspective sur laquelle appliquer le zoom
	 * @param unZoom facteur de zoom à appliquer
	 */
	public ZoomCommand(Perspective perspective, float unZoom) {
		laPerspective = perspective;
		baseZoom = perspective.getZoom();
		zoomFactor = unZoom;
	}
	
	/**
	 * Applique le zoom sur la perspective.
	 */
	public void execute() {
		laPerspective.setZoom(baseZoom * zoomFactor);
	}
	
	/**
	 * Restore le zoom précédent de la perspective.
	 */
	public void unexecute() {
		laPerspective.setZoom(baseZoom);
	}
}
