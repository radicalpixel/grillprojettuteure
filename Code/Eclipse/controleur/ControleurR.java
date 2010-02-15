package controleur;

import java.util.Vector;

import regleResolutionLogic.*;
import src.Grille;
import src.Observateur;

public class ControleurR {
	private ControleurM ctrlM ;
	private Grille grille ;
	private Observateur observateur ;
	
	// les r�gles logique de r�solution ;
	private Vector<Regle> tabRegle ;
	
	public ControleurR(ControleurM pCtrlM){
		ctrlM = pCtrlM ;
		grille = ctrlM.getLaGrille() ;
		observateur = ctrlM.getObservateur();
		
		//d�finition des regles logiques de r�solution dans le tableau de regle
		tabRegle = new Vector<Regle>() ;
		tabRegle.add(new Regle1(this)) ;
		tabRegle.add(new Regle2(this)) ;
		tabRegle.add(new Regle3(this)) ;
		tabRegle.add(new Regle4(this)) ;
		tabRegle.add(new Regle5(this)) ; 
	}
	
	// m�thode de r�solution des grilles.
	public void applyRegle(){
		int nbRegle = tabRegle.size();
		for (int i=0; i <nbRegle; i++)
			tabRegle.elementAt(i).resolve() ;
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
