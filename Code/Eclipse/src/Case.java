/**
 * @(#)Case.java
 *
 *
 * @author 
 * @version 1.00 2009/11/18
 */
package src ;
import java.util.Vector ;

public class Case {
	Batiment batiment ;
	Vector<Integer> possibilite ;
	
	// le giagramme de classe est faux ici, il faut qu'une case soit instencier avec un Int !
	// c'est du au fait qu'on est besoin de savoir quel taille de batiment on peut construire !
    public Case(int pTaille) {
    	// on n'a aucun batiment sur la Case donc :
    	batiment = null ;
    	
    	// mais on construit le vector des possibilit� des batiments !
    	possibilite = new Vector<Integer>() ;
    	for (int i=1 ; i<=pTaille ; i++)
    		possibilite.add(i) ;
    	
    	// optimisation de la taille du vector en m�moire
    	possibilite.trimToSize() ;
    }
    
    public boolean estConstrutible(Batiment pBat){
    	//d�claration des variables locales
    	boolean constructible = false ;			// la valeur retourn�e
    	int tailleVec=possibilite.size() ;		// variable tempon pour �viter de faire appelle � size() dans le for
    	int tailleBat=pBat.getHauteur() ;		// idem avec getHauteur()
    	
    	// on parcourt le vector pour comparer les �l�ments qu'il contient avec la taille du batiment
    	for( int i=1 ; i<=tailleVec && !constructible ; i++ ){
    		if( possibilite.elementAt(i-1) == tailleBat )
    			constructible = true ;
    	}
    	return constructible ;
    }
    
    public void construire(Batiment pBat){
    	batiment = pBat ;
    }
    
    public Batiment getBatiment(){
    	return batiment ;
    }
    
    // nom � revoir, puisque cette m�thode ne fera que supprim� des integer du vector de possibilit� de batiment
    public void setPossibilite(Batiment pBat){
    	// un simple possibilite.remove(pBat.getHauteur()) ne marcherais pas, puisqu'on supprimerais l'objet au rang getHauteur()
    	// et non l'Integer contenant getHauteur()... je ne sais pas si un Cast suffirais ou pas... mais je ne pense pas.
    	// Puisqu'avec un cast on obtiendrait un objet integer contenant bien getHauteur() mais de ref dif�rente de celui du Vector
    	
    	boolean del = false ;			
    	int tailleVec=possibilite.size() ;		// variable tempon pour �viter de faire appelle � size() dans le for
    	int tailleBat=pBat.getHauteur() ;		// idem avec getHauteur()
    	
    	for( int i=1 ; i<=tailleVec && !del ; i++ ){
    		if( possibilite.elementAt(i-1) == tailleBat ){
    			possibilite.remove(i) ;			// on remove l'Objet au rang i
    			del = true ;
    		}
    	}	
    }
    
    
}