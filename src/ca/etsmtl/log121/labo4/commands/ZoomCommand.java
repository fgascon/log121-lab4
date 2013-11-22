package ca.etsmtl.log121.labo4.commands;

import ca.etsmtl.log121.labo4.models.Perspective;


/**
 * 
 */
public class ZoomCommand implements Command {
	
	float baseZoom;
	float zoomFactor;
	Perspective laPerspective;
	
	/**
	 * @param perspective 
	 * 
	 */
	public ZoomCommand(Perspective perspective,float unZoom) {
		laPerspective = perspective;
		baseZoom = perspective.getZoom();
		zoomFactor = unZoom;
	}
	
	/**
	 * 
	 */
	public void execute() {
		baseZoom = baseZoom + zoomFactor;
		laPerspective.setZoom(baseZoom);
	}
	
	/**
	 * 
	 */
	public void unexecute() {
		baseZoom = baseZoom / zoomFactor;
		laPerspective.setZoom(baseZoom);
	}
}
