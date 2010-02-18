package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle4 implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle4(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = grille.getTailleGrille();
	}

	public void refreshBuffer() {
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
	}

	//compte le nombre de batiment qu'un observateur 
	//voit pour placer le batiment le plus grand sur la case adjascente 
	public boolean resolve() {
		boolean solve = false ;
		
		// !!!!!!!!!!!!!!!!!! OBSERVATEUR NORD !!!!!!!!!!!!!!!!!!
		for(int abscisse=1; abscisse<=tailleGrille; abscisse++){			// on parcourt l'ensemble des observateurs nord
			int hauteurMaxObs = 0 ;											// on d�finit la hauteur max observer actuellement par l'obs
			int nbBatiment = 0 ;											// on d�finit le nombre de batiment actuellement observ� par l'obs
			int distanceBatMax = 0 ;										// distance du batiment le plus haut
			boolean unicite = true ;										// pour pr�server l'unicit� de la solution
			for(int ordonnee=1; ordonnee<=tailleGrille; ordonnee++){		// on parcour la grille verticalement
				int tempBat = grille.getCase(abscisse,ordonnee).getBatiment() ;
				if(tempBat!=0){		// si un batiment est construit...
					if(hauteurMaxObs<tempBat){
						hauteurMaxObs = tempBat ;
						distanceBatMax = ordonnee ;
						unicite = true ; 			// on r�initialise l'unicit�
						nbBatiment++ ;
					}
				}
				else {
					unicite = false ; // si cette partie est �x�cut� avant avoir trouv� le batMax, alors elle est sans importance
					// apres avoir trouv� le batMax cette affectation permet de savoir si l'unicit� est pr�serv�. 
				}
			}
			//ici nous avons le nombre de batiment observ�s, la hauteur du batiment le plus grand, sa distance avec l'observateur.
			//et surtout nous savons si des batiments sont construit apres le batMax
			
			System.out.println("unicit� "+unicite);
			if(unicite){	//ne parcourt pas la suite du code si l'unicit� n'est pas pr�serv� !
				//on se place dans le cas ou il manque un batiment � l'observateur pour compl�ter sa vue
				//et ou derriere le batiment de tailleMax
				System.out.println("obs "+ observateur.getObservateur(Observateur.NORD,abscisse) + " nbB" + (nbBatiment-1));
				if(observateur.getObservateur(Observateur.NORD,abscisse)==nbBatiment+1){
					//je prend la case la plus proche constructible
					for(int ordonnee=1; ordonnee<distanceBatMax && !solve; ordonnee++){
						if(grille.getCase(abscisse,ordonnee).isCaseConst()){
							solve = grille.construire(abscisse,ordonnee,grille.getCase(abscisse,ordonnee).tailleMaxBatConst()) ;
						}
					}
				}	
			}
		}
		
		return solve ;
	}

	public void applyResolve() {
		// TODO Auto-generated method stub
		
	}

}
