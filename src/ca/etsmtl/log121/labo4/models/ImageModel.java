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
	private String imagePath;
	
	/**
	 * 
	 */
	public ImageModel(){
		imagePath = null;
		image = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
	}
	
	/**
	 * 
	 * @param path le chemin d'accès vers l'image
	 * @throws IOException erreur durant le chargement de l'image
	 */
	public void load(String path) throws IOException {
		imagePath = path;
		if(imagePath == null) {
			image = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
		} else {
			File file = new File(path);
			image = ImageIO.read(file);
		}
		setChanged();
		notifyObservers();
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
			setChanged();
			notifyObservers();
		}
	}
	
	public String serialize() {
		return imagePath;
	}
	
	public void unserialize(String state) throws Exception {
		if(state.equals("null")) {
			state = null;
		}
		load(state);
	}
	
	private class ImageModelState implements ModelState {
		
		public String savedImagePath;
		public Image savedImage;
		
		public ImageModelState() {
			savedImagePath = imagePath;
			savedImage = image;
		}
		
		public void restore() {
			imagePath = savedImagePath;
			image = savedImage;
		}
	}
}