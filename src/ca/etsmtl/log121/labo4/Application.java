package ca.etsmtl.log121.labo4;

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
	
	/**
	 * Constructeur de l'application. Affiche la fenêtre principale.
	 */
	public Application(){
		FenetrePrincipale uneFenetre = new FenetrePrincipale();
		uneFenetre.setVisible(true);
	}
}