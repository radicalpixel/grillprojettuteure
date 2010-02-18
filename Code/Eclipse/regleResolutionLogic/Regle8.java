package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle8 implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle8(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = grille.getTailleGrille();
	}

	// heu � d�faut de trouver une meilleur regle :
	// Des observateurs �gaux � 1 et 2 oppos�s impliquent de construire le b�timent de taille [maximum]
	// � l�or�e de l�observateur �gal � 1 ainsi que de construire le b�timent de taille [maximum � 1]
	// � cot� de l�observateur �gal 2.
	public boolean resolve() {
		boolean solve = false ;
		
		// TO DO
		
		return solve ;
	}
}