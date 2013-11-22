package ca.etsmtl.log121.labo4;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: MenuFenetre.java
Date crÃ©Ã©: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *******************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import javax.swing.ButtonGroup;

import javax.swing.JRadioButtonMenuItem;

/**
 * Crée le menu de la fenêtre de l'application.
 */
public class MenuFenetre extends JMenuBar {
	
	private final int BOUCLE_INFINIE = -1;
	private final int OBTENIR_FORMES = 10;
	private static final long serialVersionUID = 1536336192561843187L;
	private static final int MENU_DESSIN_ARRETER_TOUCHE_MASK = ActionEvent.CTRL_MASK; // NOPMD by Gabriel on 13-10-17 19:14
	private static final char MENU_DESSIN_ARRETER_TOUCHE_RACC = KeyEvent.VK_A; // NOPMD by Gabriel on 13-10-17 19:16
	private static final int MENU_DESSIN_DEMARRER_TOUCHE_MASK = ActionEvent.CTRL_MASK; // NOPMD by Gabriel on 13-10-17 19:15
	private static final char MENU_DESSIN_DEMARRER_TOUCHE_RACC = KeyEvent.VK_D; // NOPMD by Gabriel on 13-10-17 19:15
	private static final int MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK; // NOPMD by Gabriel on 13-10-17 19:15
	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q; // NOPMD by Gabriel on 13-10-17 19:15
	private static final String MENU_FICHIER_TITRE = "app.frame.menus.file.title", // NOPMD by Gabriel on 13-10-17 19:14
			MENU_FICHIER_QUITTER = "app.frame.menus.file.exit", // NOPMD by Gabriel on 13-10-17 19:15
			MENU_DESSIN_TITRE = "app.frame.menus.draw.title",
			MENU_DESSIN_DEMARRER = "app.frame.menus.draw.start", // NOPMD by Gabriel on 13-10-17 19:15
			MENU_DESSIN_ARRETER = "app.frame.menus.draw.stop", // NOPMD by Gabriel on 13-10-17 19:15
			MENU_FICHIER_FORMES = "app.frame.menus.file.formes", // NOPMD by Gabriel on 13-10-17 19:16
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about";
	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about"; // NOPMD by Gabriel on 13-10-17 19:15

	private JMenuItem arreterMenuItem, demarrerMenuItem, obtenirformesMenuItem; // NOPMD by Gabriel on 13-10-17 19:15
	private static final int DELAI_QUITTER_MSEC = 200; // NOPMD by Gabriel on 13-10-17 19:16


	/**
	 * Constructeur
	 */
	public MenuFenetre() {
		addMenuDessiner();
		addMenuFichier();
		addMenuOrdre();
		addMenuAide();
	}

	/**
	 * Créer le menu "Draw".
	 */

	protected void addMenuDessiner() {
		JMenu menu = creerMenu(MENU_DESSIN_TITRE, new String[] {
				MENU_DESSIN_DEMARRER, MENU_DESSIN_ARRETER});

		demarrerMenuItem = menu.getItem(0);
		demarrerMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//rafraichirMenus();
			}
		});
		demarrerMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_DESSIN_DEMARRER_TOUCHE_RACC,
				MENU_DESSIN_DEMARRER_TOUCHE_MASK));

		arreterMenuItem = menu.getItem(1);
		arreterMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//rafraichirMenus();
			}
		});
		
		

		arreterMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_DESSIN_ARRETER_TOUCHE_RACC,
				MENU_DESSIN_ARRETER_TOUCHE_MASK));
		add(menu);
	}

	/**
	 * Créer le menu "File".
	 */
	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE,
				new String[] { MENU_FICHIER_QUITTER, MENU_FICHIER_FORMES });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Thread.sleep(DELAI_QUITTER_MSEC);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC,
						MENU_FICHIER_QUITTER_TOUCHE_MASK));
		
		
		obtenirformesMenuItem = menu.getItem(1);
		obtenirformesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//rafraichirMenus();
			}
		});
		add(menu);
	}
	
	protected void addMenuOrdre() {
		JMenu menu = new JMenu("Ordre");
		ButtonGroup directionGroup = new ButtonGroup();
		
		JRadioButtonMenuItem sortByAireCrois = new JRadioButtonMenuItem("Aire croissant");
		menu.add(sortByAireCrois);
		directionGroup.add(sortByAireCrois);
		sortByAireCrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
		JRadioButtonMenuItem sortByAireDecrois = new JRadioButtonMenuItem("Aire decroissant");
		menu.add(sortByAireDecrois);
		directionGroup.add(sortByAireDecrois);
		sortByAireDecrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
		JRadioButtonMenuItem sortByMaxDistanceCrois = new JRadioButtonMenuItem("Distance max croissant"); // NOPMD by Gabriel on 13-10-17 19:16
		menu.add(sortByMaxDistanceCrois);
		directionGroup.add(sortByMaxDistanceCrois);
		sortByMaxDistanceCrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
		JRadioButtonMenuItem sortByMaxDistanceDecrois = new JRadioButtonMenuItem("Distance max decroissant"); // NOPMD by Gabriel on 13-10-17 19:15
		menu.add(sortByMaxDistanceDecrois);
		directionGroup.add(sortByMaxDistanceDecrois);
		sortByMaxDistanceDecrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
		JRadioButtonMenuItem sortByNumSeqCrois = new JRadioButtonMenuItem("Numéro de séquence croissant");
		menu.add(sortByNumSeqCrois);
		directionGroup.add(sortByNumSeqCrois);
		sortByNumSeqCrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
		JRadioButtonMenuItem sortByNumSeqDecrois = new JRadioButtonMenuItem("Numéro de séquence decroissant"); // NOPMD by Gabriel on 13-10-17 19:16
		menu.add(sortByNumSeqDecrois);
		directionGroup.add(sortByNumSeqDecrois);
		sortByNumSeqDecrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
		JRadioButtonMenuItem sortByTypeCrois = new JRadioButtonMenuItem("Type croissant");
		menu.add(sortByTypeCrois);
		directionGroup.add(sortByTypeCrois);
		sortByTypeCrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
		JRadioButtonMenuItem sortByTypeDecrois = new JRadioButtonMenuItem("Type decroissant");
		menu.add(sortByTypeDecrois);
		directionGroup.add(sortByTypeDecrois);
		sortByTypeDecrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
		JRadioButtonMenuItem sortByWidthCrois = new JRadioButtonMenuItem("Largeur croissant");
		menu.add(sortByWidthCrois);
		directionGroup.add(sortByWidthCrois);
		sortByWidthCrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		JRadioButtonMenuItem sortByWidthDecrois = new JRadioButtonMenuItem("Largeur decroissant");
		menu.add(sortByWidthDecrois);
		directionGroup.add(sortByWidthDecrois);
		sortByWidthDecrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			
			}
		});
		
		JRadioButtonMenuItem sortByHeightCrois = new JRadioButtonMenuItem("Hauteur croissant");
		menu.add(sortByHeightCrois);
		directionGroup.add(sortByHeightCrois);
		sortByHeightCrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		JRadioButtonMenuItem sortByHeightDecrois = new JRadioButtonMenuItem("Hauteur decroissant");
		menu.add(sortByHeightDecrois);
		directionGroup.add(sortByHeightDecrois);
		sortByHeightDecrois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			
			}
		});
		
		add(menu);
	}

	/**
	 * Créer le menu "Help".
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE,
				new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS),
						LangueConfig.getResource(MENU_AIDE_PROPOS),
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}

	/**
	 * Activer ou désactiver les items du menu selon la sélection.
	 */

	/**
	 * Créer un élément de menu à partir d'un champs principal et ses éléments
	 * 
	 * @param titleKey champs principal
	 * @param itemKeys éléments
	 * @return le menu
	 */
	private static JMenu creerMenu(String titleKey, String[] itemKeys) {
		JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
		for (int i = 0; i < itemKeys.length; ++i) {
			menu.add(new JMenuItem(LangueConfig.getResource(itemKeys[i])));
		}
		return menu;
	}
}
