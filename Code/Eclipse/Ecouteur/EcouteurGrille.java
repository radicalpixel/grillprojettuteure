package Ecouteur;

import images.GestionIcon;
import images.IconBat;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import src.Observateur;
import sun.awt.RequestFocusController;
import controleur.ControleurM;
import controleur.ControleurVues;

/**
 * ce panel permet de traiter le cas g�n�ral de la grille de jeu, il permet de r�cup�rer les informations
 * saisie aux claviers lors d'une partie et appelle les m�thode de traitement de l'information.
 * @author Andres Gomez Thomas
 *
 */
public class EcouteurGrille implements MouseListener, KeyListener{
	private ControleurM ctrlM ;
	private JLabel caseLabel ;
	private int abscisse ;
	private int ordonnee ;
	
	public EcouteurGrille(ControleurVues pCtrlV,JLabel pLabel,int pAbscisse, int pOrdonnee) {
		super();
		caseLabel = pLabel ;
		abscisse = pAbscisse ;
		ordonnee = pOrdonnee ;
		ctrlM = pCtrlV.getCtrlM() ;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		caseLabel.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.RED)) ;
		caseLabel.requestFocus();	// n�cessaire pour le Keylistener
	}
	@Override
	public void mouseExited(MouseEvent e) {
		caseLabel.setBorder(BorderFactory.createEtchedBorder()) ;
	}

	@Override
	public void mousePressed(MouseEvent e){ }
	@Override
	public void mouseReleased(MouseEvent e){
		// affichage consoLE
		System.out.print("Mouse Clicked upon case Abs:"+abscisse+" Ord:"+ordonnee);
		System.out.print(" -- Batiment:"+ctrlM.getLaGrille().getCase(abscisse,ordonnee).getBatiment());
		System.out.print(" Possibilite:"+ctrlM.vecpo(ctrlM.getLaGrille().getCase(abscisse,ordonnee).getPossibilite()));
		System.out.print(" -- Observateur ||");
		System.out.print(" Nord "+ctrlM.getThisObs(Observateur.NORD,abscisse));
		System.out.print(" Est "+ctrlM.getThisObs(Observateur.EST,ordonnee));
		System.out.print(" Sud "+ctrlM.getThisObs(Observateur.SUD,abscisse));
		System.out.println(" Ouest "+ctrlM.getThisObs(Observateur.OUEST,ordonnee));
		//gestion du comportement du clic
		if(ctrlM.isAideTrouver()){
			ctrlM.setBatAideTrouver(ctrlM.getLaGrille().getCase(abscisse,ordonnee).getBatiment()) ;
			ctrlM.getCtrlVues().refreshGrilleDeJeu() ;
		}
		// plus pratique dans cette m�thode que dans le mouseClicked car dnas l'autre m�thode 
		// si l'on bouge la sourie lors du clic, meme en restant dans le label, la m�thode ne sera
		// pas appeler. Ici oui
	}
	
	
	//PARTIE CLAVIER
	@Override
	public void keyPressed(KeyEvent e){ }

	@Override
	public void keyReleased(KeyEvent e){ }

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("abs:"+abscisse+" ord:"+ordonnee+" KeyPressed:"+e.getKeyChar());
		if(e.getKeyChar()=='1'||e.getKeyChar()=='2'||e.getKeyChar()=='3'
			||e.getKeyChar()=='4'||e.getKeyChar()=='5'||e.getKeyChar()=='6'||e.getKeyChar()=='0'){
			int temp = Integer.parseInt(e.getKeyChar()+"") ;
			if (ctrlM.getLaGrille().construire(abscisse,ordonnee,temp)){
				if(ctrlM.isAideTrouver())
					ctrlM.getCtrlVues().refreshGrilleDeJeu() ;
				else
					ctrlM.getCtrlVues().refreshGrilleDeJeu(abscisse,ordonnee,null);
				
				if(ctrlM.isFinGame()){
//					JOptionPane.showMessageDialog(ctrlM.getCtrlVues().getVuePrincipal(), "BRAAAAAAVOOOOOO");
					ctrlM.getCtrlVues().getVictoire() ;
				}
			}
		}
		if(e.getKeyChar()=='&'||e.getKeyChar()=='�'||e.getKeyChar()=='"'
			||e.getKeyChar()=='\''||e.getKeyChar()=='('||e.getKeyChar()=='-'||e.getKeyChar()=='�'){
			int temp = 0 ;
			if(e.getKeyChar()=='&')
				temp = 1 ;
			if(e.getKeyChar()=='�')
				temp = 2 ;
			if(e.getKeyChar()=='"')
				temp = 3 ;
			if(e.getKeyChar()=='\'')
				temp = 4 ;
			if(e.getKeyChar()=='(')
				temp = 5 ;
			if(e.getKeyChar()=='-')
				temp = 6 ;
			if(e.getKeyChar()=='�')
				temp = 0 ;
			
			if (!(ctrlM.getLaGrille().construire(abscisse,ordonnee,temp)))
				ctrlM.getLaGrille().reContruire(abscisse,ordonnee,temp) ;
			if(ctrlM.isAideTrouver()||ctrlM.isAideErreur()){
				ctrlM.resolvePossibiliter() ;
				ctrlM.getCtrlVues().refreshGrilleDeJeu() ;
			}
			else{
				ctrlM.getCtrlVues().refreshGrilleDeJeu(abscisse,ordonnee,null);
			}
			
			if(ctrlM.isFinGame()){
//				JOptionPane.showMessageDialog(ctrlM.getCtrlVues().getVuePrincipal(), "BRAAAAAAVOOOOOO");
				ctrlM.getCtrlVues().getVictoire() ;
			}
		}
	}

}
