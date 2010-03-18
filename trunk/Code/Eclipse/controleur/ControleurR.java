package controleur;

import java.util.Vector;
import regleResolutionLogic.*;
import regleResolutionLogicObservateur.*;
import src.Grille;
import src.Observateur;

public class ControleurR {
	private ControleurM ctrlM ;
	private Grille grille ;
	private Observateur observateur ;
	private int tailleGrille ;
	
	// les r�gles logique de r�solution ;
	private Vector<Regle> tabRegle ;
	private Vector<Regle> tabReglePossibilite ;
	
	public ControleurR(ControleurM pCtrlM){
		ctrlM = pCtrlM ;
		grille = ctrlM.getLaGrille() ;
		observateur = ctrlM.getObservateur();
		tailleGrille = ctrlM.getTailleGrille() ;
		initialise() ;
	}
	
	public ControleurR(ControleurM pCtrlM,Grille pGrille,int pTailleGrille,Observateur pObs){
		ctrlM = pCtrlM ;
		grille = pGrille ;
		observateur = pObs ;
		tailleGrille = pTailleGrille ;
		initialise() ;
	}
	
	public void initialise(){
		//d�finition des regles logiques de r�solution dans le tableau de regle
		tabRegle = new Vector<Regle>() ;
		tabReglePossibilite = new Vector<Regle>() ;
		
		tabReglePossibilite.add(new Regle_DistanceMin(this)) ;
		tabReglePossibilite.add(new Regle_MinTaille(this)) ;
		tabReglePossibilite.add(new Regle_ImpoMax(this)) ;
		tabReglePossibilite.add(new Regle_Pioupiou(this)) ;
		
		//Regles de possibilit�
		tabRegle.add(new Regle_DistanceMin(this)) ;			// TESTER
		tabRegle.add(new Regle_MinTaille(this)) ;			// TESTER
		tabRegle.add(new Regle_ImpoMax(this)) ;				// TESTER foireuse
		tabRegle.add(new Regle_Pioupiou(this)) ;
		
		//Regles de contruction
		tabRegle.add(new Regle_Observateur1(this)) ;
		tabRegle.add(new Regle_DernierVecBat(this)) ;
		tabRegle.add(new Regle_DernierTypBat(this)) ;
		
		//regle bas� sur une taille particuliere de grille
//		tabRegle.add(new Regle_ObservateurDoitVoir(this,tailleGrille)) ;
	}
	
	// m�thode de r�solution des grilles.
	public boolean applyRegle(){
		System.out.println("--> DEBUT DE RESOLUTION DE LA GRILLE <--");
		int nbRegle = tabRegle.size();
		boolean solve = true ;
		boolean temp ;
		int total = ctrlM.getTailleGrille() * ctrlM.getTailleGrille() ;
		while(solve==true && ctrlM.getBatConstruit()!=total){
			solve = false ;
			for (int i=0; i <nbRegle; i++){
				System.out.println("--> "+tabRegle.elementAt(i).getClass());
				temp = tabRegle.elementAt(i).resolve() ;
				solve = solve || temp ;
				System.out.println("<-- RETOUR - solve "+temp);
			}
			System.out.println("boucle r�solution CONTROLEURR : solve "+solve);
		}
		System.out.print("--> FIN DE RESOLUTION DE LA GRILLE <--");
		if(solve)
			System.out.println(" RESOLUE");
		else
			System.out.println(" probleme rencontr� lors de la r�solution...");
		return solve ;
	}
	
	public boolean applyReglePossibilite(){
		System.out.println("--> DEBUT DE RESTRICTION DE LA GRILLE <--");
		int nbRegle = tabReglePossibilite.size();
		boolean solve = true ;
		boolean temp ;

		while(solve==true){
			solve = false ;
			for (int i=0; i <nbRegle; i++){
				System.out.println("--> "+tabReglePossibilite.elementAt(i).getClass());
				temp = tabReglePossibilite.elementAt(i).resolve() ;
				solve = solve || temp ;
				System.out.println("<-- RETOUR - solve: "+temp);
			}
			System.out.println("boucle r�solution CONTROLEUR RESTRICTION : solve: "+solve);
		}
		System.out.print("--> FIN DE RESTRICTION DE LA GRILLE <--");
		
		return solve ;
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

	public int getTailleGrille() {
		return tailleGrille;
	}
	
	
}
