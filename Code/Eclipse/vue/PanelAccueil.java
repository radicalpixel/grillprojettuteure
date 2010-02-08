package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Insets;

public class PanelAccueil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jbNouveau = null;
	private JButton jbCharger = null;
	private JButton jbG�n�rer = null;
	/**
	 * This is the default constructor
	 */
	public PanelAccueil() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 0;
		gridBagConstraints5.ipadx = 10;
		gridBagConstraints5.ipady = 8;
		gridBagConstraints5.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints5.anchor = GridBagConstraints.SOUTH;
		gridBagConstraints5.gridy = 6;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.insets = new Insets(0, 0, 50, 0);
		gridBagConstraints2.ipady = 8;
		gridBagConstraints2.ipadx = 10;
		gridBagConstraints2.gridy = 3;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new Insets(0, 0, 50, 0);
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.ipady = 8;
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		gridBagConstraints.gridy = 0;
		this.setSize(268, 265);
		this.setLayout(new GridBagLayout());
		this.add(getJbNouveau(), gridBagConstraints);
		this.add(getJbCharger(), gridBagConstraints2);
		this.add(getJbG�n�rer(), gridBagConstraints5);
	}

	/**
	 * This method initializes jbNouveau	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbNouveau() {
		if (jbNouveau == null) {
			jbNouveau = new JButton();
			jbNouveau.setText("Nouveau");
		}
		return jbNouveau;
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
	 * This method initializes jbG�n�rer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbG�n�rer() {
		if (jbG�n�rer == null) {
			jbG�n�rer = new JButton();
			jbG�n�rer.setText("G�n�rer");
		}
		return jbG�n�rer;
	}

}  //  @jve:decl-index=0:visual-constraint="10,137"
