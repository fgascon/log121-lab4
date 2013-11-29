package ca.etsmtl.log121.labo4.views;

import java.awt.Graphics;
import java.util.Observable;

import ca.etsmtl.log121.labo4.Coordonnee;
import ca.etsmtl.log121.labo4.models.Perspective;


/**
 * 
 */
public class PerspectiveView extends ImageView
{
	
	private static final long serialVersionUID = 13L;

	/**
	 * 
	 */
	private Coordonnee position;
	
	/**
	 * 
	 */
	private float zoom = 1;
	
	/**
	 * 
	 * @param unePosX
	 * @param unePosY
	 * @param uneWidth
	 * @param uneHeight
	 */
	public PerspectiveView(int unePosX, int unePosY, int uneWidth, int uneHeight) {
		super(unePosX, unePosY, uneWidth, uneHeight);
		position = new Coordonnee(0, 0);
	}
	
	/**
	 * 
	 */
	public void setPosition(Coordonnee position) {
		this.position = position;
		repaint();
	}
	
	/**
	 * 
	 */
	public void setZoom(float zoom) {
		this.zoom = zoom;
		repaint();
	}

	/**
	 * 
	 */
	@Override
	public void update(Observable observable, Object objet) {
		if(observable instanceof Perspective) {
			Perspective perspective = (Perspective) observable;
			setZoom(perspective.getZoom());
			setPosition(perspective.getPosition());
		} else {
			super.update(observable, objet);
		}
	}

	/**
	 * 
	 */
	@Override
	protected void drawImage(Graphics graphics) {
		
		graphics.drawImage(image, position.getX(), position.getY(), (int)(this.getWidth()*zoom), (int)(this.getHeight()*zoom), null);
	}
}