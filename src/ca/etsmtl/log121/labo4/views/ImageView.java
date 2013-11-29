package ca.etsmtl.log121.labo4.views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import ca.etsmtl.log121.labo4.models.ImageModel;

import java.awt.*;

public class ImageView extends JPanel implements Observer {
	
	private static final long serialVersionUID = 10L;
	
	protected Image image;
	
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
		repaint();
	}
	
	public void update(Observable observable, Object objet) {
		if(observable instanceof ImageModel) {
			ImageModel imageModel = (ImageModel) observable;
			setImage(imageModel.getImage());
		}
	}
	
	protected void drawImage(Graphics graphics) {
		graphics.drawImage(image, 0, 0, null);
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		drawImage(graphics);
	}
}
