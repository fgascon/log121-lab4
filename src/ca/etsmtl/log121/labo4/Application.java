package ca.etsmtl.log121.labo4;

/**
 * 
 */
public class Application
{
	
	/**
	 * 
	 * @param args arguments re�u, aucun argument n'est attendu
	 */
	public static void main(String[] args) {
		new Application();

	}
	
	/**
	 * Constructeur de l'application. Affiche la fen�tre principale.
	 */
	public Application(){
		FenetrePrincipale uneFenetre = new FenetrePrincipale();
		uneFenetre.setVisible(true);
	}
}