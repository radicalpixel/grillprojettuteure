/**
 * @(#)Grille.java
 *
 *
 * @author 
 * @version 1.00 2009/11/18
 */
package src ;

import controleur.ControleurM;

public class Grille {
	
	Case[][] grilleDejeu ;
	int tailleGrille ;
	ControleurM ctrlM ;
	
    public Grille(ControleurM pCtrlM) {
    	this(pCtrlM,4) ;
    }

    // dans le diagramme de classe il manque le constructeur de Grille qui permet de "faire" des observateurs !
    // je le fais quand m�me
    public Grille(ControleurM pCtrlM, int pTaille){
    	ctrlM = pCtrlM ;
    	// on sauvegarde la taille de la grille dans une variable int
    	tailleGrille = pTaille ;
    	// on fait une nouvelle instance d'une grille
    	grilleDejeu = new Case[pTaille][pTaille] ;
    	
    	
    	// on instancie les cases
    	for(int i=0 ; i<tailleGrille ; i++ ){
    		for(int j=0 ; j<tailleGrille ; j++){
    			grilleDejeu[i][j] = new Case(tailleGrille) ;
    		}
    	}
    }
    
    public Case getCase(int pAbscisse, int pOrdonnee){
    	return grilleDejeu[pOrdonnee-1][pAbscisse-1] ;
    }
    
    // contruire avec cette m�thode ci uniquement !
    public boolean construire(int pAbscisse, int pOrdonnee, int pBatiment){
    	if (getCase(pAbscisse,pOrdonnee).estConstrutible(pBatiment)){
	    	getCase(pAbscisse,pOrdonnee).construire(pBatiment) ;
	    	// on supprime le batiment des vector de possibilit� des autres cases
	    	for (int i=1; i<=tailleGrille ;i++){
	    		getCase(pAbscisse,i).refreshPossibilite(pBatiment);
	    		getCase(i,pOrdonnee).refreshPossibilite(pBatiment);
	    	}
	    	System.out.println("BATIMENT CONSTRUIT Abscisse : "+pAbscisse+" Ordonnee : "+pOrdonnee+" Batiment : "+pBatiment);
	    	//on ajoute un batiment construit au compteur du controleur;
	    	ctrlM.addBatConstruit() ;
	    	return true ;
    	}
    	else
    		return false ;
    }
    
    public boolean reContruire(int pAbscisse, int pOrdonnee, int pBatiment){
    	// on doit ici reprendre les vecteurs de possibilit� des cases sur la meme ligne/colonne
    	// que le batiment pr�c�demment construit, il faut rajouter � ces cases la valeur du batiment
    	// remplacer en veillant � ce ces "possibilit�s" soit "possible"
    	boolean construit = false;
    	
    	// si un batiment est d�j� contruit
    	if (!getCase(pAbscisse,pOrdonnee).estConstrutible(pBatiment)){
    		construit = true ;
    
    		// on d�finie une nouvelle grille et on l'initialise
    		Case[][] tempGrille = new Case[tailleGrille][tailleGrille];
    		for(int i=0 ; i<tailleGrille ; i++ ){
        		for(int j=0 ; j<tailleGrille ; j++){
        			tempGrille[i][j] = new Case(tailleGrille) ;
        		}
        	}
    		
			for(int abscisse=1; abscisse<=tailleGrille; abscisse++){
    			for(int ordonnee=1; ordonnee<=tailleGrille; ordonnee++){
    				if(abscisse!=pAbscisse && ordonnee!=pOrdonnee){
    					// on r�cupere l'ancienne valeur
    		    		int ancientBat = getCase(abscisse,ordonnee).getBatiment() ;
    					// on construit sur la grille temp le batiment contruit sur la case de la grille normale
    		    		if(ancientBat!=0){
	    					tempGrille[ordonnee-1][abscisse-1].construire(ancientBat) ;
	    			    	// on supprime le batiment des vector de possibilit� des autres cases
	    			    	for (int i=0; i<tailleGrille ;i++){
	    			    		tempGrille[i][abscisse-1].refreshPossibilite(ancientBat);
	    			    		tempGrille[ordonnee-1][i].refreshPossibilite(ancientBat);
	    			    	}
    					}
    				}
    			}
    		}
    		grilleDejeu = tempGrille ;
    		if(pBatiment!=0)
    			construire(pAbscisse, pOrdonnee, pBatiment) ;
    		
    		System.out.println("BATIMENT RE-CONSTRUIT Abscisse : "+pAbscisse+" Ordonnee : "+pOrdonnee+" Batiment : "+pBatiment);
    	}
    	
    	return construit ;
    }

    public int getMaxLigne(int pOrdonnee){
    	int maxBat = 0 ;
    	for(int i=1;i<=tailleGrille;i++){
    		if(maxBat<getCase(i,pOrdonnee).tailleMaxBatConst())
    			maxBat = getCase(i,pOrdonnee).tailleMaxBatConst() ;
    	}
    	return maxBat ;
    }
    
    public int getMaxColonne(int pAbscisse){
    	int maxBat = 0 ;
    	for(int i=1;i<=tailleGrille;i++){
    		if(maxBat<getCase(pAbscisse,i).tailleMaxBatConst())
    			maxBat = getCase(pAbscisse,i).tailleMaxBatConst() ;
    	}
    	return maxBat ;
    }
    
	public int getTailleGrille() {
		return tailleGrille;
	}
}