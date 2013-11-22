package ca.etsmtl.log121.labo4.models;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;



/**
 * 
 */
public class ImageModel extends Observable implements Model {
	
	/**
	 * 
	 */
	private Image image;
	
	/**
	 * 
	 */
	public ImageModel(){
		image = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
	}
	
	/**
	 * 
	 * @param path le chemin d'accès vers l'image
	 * @throws IOException erreur durant le chargement de l'image
	 */
	public void load(String path) throws IOException {
		File file = new File(path);
		image = ImageIO.read(file);
		this.setChanged();
		this.notifyObservers(image);
	}
	
	/**
	 * 
	 * @return
	 */
	public Image getImage() {
		return image;
	}
	
	public ModelState saveState() {
		return new ImageModelState();
	}
	
	public void restoreState(ModelState state) {
		if(state instanceof ImageModelState) {
			ImageModelState imageModelState = (ImageModelState) state;
			imageModelState.restore();
		}
	}
	
	private class ImageModelState implements ModelState {
		
		public Image savedImage;
		
		public ImageModelState() {
			savedImage = image;
		}
		
		public void restore() {
			image = savedImage;
		}
		
		public String serialize() {
			return "";
		}
		
		public void unserialize(String state) throws Exception {
			
		}
	}
}