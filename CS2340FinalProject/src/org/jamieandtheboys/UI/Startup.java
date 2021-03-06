package org.jamieandtheboys.UI;

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

import org.jamieandtheboys.persons.Breeder;
import org.jamieandtheboys.persons.Person;
import org.jamieandtheboys.persons.Professor;
import org.jamieandtheboys.persons.Trainer;
import org.jamieandtheboys.poketrail.GameLogic;
import org.jamieandtheboys.poketrail.Wagon;

import java.awt.Color;
import java.awt.SystemColor;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.ObjectProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * WidowBuilder Generated class. This provides a way for the user to 
 * customize the game upon starting one.
 * See how this data is submitted by viewing the okButton mouse release event.
 * @author Atom Raiff
 *
 */

public class Startup extends JDialog
{
	private JTextField txtAsh;
	private JTextField txtPikachu;
	private JTextField txtPidgeotto;
	private JTextField txtButterfree;
	private JTextField txtBulbasaur;
	public Person player, party0,party1,party2,party3;
	public String pace, rations;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
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
		player = new Trainer("Ash");
		party0 = new Trainer("Pikachu");
		party1 = new Trainer("Pidgeotto");
		party2 = new Trainer("Buterfree");
		party3 = new Trainer("Bulbasaur");
		pace = "Leisurely";
		rations = "Bare-Bones";	
		final JDialog jdia = this;
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
					comboBox_1 = new JComboBox();
					comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Trainer", "Breeder", "Professor"}));
					panel.add(comboBox_1, "cell 1 1,alignx left");
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
					txtPidgeotto = new JTextField();
					txtPidgeotto.setText("Pidgeotto");
					txtPidgeotto.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtPidgeotto.setColumns(20);
					panel.add(txtPidgeotto, "cell 1 2,alignx left");
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
					   comboBox_2 = new JComboBox();
					   comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
					   comboBox_2.setModel(new DefaultComboBoxModel(new String[]{"Leisurely", "Steady", "Grueling"}));
					   panel.add(comboBox_2, "cell 1 0,alignx left");
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
					   comboBox = new JComboBox();
					   comboBox.setToolTipText("The more you ration, the healthier your group will be.");
					   comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
					   comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bare-Bones", "Meager", "Normal", "Well-Fed"}));
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
				okButton.addMouseListener(new MouseAdapter() {
					/**
					 * This stores all the data from the GUI into the gameData obj and 
					 * sends the user to a confirmation screen.
					 */
					@Override
					public void mouseReleased(MouseEvent arg0) {
						//Package game data and send to summary window
						//need to parse names?
						party0.setName(txtPikachu.getText());
						party1.setName(txtPidgeotto.getText());
						party2.setName(txtButterfree.getText());
						party3.setName(txtBulbasaur.getText());
						pace = (String) comboBox_2.getSelectedItem();
						rations=(String) comboBox.getSelectedItem();
						player.setName(txtAsh.getText());
						player.setType((String) comboBox_1.getSelectedItem());
						if(pace.equals("Leisurely"))
							GameLogic.gameData.Pace = 3;
						if(pace.equals("Steady"))
							GameLogic.gameData.Pace = 5;
						if(pace.equals("Grueling"))
							GameLogic.gameData.Pace = 7;
						GameLogic.gameData.PaceString=pace;
						if(rations.equals("Bare-Bones"))
							GameLogic.gameData.Rations = 5;
						if(rations.equals("Meager"))
							GameLogic.gameData.Rations = 10;
						if(rations.equals("Normal"))
							GameLogic.gameData.Rations = 15;
						if(rations.equals("Well-Fed"))
							GameLogic.gameData.Rations = 20;
						GameLogic.gameData.RationsString=rations;
						if(player.getType().equals("Breeder"))
							player = new Breeder(player.getName());
						else if(player.getType().equals("Trainer"))
							player = new Trainer(player.getName());
						else 
							player = new Professor(player.getName());
						GameLogic.wagon = new Wagon();
						GameLogic.gameData.Party.add(player);
						GameLogic.gameData.Party.add(party0);
						GameLogic.gameData.Party.add(party1);
						GameLogic.gameData.Party.add(party2);
						GameLogic.gameData.Party.add(party3);
						GameLogic.gameData.Day = 0;
						jdia.setVisible(false);
						try {
							NewGameSummary window = new NewGameSummary();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		initDataBindings();
	}
	protected void initDataBindings() {
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		BeanProperty<Person, String> personBeanProperty = BeanProperty.create("name");
		AutoBinding<JTextField, String, Person, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, txtAsh, jTextFieldBeanProperty, player, personBeanProperty, "PName");
		autoBinding.bind();
		//
		BeanProperty<JComboBox, Integer> jComboBoxBeanProperty = BeanProperty.create("selectedIndex");
		BeanProperty<Person, String> personBeanProperty_1 = BeanProperty.create("type");
		AutoBinding<JComboBox, Integer, Person, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ, comboBox_1, jComboBoxBeanProperty, player, personBeanProperty_1, "PType");
		autoBinding_1.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<JTextField, String, Person, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ, txtPikachu, jTextFieldBeanProperty_1, party0, personBeanProperty, "P0");
		autoBinding_2.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		AutoBinding<JTextField, String, Person, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ, txtPidgeotto, jTextFieldBeanProperty_2, party1, personBeanProperty, "P1");
		autoBinding_3.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty.create("text");
		AutoBinding<JTextField, String, Person, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ, txtButterfree, jTextFieldBeanProperty_3, party2, personBeanProperty, "P2");
		autoBinding_4.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty.create("text");
		AutoBinding<JTextField, String, Person, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ, txtBulbasaur, jTextFieldBeanProperty_4, party3, personBeanProperty, "P3");
		autoBinding_5.bind();
		//
		ObjectProperty<String> stringObjectProperty = ObjectProperty.create();
		AutoBinding<JComboBox, Integer, String, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ, comboBox_2, jComboBoxBeanProperty, pace, stringObjectProperty, "Pace");
		autoBinding_6.bind();
		//
		AutoBinding<JComboBox, Integer, String, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ, comboBox, jComboBoxBeanProperty, rations, stringObjectProperty, "Rations");
		autoBinding_7.bind();
	}
}
