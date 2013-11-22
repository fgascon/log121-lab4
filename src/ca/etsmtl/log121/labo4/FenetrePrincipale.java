package ca.etsmtl.log121.labo4;
import java.awt.BorderLayout;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JFrame;

//import lab1.MenuFenetre;

import ca.etsmtl.log121.labo4.views.ImageView;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class FenetrePrincipale extends JFrame
{
	private final int DEFAULT_WIDTH = 750;
	private final int DEFAULT_HEIGHT = 500;
	
	public Set<ImageView> imageView;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Application application;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public FenetrePrincipale(){
		this.setLayout(new BorderLayout());
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		MenuFenetre menu = new MenuFenetre();
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void creerView() {
		// TODO : to implement	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void operation() {
		// TODO : to implement	
	}
	
}

