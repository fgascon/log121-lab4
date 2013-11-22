package ca.etsmtl.log121.labo4.views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import ca.etsmtl.log121.labo4.models.ImageModel;

import java.awt.*;



public class ImageView extends JPanel implements Observer {
	
	private final int FRAME_WIDTH = 350;
	private final int FRAME_HEIGHT = 350;
	
	private final int FRAME_POSX = 10;
	private final int FRAME_POSY = 25;
	
	protected Image image;
	
	public ImageView() {
		this.setLayout(null);
		this.setBounds(FRAME_POSX, FRAME_POSY, FRAME_WIDTH, FRAME_HEIGHT);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public ImageView(int unePosX) {
		int posX = unePosX;
		this.setLayout(null);
		this.setBounds(posX, FRAME_POSY, FRAME_WIDTH, FRAME_HEIGHT);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public ImageView(int unePosX, int unePosY, int uneWidth, int uneHeight) {
		int posX = unePosX;
		int posY = unePosY;
		int width = uneWidth;
		int height = uneHeight;
		
		this.setLayout(null);
		this.setBounds(posX, posY, width, height);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void setImage(Image image) {
		this.image = image;
		drawImage();
	}
	
	public void update(Observable observable, Object objet) {
		if(observable instanceof ImageModel) {
			ImageModel imageModel = (ImageModel) observable;
			setImage(imageModel.getImage());
		}
	}
	
	protected void drawImage() {
		this.getGraphics().drawImage(image, 0, 0, null);
	}
}

