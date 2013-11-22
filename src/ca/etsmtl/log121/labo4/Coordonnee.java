package ca.etsmtl.log121.labo4;

/**
 * 
 */
public class Coordonnee
{
	/**
	 * 
	 */
	private int positionX;
	
	/**
	 * 
	 */
	private int positionY;
	
	/**
	 * 
	 */
	public Coordonnee(int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
	}

	/**
	 * 
	 */
	public int getX() {
		return positionX;	
	}
	
	/**
	 * 
	 */
	public int getY() {
		return positionY;	
	}
	
	/**
	 * 
	 */
	public void setX(int value) {
		positionX = value;
	}
	
	/**
	 * 
	 */
	public void setY(int value) {
		positionX = value;
	}
	
	public Coordonnee copy() {
		return new Coordonnee(positionX, positionY);
	}
}