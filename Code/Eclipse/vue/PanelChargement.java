package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;

import controleur.ControleurR;
import controleur.ControleurVues;

public class PanelChargement extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jbCharger = null;
	private JButton jbRetour = null;
	private JPanel jpSud = null;
	private JLabel jLvide = null;
	private JScrollPane jsList = null;
	private JList jlPartieCharger = null;
	private JPanel jpGrilleJeu = null;  //  @jve:decl-index=0:visual-constraint="537,58"
	private ControleurVues ctrlV;

	/**
	 * This is the default constructor
	 */
	public PanelChargement() {
		super();
		initialize();
	}
	
	public PanelChargement(ControleurVues pCtrlV) {
		super();
		this.ctrlV = pCtrlV;
		initialize();
	}


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(361, 353);
		this.setLayout(new BorderLayout());
		this.add(getJsList(), BorderLayout.WEST);
		this.add(getJpSud(), BorderLayout.SOUTH);
		this.add(getJpGrilleJeu(), BorderLayout.EAST);
	}

	/**
	 * This method initializes jbCharger	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbCharger() {
		if (jbCharger == null) {
			jbCharger = new JButton();
			jbCharger.setText("Charger");
		}
		return jbCharger;
	}

	/**
	 * This method initializes jbRetour	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbRetour() {
		if (jbRetour == null) {
			jbRetour = new JButton();
			jbRetour.setText("Retour");
		}
		return jbRetour;
	}

	/**
	 * This method initializes jpSud	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpSud() {
		if (jpSud == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			jpSud = new JPanel();
			jpSud.setLayout(gridLayout);
			jpSud.add(getJLvide(), null);
			jpSud.add(getJbCharger(), null);
			jpSud.add(getJbRetour(), null);
		}
		return jpSud;
	}

	/**
	 * This method initializes jLvide	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLvide() {
		if (jLvide == null) {
			jLvide = new JLabel();
			jLvide.setText("     ");
		}
		return jLvide;
	}

	/**
	 * This method initializes jsList	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJsList() {
		if (jsList == null) {
			jsList = new JScrollPane();
			jsList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jsList.setViewportView(getJlPartieCharger());
			jsList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		}
		return jsList;
	}

	/**
	 * This method initializes jlPartieCharger	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJlPartieCharger() {
		if (jlPartieCharger == null) {
			jlPartieCharger = new JList();
		}
		return jlPartieCharger;
	}

	/**
	 * This method initializes jpGrilleJeu	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpGrilleJeu() {
		if (jpGrilleJeu == null) {
			jpGrilleJeu = new JPanel();
			jpGrilleJeu.setLayout(new GridBagLayout());
			jpGrilleJeu.setSize(new Dimension(227, 189));
		}
		ctrlV.getCtrlM().commencerPartie(4,1) ;
		jpGrilleJeu.add(ctrlV.getPanelGrilleDeJeu());
		return jpGrilleJeu;
	}

}  //  @jve:decl-index=0:visual-constraint="33,17"