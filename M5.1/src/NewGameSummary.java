import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

/**
 * WindowBuilder Generated confirmation screen that displays the initial game info.
 * @author Atom Raiff
 *
 */

public class NewGameSummary {
	JFrame frame;
	// fields that are databound to JLabels
	private String PlayerName = M5Main.gameData.Player.getName();
	private String PlayerType = M5Main.gameData.Player.getType();
	private String Pace= M5Main.gameData.Pace;
	private String Rations= M5Main.gameData.Rations;
	private String PartyName0= M5Main.gameData.Party[0].getName();
	private String PartyName1= M5Main.gameData.Party[1].getName();
	private String PartyName2= M5Main.gameData.Party[2].getName();
	private String PartyName3= M5Main.gameData.Party[3].getName();
	private JLabel lblNewLabel_11;
	private JLabel lblrations;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_6;
	private JLabel lblprofession;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGameSummary window = new NewGameSummary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewGameSummary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Confirm Your Choices!");
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Player:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_3 = new JLabel("Profession:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblParty = new JLabel("Party:");
		lblParty.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_4 = new JLabel("Rations:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_5 = new JLabel("Pace:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblNewLabel_6 = new JLabel("$Name");
		
		lblprofession = new JLabel("$Profession");
		
		lblNewLabel_7 = new JLabel("$Party0");
		
		lblNewLabel_8 = new JLabel("$Party1");
		
		lblNewLabel_9 = new JLabel("$Party2");
		
		lblNewLabel_10 = new JLabel("$Party3");
		
		lblrations = new JLabel("$Rations");
		
		lblNewLabel_11 = new JLabel("$Pace");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_11)
								.addComponent(lblrations)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_2)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblParty)
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_8)
										.addComponent(lblNewLabel_7))))
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(40)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblNewLabel_9)
											.addComponent(lblNewLabel_10))
										.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(17)
										.addComponent(lblNewLabel_6)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(lblprofession)))))
					.addGap(198))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(42)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblprofession)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblParty)
						.addComponent(lblNewLabel_9)
						.addComponent(lblNewLabel_7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_10)
						.addComponent(lblNewLabel_8))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblrations))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_11))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		initDataBindings();
	}
	protected void initDataBindings() {
		BeanProperty<JLabel, String> jLabelBeanProperty = BeanProperty.create("text");
		AutoBinding<String, String, JLabel, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ, Rations, lblrations, jLabelBeanProperty, "Rations");
		autoBinding_1.bind();
		//
		AutoBinding<String, String, JLabel, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ, PartyName1, lblNewLabel_8, jLabelBeanProperty, "Party1");
		autoBinding_2.bind();
		//
		AutoBinding<String, String, JLabel, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ, PartyName0, lblNewLabel_7, jLabelBeanProperty, "Party0");
		autoBinding_3.bind();
		//
		AutoBinding<String, String, JLabel, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ, PartyName2, lblNewLabel_9, jLabelBeanProperty, "Party2");
		autoBinding_4.bind();
		//
		AutoBinding<String, String, JLabel, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ, PartyName3, lblNewLabel_10, jLabelBeanProperty, "Party3");
		autoBinding_5.bind();
		//
		AutoBinding<String, String, JLabel, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ, PlayerName, lblNewLabel_6, jLabelBeanProperty, "Name");
		autoBinding_6.bind();
		//
		AutoBinding<String, String, JLabel, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ, PlayerType, lblprofession, jLabelBeanProperty, "Profession");
		autoBinding_7.bind();
		//
		AutoBinding<String, String, JLabel, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, Pace, lblNewLabel_11, jLabelBeanProperty, "Pace");
		autoBinding.bind();
	}
}
