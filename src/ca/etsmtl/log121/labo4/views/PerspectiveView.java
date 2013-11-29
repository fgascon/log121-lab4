package ca.etsmtl.log121.labo4.views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
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
	private float zoom;
	
	/**
	 * 
	 * @param unePosX
	 * @param unePosY
	 * @param uneWidth
	 * @param uneHeight
	 */
	public PerspectiveView(int unePosX, int unePosY, int uneWidth, int uneHeight) {
		super(unePosX, unePosY, uneWidth, uneHeight);
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
	/*@Override
	protected void drawImage(Graphics graphics) {
		RescaleOp rescaleOperation = new RescaleOp(zoom, 0, null);
		
		//transform the image in a buffered image, so we can manipulate it
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		bufferedImage.getGraphics().drawImage(image, 0, 0, null);
		
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.drawImage(bufferedImage, rescaleOperation, position.getX(), position.getY());
	}*/
}