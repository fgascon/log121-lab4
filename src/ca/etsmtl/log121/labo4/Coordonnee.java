package ca.etsmtl.log121.labo4;

/**
 * Coordonn�e cart�sienne
 */
public class Coordonnee
{
	
	/**
	 * Position en X de la coodonn�e.
	 */
	private int positionX;
	
	/**
	 * Position en Y de la coodonn�e.
	 */
	private int positionY;
	
	/**
	 * Constructeur de la coordonn�e.
	 */
	public Coordonnee(int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
	}

	/**
	 * @return La position en X de la coordonn�e
	 */
	public int getX() {
		return positionX;	
	}
	
	/**
	 * @return La position en Y de la coordonn�e
	 */
	public int getY() {
		return positionY;	
	}
	
	/**
	 * Modifie la position en X de la coordonn�e.
	 * @param value Nouvelle valeur en X
	 */
	public void setX(int value) {
		positionX = value;
	}
	
	/**
	 * Modifie la position en Y de la coordonn�e.
	 * @param value Nouvelle valeur en Y
	 */
	public void setY(int value) {
		positionX = value;
	}
	
	/**
	 * Cr�e une nouvelle coordonn�e identique � la coordonn�e courante.
	 * @return Une copie de la coordonn�e
	 */
	public Coordonnee copy() {
		return new Coordonnee(positionX, positionY);
	}
}