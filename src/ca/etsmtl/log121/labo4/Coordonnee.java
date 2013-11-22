package ca.etsmtl.log121.labo4;

/**
 * Coordonnée cartésienne
 */
public class Coordonnee
{
	
	/**
	 * Position en X de la coodonnée.
	 */
	private int positionX;
	
	/**
	 * Position en Y de la coodonnée.
	 */
	private int positionY;
	
	/**
	 * Constructeur de la coordonnée.
	 */
	public Coordonnee(int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
	}

	/**
	 * @return La position en X de la coordonnée
	 */
	public int getX() {
		return positionX;	
	}
	
	/**
	 * @return La position en Y de la coordonnée
	 */
	public int getY() {
		return positionY;	
	}
	
	/**
	 * Modifie la position en X de la coordonnée.
	 * @param value Nouvelle valeur en X
	 */
	public void setX(int value) {
		positionX = value;
	}
	
	/**
	 * Modifie la position en Y de la coordonnée.
	 * @param value Nouvelle valeur en Y
	 */
	public void setY(int value) {
		positionX = value;
	}
	
	/**
	 * Crée une nouvelle coordonnée identique à la coordonnée courante.
	 * @return Une copie de la coordonnée
	 */
	public Coordonnee copy() {
		return new Coordonnee(positionX, positionY);
	}
}