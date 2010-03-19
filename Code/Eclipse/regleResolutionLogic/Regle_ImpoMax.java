package regleResolutionLogic;

import controleur.ControleurR;
import src.Grille;
import src.Observateur;

/**
 *  
 * @author Andres Gomez Thomas
 * @category Regle
 * 
 * Cette regle gere le cas d'un batiment trop grand pour etre plac� � cot� d'un observateur.
 * Sorte de g�n�ralisation (avec le contexte des batiments d�j� placer) de la r�gle m-n+d
 */
public class Regle_ImpoMax implements Regle {
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	/**
	 * Constructeur par d�faut
	 * @param pCtrlR
	 */
	public Regle_ImpoMax(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = ctrlR.getTailleGrille();
	}
	
	/**
	 * Cette regle gere le cas d'un batiment trop grand pour etre plac� � cot� d'un observateur.
	 * Sorte de g�n�ralisation (avec le contexte des batiments d�j� placer) de la r�gle m-n+d 
	 */
	@Override	
	public boolean resolve() {
		boolean solve = false ;
		
		//OBERSVATEUR NORD
		for(int abscisse=1; abscisse<=tailleGrille; abscisse++){
			// on r�cupere la valeur de l'observateur
			int valeurObservateur = observateur.getObservateur(Observateur.NORD,abscisse) ;		
			// on v�rifie que le batiment observ� � la distance de l'observateur soit de tailleMAX
			if(valeurObservateur!=0 && grille.getCase(abscisse,valeurObservateur).getBatiment() == tailleGrille){
				// on doit v�rifier qu'aucun b�timent n'a �t� construit entre l'obs et le bat de tailleMax
				boolean unicite = true ;
				for(int ordonnee=valeurObservateur-1; ordonnee>=1; ordonnee--)
					unicite = unicite && (grille.getCase(abscisse,ordonnee).getBatiment()==0) ;
				if(unicite){
					for(int ordonnee=valeurObservateur-1; ordonnee>=1; ordonnee--){
						System.out.print("abscisse: "+abscisse+" ordonnee: "+ordonnee+" ");
						solve = solve || grille.getCase(abscisse,ordonnee).refreshPossibiliteMax((grille.getMaxColonne(abscisse)+1)-(valeurObservateur-ordonnee)) ;
					}
				}
			}
		}
		
		//OBERSVATEUR SUD
		for(int abscisse=1; abscisse<=tailleGrille; abscisse++){
			// on r�cupere la valeur de l'observateur
			int valeurObservateur = observateur.getObservateur(Observateur.SUD,abscisse) ;		
			// on v�rifie que le batiment observ� � la distance de l'observateur soit de tailleMAX
			if(valeurObservateur!=0 && grille.getCase(abscisse,tailleGrille-valeurObservateur+1).getBatiment() == tailleGrille){
				boolean unicite = true ;
				for(int ordonnee=(tailleGrille-valeurObservateur+2); ordonnee<=tailleGrille; ordonnee++)
					unicite = unicite && (grille.getCase(abscisse,ordonnee).getBatiment()==0) ;
				if(unicite){
					for(int ordonnee=(tailleGrille-valeurObservateur+2); ordonnee<=tailleGrille; ordonnee++){
						System.out.print("abscisse: "+abscisse+" ordonnee: "+ordonnee+" ");
						solve = solve || grille.getCase(abscisse,ordonnee).refreshPossibiliteMax((grille.getMaxColonne(abscisse)+1)-(valeurObservateur-(tailleGrille-ordonnee+1))) ;
					}
				}
			}
		}
		
		//OBERSVATEUR EST
		for(int ordonnee=1; ordonnee<=tailleGrille; ordonnee++){
			// on r�cupere la valeur de l'observateur
			int valeurObservateur = observateur.getObservateur(Observateur.EST,ordonnee) ;		
			// on v�rifie que le batiment observ� � la distance de l'observateur soit de tailleMAX
			if(valeurObservateur!=0 && grille.getCase(tailleGrille-valeurObservateur+1,ordonnee).getBatiment() == tailleGrille){
				boolean unicite = true ;
				for(int abscisse=(tailleGrille-valeurObservateur+2); abscisse<=tailleGrille; abscisse++)
					unicite = unicite && (grille.getCase(abscisse,ordonnee).getBatiment()==0) ;
				if(unicite){
					for(int abscisse=(tailleGrille-valeurObservateur+2); abscisse<=tailleGrille; abscisse++){
						System.out.print("abscisse: "+abscisse+" ordonnee: "+ordonnee+" ");
						solve = solve || grille.getCase(abscisse,ordonnee).refreshPossibiliteMax((grille.getMaxLigne(ordonnee)+1)-(valeurObservateur-(tailleGrille-abscisse+1))) ;
					}
				}
			}
		}
		
		//OBERSVATEUR OUEST
		for(int ordonnee=1; ordonnee<=tailleGrille; ordonnee++){
			// on r�cupere la valeur de l'observateur
			int valeurObservateur = observateur.getObservateur(Observateur.OUEST,ordonnee) ;		
			// on v�rifie que le batiment observ� � la distance de l'observateur soit de tailleMAX
			if(valeurObservateur!=0 && grille.getCase(valeurObservateur,ordonnee).getBatiment() == tailleGrille){
				boolean unicite = true ;
				for(int abscisse=valeurObservateur-1; abscisse>=1; abscisse--)
					unicite = unicite && (grille.getCase(abscisse,ordonnee).getBatiment()==0) ;
				if(unicite){
					for(int abscisse=valeurObservateur-1; abscisse>=1; abscisse--){
						System.out.print("abscisse: "+abscisse+" ordonnee: "+ordonnee+" ");
						solve = solve || grille.getCase(abscisse,ordonnee).refreshPossibiliteMax((grille.getMaxLigne(ordonnee)+1)-(valeurObservateur-abscisse)) ;
					}
				}
			}
		}
		
		return solve;
	}

}
