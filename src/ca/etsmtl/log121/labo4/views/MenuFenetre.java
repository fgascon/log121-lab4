package ca.etsmtl.log121.labo4.views;
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

import ca.etsmtl.log121.labo4.LangueConfig;

/**
 * Crée le menu de la fenêtre de l'application.
 */
public class MenuFenetre extends JMenuBar {
	
	private final int BOUCLE_INFINIE = -1;
	private final int OBTENIR_FORMES = 10;
	private static final long serialVersionUID = 1536336192561843187L;
	private static final int MENU_FICHIER_SAUVEGARDER_TOUCHE_MASK = ActionEvent.CTRL_MASK; // NOPMD by Gabriel on 13-10-17 19:14
	private static final char MENU_FICHIER_SAUVEGARDER_TOUCHE_RACC = KeyEvent.VK_A; // NOPMD by Gabriel on 13-10-17 19:16
	private static final int MENU_FICHIER_IMPORTER_TOUCHE_MASK = ActionEvent.CTRL_MASK; // NOPMD by Gabriel on 13-10-17 19:15
	private static final char MENU_FICHIER_IMPORTER_TOUCHE_RACC = KeyEvent.VK_D; // NOPMD by Gabriel on 13-10-17 19:15
	private static final int MENU_EDITER_DEFAIRE_TOUCHE_MASK = ActionEvent.CTRL_MASK; // NOPMD by Gabriel on 13-10-17 19:15
	private static final char MENU_EDITER_DEFAIRE_TOUCHE_RACC = KeyEvent.VK_Z; // NOPMD by Gabriel on 13-10-17 19:15
	private static final int MENU_EDITER_REFAIRE_TOUCHE_MASK = ActionEvent.CTRL_MASK; // NOPMD by Gabriel on 13-10-17 19:15
	private static final char MENU_EDITER_REFAIRE_TOUCHE_RACC = KeyEvent.VK_Y; // NOPMD by Gabriel on 13-10-17 19:15
	private static final String MENU_EDITER_TITRE = "app.frame.menus.edit.title", // NOPMD by Gabriel on 13-10-17 19:14
			MENU_EDITER_DEFAIRE = "app.frame.menus.edit.defaire", // NOPMD by Gabriel on 13-10-17 19:15
			MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_FICHIER_DEMARRER = "app.frame.menus.file.import", // NOPMD by Gabriel on 13-10-17 19:15
			MENU_FICHIER_ARRETER = "app.frame.menus.file.save", // NOPMD by Gabriel on 13-10-17 19:15
			MENU_EDITER_REFAIRE = "app.frame.menus.edit.refaire", // NOPMD by Gabriel on 13-10-17 19:16
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about";
	
	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about"; // NOPMD by Gabriel on 13-10-17 19:15

	private JMenuItem sauvegarderMenuItem, importerMenuItem, refaireMenuItem; // NOPMD by Gabriel on 13-10-17 19:15
	private static final int DELAI_QUITTER_MSEC = 200; // NOPMD by Gabriel on 13-10-17 19:16


	/**
	 * Constructeur
	 */
	public MenuFenetre() {
		addMenuFichier();
		addMenuEdit();
		//addMenuOrdre();
		addMenuAide();
	}

	/**
	 * Créer le menu "Fichier".
	 */

	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE, new String[] {
				MENU_FICHIER_DEMARRER, MENU_FICHIER_ARRETER});

		importerMenuItem = menu.getItem(0);
		importerMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//rafraichirMenus();
			}
		});
		importerMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_FICHIER_IMPORTER_TOUCHE_RACC,
				MENU_FICHIER_IMPORTER_TOUCHE_MASK));

		sauvegarderMenuItem = menu.getItem(1);
		sauvegarderMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//rafraichirMenus();
			}
		});
		
		

		sauvegarderMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_FICHIER_SAUVEGARDER_TOUCHE_RACC,
				MENU_FICHIER_SAUVEGARDER_TOUCHE_MASK));
		add(menu);
	}

	/**
	 * Créer le menu "Edit".
	 */
	protected void addMenuEdit() {
		JMenu menu = creerMenu(MENU_EDITER_TITRE,
				new String[] { MENU_EDITER_DEFAIRE, MENU_EDITER_REFAIRE });
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
				KeyStroke.getKeyStroke(MENU_EDITER_DEFAIRE_TOUCHE_RACC,
						MENU_EDITER_DEFAIRE_TOUCHE_MASK));
		
		
		refaireMenuItem = menu.getItem(1);
		refaireMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//rafraichirMenus();
			}
		});
		menu.getItem(1).setAccelerator(KeyStroke.getKeyStroke(
				MENU_EDITER_REFAIRE_TOUCHE_RACC,
				MENU_EDITER_REFAIRE_TOUCHE_MASK));
		add(menu);
	}
	/*
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
	*/
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
