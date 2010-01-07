package src;
/**
 * @(#)Grill.java
 *
 * Grill application Projet tuteur�
 *
 * @author Andres Gomez, Brard, Escudery, Lapalu
 * @version 1.00 2009/11/18
 */
import java.util.Vector ;

public class ProjetGrill {
    
    public static void main(String[] args) {
    	
    	// TODO, add your application code
    	System.out.println("Hello World!");
    	  	
    	Vector<Integer> possibilite ;
    	possibilite = new Vector<Integer>() ;
    	
    	for( int i=1 ; i<=5 ; i++)
    		possibilite.add(i) ;
    	
    	boolean constructible = false ;			// la valeur retourn�e
    	int tailleVec=possibilite.size() ;		// variable tempon pour �viter de faire appelle � size() dans le for
    	int tailleBat=4 ;		// idem avec getHauteur()
    	
    	// on parcourt le vector pour comparer les �l�ments qu'il contient avec la taille du batiment
    	for( int i=1 ; i<tailleVec+1 && !constructible ; i++ ){
    		if( possibilite.elementAt(i-1) == tailleBat )
    			constructible = true ;
    	}
    	
    	System.out.print(constructible) ;
    }
}
