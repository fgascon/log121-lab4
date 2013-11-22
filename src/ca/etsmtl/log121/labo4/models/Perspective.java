package ca.etsmtl.log121.labo4.models;

import java.util.Observable;

import ca.etsmtl.log121.labo4.Coordonnee;


/**
 * 
 */
public class Perspective extends Observable implements Model {
	
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

	public ModelState saveState() {
		return new PerspectiveModelState();
	}

	public void restoreState(ModelState state) {
		if(state instanceof PerspectiveModelState) {
			PerspectiveModelState perspectiveModelState = (PerspectiveModelState) state;
			perspectiveModelState.restore();
		}
	}
	
	private class PerspectiveModelState implements ModelState {

		private int savedXPosition;
		private int savedYPosition;
		private float savedZoom;
		
		public PerspectiveModelState() {
			savedXPosition = coordonnee.getX();
			savedYPosition = coordonnee.getY();
			savedZoom = zoom;
		}
		
		public void restore() {
			coordonnee.setX(savedXPosition);
			coordonnee.setY(savedYPosition);
			zoom = savedZoom;
		}
		
		public String serialize() {
			return Integer.toHexString(savedXPosition)
					.concat("|")
					.concat(Integer.toHexString(savedYPosition))
					.concat("|")
					.concat(Float.toHexString(zoom));
		}
		
		public void unserialize(String state) throws Exception {
			String[] stateArray = state.split("|");
			if(stateArray.length != 3) {
				throw new Exception("Can't serialize Perspective: invalid state.");
			} else {
				savedXPosition = Integer.parseInt(stateArray[0]);
				savedYPosition = Integer.parseInt(stateArray[1]);
				savedZoom = Integer.parseInt(stateArray[2]);
			}
		}
	}
}