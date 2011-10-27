import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;


public class WagonDisplay extends JPanel {

	/**
	 * Create the panel.
	 */
	public WagonDisplay() {
		setLayout(new MigLayout("", "[780px]", "[307px][23px]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WagonDisplay.class.getResource("/images/wagongamescreen3.jpg")));
		add(lblNewLabel, "cell 0 0");
		
		JButton btnContinue = new JButton("Continue");
		add(btnContinue, "cell 0 1,alignx right,aligny top");

	}

}
