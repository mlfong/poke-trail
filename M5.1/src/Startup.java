/*
	Hi Boyz...this is my window builder dialog box for m5!
	
*/
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;


public class Startup extends JDialog {
	private JTextField txtAsh;
	private JTextField txtPikachu;
	private JTextField txtPidgioto;
	private JTextField txtButterfree;
	private JTextField txtBulbasaur;
	private JTextField txtSquirtle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Startup dialog = new Startup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Startup() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 550, 400);
		getContentPane().setLayout(new MigLayout("", "[434px,grow]", "[217.00px,grow][42.00px]"));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(new Color(255, 255, 255));
			getContentPane().add(tabbedPane, "cell 0 0,grow");
			{
				JPanel panel = new JPanel();
				panel.setIgnoreRepaint(true);
				panel.setBackground(Color.WHITE);
				panel.setFont(new Font("Tahoma", Font.PLAIN, 13));
				panel.setName("");
				tabbedPane.addTab("1. Create Character", null, panel, "");
				tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
				panel.setLayout(new MigLayout("", "[131.00][grow]", "[][][185.00][28.00]"));
				{
					JLabel lblCharacterName = new JLabel("Character Name:");
					lblCharacterName.setFont(new Font("Tahoma", Font.PLAIN, 13));
					panel.add(lblCharacterName, "cell 0 0,alignx trailing");
				}
				{
					txtAsh = new JTextField();
					txtAsh.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtAsh.setText("Ash");
					panel.add(txtAsh, "cell 1 0,alignx left");
					txtAsh.setColumns(20);
				}
				{
					JLabel lblChooseProfession = new JLabel("Choose Profession:");
					lblChooseProfession.setFont(new Font("Tahoma", Font.PLAIN, 13));
					panel.add(lblChooseProfession, "cell 0 1,alignx trailing");
				}
				{
					JComboBox comboBox = new JComboBox();
					comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"Trainer", "Breeder", "Professor"}));
					panel.add(comboBox, "cell 1 1,alignx left");
				}
				{
					JLabel lblBam = new JLabel("");
					//
					lblBam.setIcon(new ImageIcon(Startup.class.getResource("/images/professionStartUpImage.jpg")));
					panel.add(lblBam, "cell 0 2 2 1,alignx center");
				}
				{
					JLabel lblContinueToCreate = new JLabel("Continue to Step 2");
					lblContinueToCreate.setFont(new Font("Tahoma", Font.PLAIN, 13));
					panel.add(lblContinueToCreate, "cell 1 3,alignx right,aligny bottom");
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 255));
				tabbedPane.addTab("2. Choose Pokemon", null, panel, null);
				panel.setLayout(new MigLayout("", "[130.00][369.00,grow]", "[][][][][][][][][][][][baseline][]"));
				{
					JLabel lblNamePartyMember = new JLabel("Name Party Member:");
					lblNamePartyMember.setFont(new Font("Tahoma", Font.PLAIN, 13));
					panel.add(lblNamePartyMember, "cell 0 0,alignx trailing");
				}
				{
					txtPikachu = new JTextField();
					txtPikachu.setText("Pikachu");
					txtPikachu.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtPikachu.setColumns(20);
					panel.add(txtPikachu, "cell 1 0,alignx left");
				}
				{
					JLabel label = new JLabel("Name Party Member:");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					panel.add(label, "cell 0 2,alignx trailing");
				}
				{
					txtPidgioto = new JTextField();
					txtPidgioto.setText("Pidgioto");
					txtPidgioto.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtPidgioto.setColumns(20);
					panel.add(txtPidgioto, "cell 1 2,alignx left");
				}
				{
					JLabel label = new JLabel("Name Party Member:");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					panel.add(label, "cell 0 4,alignx trailing");
				}
				{
					txtButterfree = new JTextField();
					txtButterfree.setText("Butterfree");
					txtButterfree.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtButterfree.setColumns(20);
					panel.add(txtButterfree, "cell 1 4,alignx left");
				}
				{
					JLabel label = new JLabel("Name Party Member:");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					panel.add(label, "cell 0 6,alignx trailing");
				}
				{
					txtBulbasaur = new JTextField();
					txtBulbasaur.setText("Bulbasaur");
					txtBulbasaur.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtBulbasaur.setColumns(20);
					panel.add(txtBulbasaur, "cell 1 6,alignx left");
				}
				{
					JLabel label = new JLabel("Name Party Member:");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					panel.add(label, "cell 0 8,alignx trailing");
				}
				{
					txtSquirtle = new JTextField();
					txtSquirtle.setText("Squirtle");
					txtSquirtle.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtSquirtle.setColumns(20);
					panel.add(txtSquirtle, "cell 1 8,alignx left");
				}
				{
					JLabel lblContinueToStep = new JLabel("Continue to Step 3");
					lblContinueToStep.setFont(new Font("Tahoma", Font.PLAIN, 13));
					panel.add(lblContinueToStep, "cell 1 12,alignx right");
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 255));
				tabbedPane.addTab("3. Set Pace and Rations", null, panel, null);
				panel.setLayout(new MigLayout("", "[132.00][126.00,grow]","[][][][][][][][][][]"));
				{
					   JLabel lblSetPace = new JLabel("Set Pace:");
					   lblSetPace.setFont(new Font("Tahoma", Font.PLAIN, 13));
					   panel.add(lblSetPace, "cell 0 0,alignx trailing");
				}
				{
					   JComboBox comboBox = new JComboBox();
					   comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
					   comboBox.setModel(new DefaultComboBoxModel(new String[]{"Leasurely", "Steady", "Grueling"}));
					   panel.add(comboBox, "cell 1 0,alignx left");
				}
				{
					   JLabel label = new JLabel("");
					   label.setIcon(new ImageIcon(Startup.class.getResource("/images/paceStartUpImage.jpg")));
					   panel.add(label, "cell 0 1 2 6");
				}
				{
					   JLabel lblSetRations = new JLabel("Set Rations:");
					   lblSetRations.setFont(new Font("Tahoma", Font.PLAIN, 13));
					   panel.add(lblSetRations, "cell 0 7,alignx trailing");
				}
				{
					   JComboBox comboBox = new JComboBox();
					   comboBox.setToolTipText("The more you ration, the healthier your group will be.");
					   comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
					   comboBox.setModel(new DefaultComboBoxModel(new String[]{"Bare-Bones", "Meager", "Normal", "Well-Fed"}));
					   panel.add(comboBox, "flowx,cell 1 7,alignx left");
				}
				{
					   JLabel lblPressOkTo = new JLabel("Press OK to begin.");
					   lblPressOkTo.setToolTipText("");
					   lblPressOkTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
					   panel.add(lblPressOkTo, "cell 1 9,alignx right,aligny bottom");
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.RED);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, "cell 0 1,growx,aligny bottom");
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
