/******************************************************
Cours:  LOG121
Projet: Laboratoire 4
Nom du fichier: ImagineView.java
Date cr��: 2013-11-22
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Shaun-David Sauro, Gabriel St-Hilaire, Fr�d�ric Gascon
 *@date 2013-11-22
 *******************************************************/
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
		
		this.setBackground(new Color(220,220,220));
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
		graphics.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		drawImage(graphics);
	}
}
