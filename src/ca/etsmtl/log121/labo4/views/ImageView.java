package ca.etsmtl.log121.labo4.views;

import java.util.Observable;

import ca.etsmtl.log121.labo4.FenetrePrincipale;
import ca.etsmtl.log121.labo4.models.ImageModel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.*;



public class ImageView extends JPanel
{
	
	private final int FRAME_WIDTH = 350;
	private final int FRAME_HEIGHT = 350;
	
	private final int FRAME_POSX = 10;
	private final int FRAME_POSY = 25;
	
	
	//<E>
	
	public ImageView(){
		this.setLayout(null);
		this.setBounds(FRAME_POSX,FRAME_POSY,FRAME_WIDTH, FRAME_HEIGHT);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public ImageView(int unePosX, int unePosY){
		
		this.setLayout(new BorderLayout());
		this.setBounds(unePosX,unePosY,FRAME_WIDTH, FRAME_HEIGHT);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public ImageView(int unePosX, int unePosY, int uneWidth, int uneHeight ){
		int posX = unePosX;
		int posY = unePosY;
		int width = uneWidth;
		int height = uneHeight;
		
		this.setLayout(null);
		this.setBounds(posX,posY,width, height);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	
	public void update(Observable observable, Object objet) {
		// TODO : to implement	
	}
	
}

