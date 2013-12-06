/******************************************************
Cours:  LOG121
Projet: Laboratoire 4
Nom du fichier: ClipBoard.java
Date créé: 2013-11-22
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Shaun-David Sauro, Gabriel St-Hilaire, Frédéric Gascon
 *@date 2013-11-22
 *******************************************************/
package ca.etsmtl.log121.labo4;

import ca.etsmtl.log121.labo4.models.ModelState;

public class ClipBoard {
	
	private static final ClipBoard instance = new ClipBoard();
	
	public static ClipBoard getInstance() {
		return instance;
	}
	
	private ModelState content;
	
	public ModelState getContent() {
		return content;
	}
	
	public void setContent(ModelState value) {
		content = value;
	}
}
