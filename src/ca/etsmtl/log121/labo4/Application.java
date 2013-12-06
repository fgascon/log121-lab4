/******************************************************
Cours:  LOG121
Projet: Laboratoire 4
Nom du fichier: Application.java
Date cr��: 2013-11-22
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Shaun-David Sauro, Gabriel St-Hilaire, Fr�d�ric Gascon
 *@date 2013-11-22
 *******************************************************/

package ca.etsmtl.log121.labo4;

import java.io.File;
import java.io.IOException;

import ca.etsmtl.log121.labo4.views.*;

/**
 * 
 */
public class Application
{
	
	/**
	 * 
	 * @param args arguments re�u, peut recevoir en param�tre une image � charger
	 */
	public static void main(String[] args) {
		Application application = new Application();
		
		if(args.length >= 1) {
			try {
				application.getController().loadImage(new File(args[0]));
			} catch (IOException e) {
				System.out.println("Failed to load image.");
				System.exit(1);
			}
		}
		
		application.setWindowVisible(true);
	}
	
	private FenetrePrincipale fenetrePrincipale;
	private Controller controller;
	
	/**
	 * Constructeur de l'application. Affiche la fen�tre principale.
	 */
	public Application(){
		controller = new Controller(2);
		fenetrePrincipale = new FenetrePrincipale(controller);
		
		this.creerPerspectiveView(10, 10, 350, 350);
		this.creerPerspectiveView(375, 10, 350, 350);
		this.creerView(328, 362, 75, 75);
	}
	
	private void creerView(int posX, int posY, int width, int height) {
		ImageView view = new ImageView(posX, posY, width, height);
		fenetrePrincipale.addToContainer(view);
		controller.observeImage(view);
	}
	
	private void creerPerspectiveView(int posX, int posY, int width, int height) {
		PerspectiveView view = new PerspectiveView(posX, posY, width, height);
		fenetrePrincipale.addToContainer(view);
		controller.observeImage(view);
		controller.observePerspective(view);
	}
	
	public void setWindowVisible(boolean visible) {
		fenetrePrincipale.setVisible(visible);
	}
	
	public Controller getController() {
		return controller;
	}
}