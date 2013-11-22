package ca.etsmtl.log121.labo4;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JFrame;

import ca.etsmtl.log121.labo4.views.ImageView;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class FenetrePrincipale extends JFrame
{
	private final int DEFAULT_WIDTH = 750;
	private final int DEFAULT_HEIGHT = 500;
	private ArrayList<ImageView> desViews = new ArrayList<ImageView>();
	
	public Set<ImageView> imageView;
	
	
	public FenetrePrincipale(){
		this.setLayout(null);
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.creerView();
		this.creerView(375);
		this.creerView(328,382,75,75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private void creerView() {
		ImageView unFrame = new ImageView();
		this.add(unFrame);		
	}
	
	private void creerView(int posX) {
		ImageView unFrame = new ImageView(posX);
		this.add(unFrame);		
	}
	
	private void creerView(int posX, int posY, int width,int height) {
		ImageView unFrame = new ImageView(posX,posY,width,height);
		this.add(unFrame);		
	}
	
	
	
}

