package controleur;

import javax.swing.JLabel;
import javax.swing.JPanel;

import src.Grille;
import vue.DifficulteGeneration;
import vue.PanelAccueil;
import vue.PanelAutoG�n�rer;
import vue.PanelChargement;
import vue.PanelGeneration;
import vue.PanelGrilleDeJeu;
import vue.PanelJeu;
import vue.VuePrincipale;

public class ControleurVues {
	private int tailleGrille ;
	private ControleurM ctrlM ;
	private VuePrincipale vuePrincipal ;
	private PanelAccueil panelAcceuil = null ;
	private PanelAutoG�n�rer panelAutoGenerer = null ;
	private PanelGeneration panelGeneration = null ;
	private PanelChargement panelChargement = null ;
	private PanelJeu panelJeu = null ;
	private PanelGrilleDeJeu panelGrilleDeJeu = null ;
	
	public ControleurVues(ControleurM pCtrlM) {
		ctrlM = pCtrlM ;
		tailleGrille = ctrlM.getTailleGrille() ;
		vuePrincipal = new VuePrincipale(this) ;
		vuePrincipal.setLocationRelativeTo(null) ;
		vuePrincipal.setVisible(true);
		panelAcceuil = new PanelAccueil(this);
		panelAutoGenerer = new PanelAutoG�n�rer(this);
		panelGeneration = new PanelGeneration(this);
		panelChargement = new PanelChargement(this);
		panelJeu = new PanelJeu(this);
		
		switchPanel(panelAcceuil) ;
	}

//*********** Accesseur G�n�raux ***************/
	public int getTailleGrille() {
		return tailleGrille;
	}
	
	public ControleurM getCtrlM(){
		return ctrlM ;
	}
	
//*********** Gestion VUE PRINCIPAL ***************/	
	public void switchPanel(JPanel pPanel){
		if (pPanel == panelGeneration || pPanel == panelGrilleDeJeu)
			vuePrincipal.setSize(600, 400) ;
		else
			vuePrincipal.setSize(300, 400) ;
		vuePrincipal.setContentPane(pPanel) ;
		vuePrincipal.refreshMenu();
		vuePrincipal.validate();
	}

//*********** Partie Grille de jeu ***************/
	public void refreshGrilleDeJeu(){
		panelGrilleDeJeu.refreshGrilleBuffer() ;
	}
	
//	public void refreshGrilleDeJeu(int abscisse, int ordonnee){
//		panelGrilleDeJeu.refreshGrilleBuffer(abscisse, ordonnee) ;
//	}

	
//*********** Accesseur des PANELS ***************/
	public PanelAccueil getPanelAcceuil() {
		if(panelAcceuil==null)
			panelAcceuil = new PanelAccueil(this) ;
		return panelAcceuil;
	}

	public PanelAutoG�n�rer getPanelAutoGenerer() {
		if(panelAutoGenerer==null)
			panelAutoGenerer = new PanelAutoG�n�rer(this) ;
		return panelAutoGenerer;
	}

	public PanelChargement getPanelChargement() {
		if(panelChargement==null)
			panelChargement = new PanelChargement(this) ; 
		return panelChargement;
	}

	public PanelGeneration getPanelGeneration() {
		if(panelGeneration==null)
			panelGeneration = new PanelGeneration(this) ;
		return panelGeneration;
	}

	public PanelGrilleDeJeu getPanelGrilleDeJeu() {
		if (panelGrilleDeJeu==null) ;
			panelGrilleDeJeu = new PanelGrilleDeJeu(this) ;
		return panelGrilleDeJeu;
	}

	public PanelJeu getPanelJeu() {
		if (panelJeu==null)
			panelJeu = new PanelJeu(this) ;
		return panelJeu;
	}

	public VuePrincipale getVuePrincipal() {
		return vuePrincipal;
	}

	
}
