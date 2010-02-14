package controleur;

import regleResolutionLogic.*;
import src.Grille;
import src.Observateur;

public class ControleurR {
	private ControleurM ctrlM ;
	private Grille grille ;
	private Observateur observateur ;
	
	// les r�gles logique de r�solution ;
	private Regle[] tabRegle ;
	
	public ControleurR(ControleurM pCtrlM){
		ctrlM = pCtrlM ;
		grille = ctrlM.getLaGrille() ;
		observateur = ctrlM.getObservateur();
		
		//d�finition des regles logiques de r�solution dans le tableau de regle
		tabRegle = new Regle[1] ;
		tabRegle[0] = new Regle1(this) ;
		tabRegle[1] = new Regle2(this) ;
		tabRegle[2] = new Regle3(this) ;
		tabRegle[3] = new Regle4(this) ;
		tabRegle[4] = new Regle5(this) ; 
	}
	
	
	//***********	Accessur ***********//
	public ControleurM getCtrlM() {
		return ctrlM;
	}

	public Grille getGrille() {
		return grille;
	}

	public Observateur getObservateur() {
		return observateur;
	}
	
	
}
