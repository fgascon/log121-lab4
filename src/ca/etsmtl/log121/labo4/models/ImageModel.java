package ca.etsmtl.log121.labo4.models;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import javax.imageio.ImageIO;


/**
 * 
 */
public class ImageModel extends Observable {
	
	/**
	 * 
	 */
	private final ArrayList<Perspective> perspective = new ArrayList<Perspective>();
	
	/**
	 * 
	 */
	private Image image;
	
	/**
	 * 
	 * @throws IOException erreur durant le chargement de l'image
	 */
	public ImageModel(String path) throws IOException{
		File file = new File(path);
		image = ImageIO.read(file);
	}
	
	/**
	 * 
	 * @return
	 */
	public Image getImage() {
		return image;
	}
}