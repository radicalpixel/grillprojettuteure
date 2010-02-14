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
	int batiment ;
	Vector<Integer> possibilite ;
	
	// le giagramme de classe est faux ici, il faut qu'une case soit instencier avec un Int !
	// c'est du au fait qu'on est besoin de savoir quel taille de batiment on peut construire !
    public Case(int pTaille) {
    	batiment = 0 ;	//on n'a aucun batiment sur la Case
    	possibilite = new Vector<Integer>() ; // mais on construit le vector des possibilit� des batiments !
    	for (int i=1 ; i<=pTaille ; i++)
    		possibilite.add(i) ;
    	possibilite.trimToSize() ;	// optimisation de la taille du vector en m�moire
    }
    
    public boolean estConstrutible(int pBat){
    	//d�claration des variables locales
    	boolean constructible = false ;			// la valeur retourn�e
    	int tailleVec=possibilite.size() ;		// variable tempon pour �viter de faire appelle � size() dans le for
    	
    	// on parcourt le vector pour comparer les �l�ments qu'il contient avec la taille du batiment
    	for( int i=0 ; i<tailleVec && !constructible ; i++ ){
    		if( possibilite.elementAt(i) == pBat )
    			constructible = true ;
    	}
    	return constructible ;
    }
    
    public void construire(int pBat){
    	batiment = pBat ;
    }
    
    public int getBatiment(){
    	return batiment ;
    }
    
    // M�thode qui supprime des integer du vector de possibilit� de batiment
    public void refreshPossibilite(int hauteur){
    	// un simple possibilite.remove(pBat.getHauteur()) ne marcherais pas, puisqu'on supprimerais l'objet au rang getHauteur()
    	// et non l'Integer contenant getHauteur()... je ne sais pas si un Cast suffirais ou pas... mais je ne pense pas.
    	// Puisqu'avec un cast on obtiendrait un objet integer contenant bien getHauteur() mais de ref dif�rente de celui du Vector
    	boolean del = false ;			
    	int tailleVec=possibilite.size() ;		// variable tempon pour �viter de faire appelle � size() dans le for
    	for( int i=0 ; i<tailleVec && !del ; i++ ){
    		if( possibilite.elementAt(i) == hauteur ){
    			possibilite.removeElementAt(i) ;	// on remove l'Objet au rang i
    			del = true ;
    		}
    	}	
    }
    
    
}