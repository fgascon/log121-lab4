package ca.etsmtl.log121.labo4.views;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */
public class FenetrePrincipale extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH = 750;
	private static final int DEFAULT_HEIGHT = 500;
	
	private MenuFenetre menu;
	private JPanel viewsContainer;
	
	public FenetrePrincipale(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Default Frame");
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setLayout(new BorderLayout());
		
		menu = new MenuFenetre();
		this.add(menu, BorderLayout.NORTH);
		
		viewsContainer = new JPanel();
		viewsContainer.setLayout(null);
		this.add(viewsContainer, BorderLayout.CENTER);
	}
	
	public MenuFenetre getMenu() {
		return menu;
	}
	
	public void addToContainer(JComponent view) {
		viewsContainer.add(view);
	}
}