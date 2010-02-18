package vue;

import java.awt.BorderLayout;

import javax.swing.*;

import controleur.ControleurVues;

public class DialogRegles extends JDialog {

	public DialogRegles(JFrame parent){
		//On appelle le construteur de JDialog correspondant
		super(parent, "R�gles", true);
		//On sp�cifie une taille
		this.setSize(400, 500);
		//La position
		this.setLocationRelativeTo(null);
		//La bo�te ne devra pas �tre redimensionnable
		this.setResizable(false);

		this.add(new JLabel("En cours de jeu, le Jeu GRILL se compose d'une grille, elle-m�me compos�e de cases, entour�e par des observateurs.\nChaque case contient un immeuble de �n� �tages. Les immeubles d�une m�me rang�e, ligne ou colonnes, sont tous de tailles diff�rentes. Les informations donn�es sur les bords, c'est � dire par les observateurs, indiquent le nombre d�immeubles visibles sur la rang�e correspondante par un observateur situ� � cet endroit."),BorderLayout.CENTER);
		this.add(new JButton("Retour"),BorderLayout.SOUTH);
		//Enfin on l'affiche
		this.setVisible(true);
	}
}