package regleResolutionLogic;

public interface Regle {
	
	public abstract boolean resolve() ; 
}

// il faudrait faire une regle qui compte le nombre de batiment qu'un observateur 
//voit pour placer le batiment le plus grand sur la case adjascente.