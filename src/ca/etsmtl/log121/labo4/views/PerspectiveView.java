package ca.etsmtl.log121.labo4.views;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.util.Observable;

import ca.etsmtl.log121.labo4.Coordonnee;
import ca.etsmtl.log121.labo4.models.Perspective;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
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
	
	public PerspectiveView(int unePosX, int unePosY, int uneWidth, int uneHeight) {
		super(unePosX, unePosY, uneWidth, uneHeight);
	}
	
	/**
	 * 
	 */
	public void setPosition(Coordonnee position) {
		this.position = position;
		drawImage();
	}
	
	/**
	 * 
	 */
	public void setZoom(float zoom) {
		this.zoom = zoom;
		drawImage();
	}

	/**
	 * 
	 */
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
	protected void drawImage() {
		RescaleOp rescaleOperation = new RescaleOp(zoom, 0, null);
		
		//transform the image in a buffered image, so we can manipulate it
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		bufferedImage.getGraphics().drawImage(image, 0, 0, null);
		
		Graphics2D graphics = (Graphics2D) this.getGraphics();
		graphics.drawImage(bufferedImage, rescaleOperation, position.getX(), position.getY());
	}
}