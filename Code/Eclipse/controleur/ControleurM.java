package controleur;

import java.util.Vector;

import src.Grille;
import src.Observateur;

public class ControleurM {
	private int tailleGrille ;
	private Grille laGrille ;
	private Observateur observateur ;
	private int difficulte ;
	private ControleurVues ctrlVues ;
	private ControleurR ctrlRegl;
	private boolean gameStart;
	private boolean tricheBouton = false ;
	private boolean aideTrouver = false ;
	private boolean aideErreur = false ;
	
	/**
	 * constructeur par d�faut du controleur Ma�tre
	 * initialise quelques variables.
	 */
	public ControleurM(){
		gameStart = false ;
		laGrille = null ;
		observateur = null ;
		difficulte = 0 ;
		tailleGrille = 0 ;
		ctrlVues = new ControleurVues(this) ;
	}
	
	/**
	 * m�thode d'initialisation de partie.
	 * @param pTaille	     taille de la grille souhait� 
	 * @param pDifficulte	 dificult� de la grille 
	 */
	public void commencerPartie(int pTaille, int pDifficulte){
		tailleGrille = pTaille ;
		difficulte = pDifficulte ;
		gameStart = true ; // pour l'instant on ne gere pas la fin de partie
		
		// ce code ne sert qu'a tester
		laGrille = new Grille(tailleGrille) ;
		int[][] obsTemp = new int[4][4] ;
		
		obsTemp[Observateur.NORD][0] = 2;
		obsTemp[Observateur.NORD][1] = 3;
		obsTemp[Observateur.NORD][2] = 1;
		obsTemp[Observateur.NORD][3] = 2;
		obsTemp[Observateur.EST][0] = 2;
		obsTemp[Observateur.EST][1] = 3;
		obsTemp[Observateur.EST][2] = 3;
		obsTemp[Observateur.EST][3] = 1;
		obsTemp[Observateur.SUD][0] = 2;
		obsTemp[Observateur.SUD][1] = 2;
		obsTemp[Observateur.SUD][2] = 3;
		obsTemp[Observateur.SUD][3] = 1;
		obsTemp[Observateur.OUEST][0] = 3;
		obsTemp[Observateur.OUEST][1] = 1;
		obsTemp[Observateur.OUEST][2] = 2;
		obsTemp[Observateur.OUEST][3] = 2;
		observateur = new Observateur(obsTemp);
		
//		obsTemp[Observateur.NORD][0] = 1;
//		obsTemp[Observateur.NORD][1] = 2;
//		obsTemp[Observateur.NORD][2] = 2;
//		obsTemp[Observateur.NORD][3] = 2;
//		obsTemp[Observateur.EST][0] = 3;
//		obsTemp[Observateur.EST][1] = 3;
//		obsTemp[Observateur.EST][2] = 1;
//		obsTemp[Observateur.EST][3] = 2;
//		obsTemp[Observateur.SUD][0] = 4;
//		obsTemp[Observateur.SUD][1] = 3;
//		obsTemp[Observateur.SUD][2] = 1;
//		obsTemp[Observateur.SUD][3] = 2;
//		obsTemp[Observateur.OUEST][0] = 1;
//		obsTemp[Observateur.OUEST][1] = 2;
//		obsTemp[Observateur.OUEST][2] = 3;
//		obsTemp[Observateur.OUEST][3] = 3;
//		observateur = new Observateur(obsTemp); 
	}
	
	public void finirPartie(){
		laGrille = null ;
		observateur = null ;
	}

	//******* R�solution de la Grille ********/
	public void resolve(){
		ctrlRegl = new ControleurR(this) ;
		ctrlRegl.applyRegle() ;
	}
	
	//******* Gestion des booleen de triche ******/
	public void tricheBouton(){
		tricheBouton = !tricheBouton ;
	}
	
	public void aideTrouver(){
		aideTrouver = !aideTrouver ;
	}
	
	public void aideErreur(){
		aideErreur = !aideErreur ;
	}
	
	//******* Accesseur *************/
	public Grille getLaGrille() {
		return laGrille;
	}

	public int getTailleGrille() {
		return tailleGrille;
	}
	
	public ControleurVues getCtrlVues() {
		return ctrlVues ;
	}
	
	public boolean GetGameStart(){
		return gameStart ;
	}

	public boolean isTricheBouton() {
		return tricheBouton;
	}
	
	public boolean isAideTrouver(){
		return aideTrouver ;
	}
	
	public boolean isAideErreur(){
		return aideErreur ;
	}

	public int getThisObs(int pCardinal,int pPosition){
		return observateur.getObservateur(pCardinal, pPosition) ;
	}
	
	public Observateur getObservateur() {
		return observateur;
	}

	public void setLaGrille(Grille laGrille) {
		this.laGrille = laGrille;
	}
	
	//DEBUGAGE
	/**
	 * m�thode qui permet de renvoyer un string du contenu du vecteur de possibilit�
	 * utiliser en Debugage des r�gles
	 * @param vector d'integer
	 * @return contenu du vecteur
	 */
	public String vecpo( final Vector<Integer> pt){
		String ret = "None" ;
		if (pt.size()!=0){
			for(int i=0; i<pt.size(); i++)
				ret = ret + pt.elementAt(i) + "," ;
		}
		return ret;
	}
}
