package ca.etsmtl.log121.labo4;

import java.io.IOException;

import ca.etsmtl.log121.labo4.views.*;

/**
 * 
 */
public class Application
{
	
	/**
	 * 
	 * @param args arguments reçu, peut recevoir en paramètre une image à charger
	 */
	public static void main(String[] args) {
		Application application = new Application();
		
		if(args.length >= 1) {
			try {
				application.getController().loadImage(args[0]);
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
	 * Constructeur de l'application. Affiche la fenêtre principale.
	 */
	public Application(){
		controller = new Controller(2);
		fenetrePrincipale = new FenetrePrincipale(controller);
		
		this.creerPerspectiveView(0, 10, 10, 350, 350);
		this.creerPerspectiveView(1, 375, 10, 350, 350);
		this.creerView(328, 370, 75, 75);
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
	
	public void setWindowVisible(boolean visible) {
		fenetrePrincipale.setVisible(visible);
	}
	
	public Controller getController() {
		return controller;
	}
}