/******************************************************
Cours:  LOG121
Projet: Laboratoire 4
Nom du fichier: Command.java
Date cr��: 2013-11-22
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Shaun-David Sauro, Gabriel St-Hilaire, Fr�d�ric Gascon
 *@date 2013-11-22
 *******************************************************/
package ca.etsmtl.log121.labo4.commands;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public  interface Command 
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void execute() ;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void unexecute() ;
	
	
}

