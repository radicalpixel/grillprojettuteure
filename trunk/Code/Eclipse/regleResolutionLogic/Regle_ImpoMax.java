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
		tailleGrille = grille.getTailleGrille();
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
				for(int ordonnee=valeurObservateur-1; ordonnee>=1; ordonnee--){
					System.out.print("abscisse: "+abscisse+" ordonnee: "+ordonnee+" ");
					solve = solve || grille.getCase(abscisse,ordonnee).refreshPossibiliteMax((grille.getMaxColonne(abscisse)+1)-(valeurObservateur-ordonnee)) ;
				}
			}
		}
		
		//OBERSVATEUR SUD
		for(int abscisse=1; abscisse<=tailleGrille; abscisse++){
			// on r�cupere la valeur de l'observateur
			int valeurObservateur = observateur.getObservateur(Observateur.SUD,abscisse) ;		
			// on v�rifie que le batiment observ� � la distance de l'observateur soit de tailleMAX
			if(valeurObservateur!=0 && grille.getCase(abscisse,tailleGrille-valeurObservateur+1).getBatiment() == tailleGrille){
				for(int ordonnee=(tailleGrille-valeurObservateur+2); ordonnee<=tailleGrille; ordonnee++){
					System.out.print("abscisse: "+abscisse+" ordonnee: "+ordonnee+" ");
					solve = solve || grille.getCase(abscisse,ordonnee).refreshPossibiliteMax((grille.getMaxColonne(abscisse)+1)-(valeurObservateur-(tailleGrille-ordonnee+1))) ;
				}
			}
		}
		
		//OBERSVATEUR EST
		for(int ordonnee=1; ordonnee<=tailleGrille; ordonnee++){
			// on r�cupere la valeur de l'observateur
			int valeurObservateur = observateur.getObservateur(Observateur.EST,ordonnee) ;		
			// on v�rifie que le batiment observ� � la distance de l'observateur soit de tailleMAX
			if(valeurObservateur!=0 && grille.getCase(tailleGrille-valeurObservateur+1,ordonnee).getBatiment() == tailleGrille){
				for(int abscisse=(tailleGrille-valeurObservateur+2); abscisse<=tailleGrille; abscisse++){
					System.out.print("abscisse: "+abscisse+" ordonnee: "+ordonnee+" ");
					solve = solve || grille.getCase(abscisse,ordonnee).refreshPossibiliteMax((grille.getMaxLigne(ordonnee)+1)-(valeurObservateur-(tailleGrille-abscisse+1))) ;
				}
			}
		}
		
		//OBERSVATEUR OUEST
		for(int ordonnee=1; ordonnee<=tailleGrille; ordonnee++){
			// on r�cupere la valeur de l'observateur
			int valeurObservateur = observateur.getObservateur(Observateur.OUEST,ordonnee) ;		
			// on v�rifie que le batiment observ� � la distance de l'observateur soit de tailleMAX
			if(valeurObservateur!=0 && grille.getCase(valeurObservateur,ordonnee).getBatiment() == tailleGrille){
				for(int abscisse=valeurObservateur-1; abscisse>=1; abscisse--){
					System.out.print("abscisse: "+abscisse+" ordonnee: "+ordonnee+" ");
					solve = solve || grille.getCase(abscisse,ordonnee).refreshPossibiliteMax((grille.getMaxLigne(ordonnee)+1)-(valeurObservateur-abscisse)) ;
				}
			}
		}
		
		return solve;
	}

}
