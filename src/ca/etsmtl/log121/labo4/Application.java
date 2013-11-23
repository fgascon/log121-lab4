package ca.etsmtl.log121.labo4;

import ca.etsmtl.log121.labo4.models.Perspective;
import ca.etsmtl.log121.labo4.views.*;

/**
 * 
 */
public class Application
{
	
	/**
	 * 
	 * @param args arguments reçu, aucun argument n'est attendu
	 */
	public static void main(String[] args) {
		new Application();
	}
	
	private FenetrePrincipale fenetrePrincipale;
	private Controller controller;
	
	/**
	 * Constructeur de l'application. Affiche la fenêtre principale.
	 */
	public Application(){
		fenetrePrincipale = new FenetrePrincipale();
		controller = new Controller(2);
		
		this.creerPerspectiveView(0, 10, 10, 350, 350);
		this.creerPerspectiveView(1, 375, 10, 350, 350);
		this.creerView(328, 370, 75, 75);
		
		fenetrePrincipale.setVisible(true);
	}
	
	private void creerView(int posX, int posY, int width, int height) {
		ImageView view = new ImageView(posX, posY, width, height);
		fenetrePrincipale.addToContainer(view);
		controller.observeImage(view);
	}
	
	private void creerPerspectiveView(int perspectiveIndex, int posX, int posY, int width, int height) {
		PerspectiveView view = new PerspectiveView(posX, posY, width, height);
		fenetrePrincipale.addToContainer(view);
		controller.observeImage(view);
		controller.observePerspective(perspectiveIndex, view);
	}
}