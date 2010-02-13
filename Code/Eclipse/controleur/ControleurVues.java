package controleur;

import javax.swing.JLabel;
import javax.swing.JPanel;

import vue.PanelAccueil;
import vue.PanelAutoG�n�rer;
import vue.PanelChargement;
import vue.PanelGrilleDeJeu;
import vue.VuePrincipale;

public class ControleurVues {
	private int tailleGrille ;
	private ControleurM ctrlM ;
	private VuePrincipale vuePrincipal ;
	private PanelAccueil panelAcceuil ;
	private PanelAutoG�n�rer panelAutoGenere ;
	private PanelChargement panelChargement ;
	private PanelGrilleDeJeu panelGrilleDeJeu ;
	
	public ControleurVues(ControleurM pCtrlM) {
		ctrlM = pCtrlM ;
		tailleGrille = ctrlM.getTailleGrille() ;
		vuePrincipal = new VuePrincipale(this) ;
		vuePrincipal.setVisible(true);
	}

	public int getTailleGrille() {
		return tailleGrille;
	}
	
	public ControleurM getCtrlM(){
		return ctrlM ;
	}
	
	public void switchPanel(JPanel pPanel){
		vuePrincipal.remove(vuePrincipal.getCurrentPanel()) ;
		vuePrincipal.add(pPanel) ;
	}
	
	public void refreshGrilleDeJeu(){
		for (int i = 0; i < tailleGrille; i++) {
			for (int j = 0; j < tailleGrille; j++) {
				panelGrilleDeJeu.add(new JLabel(""+getCtrlM().getLaGrille().getCase(i,j).getBatiment().getHauteur()));
			}
		}
	}
	
	public void refreshGrilleDeJeu(int abscisse, int ordonnee){
//		mmmh
	}
	
	
}
