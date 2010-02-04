package vue;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class PanelAutoGenerer 
{
	private JPanel jpanel, jpNord, jpSud;
	private JButton jbCommencer, jbRetour;
	private JLabel jlTaille, jlDifficulte;
	private JComboBox jcTaille, jcDifficulte;
	private Vector <String> taille;
	private Vector <String> difficulte;
	
	public PanelAutoGenerer() 
	{
		//Choix des r�ponses
		taille = new Vector<String>();
		taille.add("4");
		taille.add("5");
		taille.add("6");
				
		difficulte = new Vector<String>();
		difficulte.add("Facile");
		difficulte.add("Moyen");
		difficulte.add("Difficile");
	
		
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(2,1));
		
			jpNord = new JPanel();
			jpNord.setLayout(new GridLayout(2,2));
				jlTaille = new JLabel ("Taille  ");
				jcTaille = new JComboBox (taille);
				jcTaille.setEditable(false);
				jpNord.add (jlTaille);
				jpNord.add(jcTaille);
				jlDifficulte = new JLabel ("Difficult�  ");
				jcDifficulte = new JComboBox(difficulte);
				jcDifficulte.setEditable(false);
				jpNord.add(jlDifficulte);
				jpNord.add(jcDifficulte);
				
			jpSud = new JPanel ();
			jpSud.setLayout(new GridLayout(1,3));
				jbCommencer = new JButton ("Commencer");
				jbRetour = new JButton ("Retour");
				jpSud.add(jbCommencer);
				jpSud.add(new JLabel ());
				jpSud.add(jbRetour);
				
		jpanel.add(jpNord);
		jpanel.add(jpSud);

			jlTaille = new JLabel("Taille  ");
			
			jlDifficulte = new JLabel("Difficult�  ");

	}
	
	public JPanel getJpanel() {
		return jpanel;
	}

	public JButton getJbCommencer() {
		return jbCommencer;
	}

	public JButton getJbRetour() {
		return jbRetour;
	}

	public JLabel getJlTaille() {
		return jlTaille;
	}

	public JLabel getJlDifficulte() {
		return jlDifficulte;
	}

	public JComboBox getJcTaille() {
		return jcTaille;
	}

	public JComboBox getJcDifficulte() {
		return jcDifficulte;
	}

	public Vector<String> getTaille() {
		return taille;
	}

	public Vector<String> getDifficulte() {
		return difficulte;
	}
}
