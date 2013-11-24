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

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import ca.etsmtl.log121.labo4.Controller;
import ca.etsmtl.log121.labo4.LangueConfig;

/**
 * Crée le menu de la fenêtre de l'application.
 */
public class MenuFenetre extends JMenuBar {
	
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
	
	private final Controller controller;
	
	/**
	 * Constructeur
	 */
	public MenuFenetre(Controller controller) {
		this.controller = controller;
		addMenuFichier();
		addMenuEdit();
		addMenuAide();
	}
	
	/**
	 * Créer le menu "Fichier".
	 */
	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE, new String[] {
				MENU_FICHIER_DEMARRER, MENU_FICHIER_ARRETER});

		final JFileChooser dialog = new JFileChooser();
		
		//importer
		importerMenuItem = menu.getItem(0);
		importerMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int result = dialog.showOpenDialog(MenuFenetre.this.getParent());
				if(result == JFileChooser.APPROVE_OPTION) {
					try {
						controller.open(dialog.getSelectedFile());
					} catch (Exception e) {
						System.out.println(e.getMessage());
						JOptionPane.showMessageDialog(MenuFenetre.this.getParent(), "Failed to open file.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		importerMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_FICHIER_IMPORTER_TOUCHE_RACC,
				MENU_FICHIER_IMPORTER_TOUCHE_MASK));
		
		//sauvegarder
		sauvegarderMenuItem = menu.getItem(1);
		sauvegarderMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int result = dialog.showSaveDialog(MenuFenetre.this.getParent());
				if(result == JFileChooser.APPROVE_OPTION) {
					try {
						controller.save(dialog.getSelectedFile());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(MenuFenetre.this.getParent(), "Failed to save file.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
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
			public void actionPerformed(ActionEvent event) {
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
			public void actionPerformed(ActionEvent event) {
				//rafraichirMenus();
			}
		});
		menu.getItem(1).setAccelerator(KeyStroke.getKeyStroke(
				MENU_EDITER_REFAIRE_TOUCHE_RACC,
				MENU_EDITER_REFAIRE_TOUCHE_MASK));
		add(menu);
	}
	
	/**
	 * Créer le menu "Help".
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE,
				new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null,
						LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS),
						LangueConfig.getResource(MENU_AIDE_PROPOS),
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}

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
