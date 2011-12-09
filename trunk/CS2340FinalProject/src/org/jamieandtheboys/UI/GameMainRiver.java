package org.jamieandtheboys.UI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.Cursor;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;

import org.jamieandtheboys.items.Clothing;
import org.jamieandtheboys.items.Food;
import org.jamieandtheboys.items.FullHeal;
import org.jamieandtheboys.items.Item;
import org.jamieandtheboys.items.Oxen;
import org.jamieandtheboys.items.Pokeball;
import org.jamieandtheboys.items.SpareAxle;
import org.jamieandtheboys.items.SpareTongue;
import org.jamieandtheboys.items.SpareWheel;
import org.jamieandtheboys.persons.Person;
import org.jamieandtheboys.poketrail.GameInitObj;
import org.jamieandtheboys.poketrail.GameLogic;
import org.jamieandtheboys.poketrail.PokeMap;
import org.jamieandtheboys.poketrail.Store;
import org.jamieandtheboys.poketrail.Wagon;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.GridLayout;



public class GameMainRiver extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton_1 = new JButton("Purchase");

	 Store s=GameLogic.store;
	 Wagon w=GameLogic.wagon;
	 Person Party0= GameLogic.party.get(0);
	 Person Party1= GameLogic.party.get(1);
	 Person Party2= GameLogic.party.get(2);
	 Person Party3= GameLogic.party.get(3);
	 Person Party4= GameLogic.party.get(4);
	 Integer oxen=0,clothing=0,pokeballs=0,medicine=0,spareaxle=0,sparewheel=0,sparetongue=0, food=0;
	 String youhave = "You have "+Party0.getMoney()+" Pokedollars";
	 String currentweight = "Current Weight: "+w.getWeight()+" lbs out of "+w.getMaxWeight()+" lbs";
	 private int TotalPrice, TotalWeight=w.getWeight();
	 private JLabel lblPlayer;
	 private JLabel lblMember;
	 private JLabel lblMember_1;
	 private JLabel lblMember_2;
	 private JLabel lblMember_3;
	 private JLabel label_4;
	 private JLabel label_3;
	 private JLabel label_16;
	 private JLabel label_17;
	 private JLabel label_18;
	 private JLabel label_19;
	 private JLabel label_20;
	 private JLabel label_21;
	 private JLabel lblCurrentTotal;
	 private JLabel lblCurrentWeightLeft;
	 private JLabel lblYouHave;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrameMain frame = new GameFrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameMainRiver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 768);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[196.00][grow]", "[][569.00,grow][grow]"));
		
		final JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.WHITE);
		contentPane.add(rightPanel, "cell 1 1,growx,aligny top");
		rightPanel.setLayout(new MigLayout("", "[780.00]", "[342.00,grow][47.00][148.00,grow]"));
		
		/*
		 * DISPLAY PANEL! 
		 * 
		 * }
		 */
		
/*

test
JPanel RiverPanel = new JPanel();
RiverPanel.setBackground(Color.WHITE);
		rightPanel.add(RiverPanel, "cell 0 0,growx,aligny center");
		RiverPanel.setLayout(new MigLayout("", "[][][][][]", "[][][][]"));
		
		JLabel riverImage = new JLabel("");
		riverImage.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/rivercrossing.jpg")));
		RiverPanel.add(riverImage, "cell 2 0 3 1");
		
		JLabel Rivermain = new JLabel("You have found a River! You have three choices");
		RiverPanel.add(Rivermain, "flowx,cell 2 1 3 1");
		
		JLabel ferryexpl = new JLabel("Pay 50 PokeDallars to get across the river safely.");
		RiverPanel.add(ferryexpl, "cell 2 2");
		
		JLabel Fordexpl = new JLabel("Try to pull your wagon across.");
		RiverPanel.add(Fordexpl, "cell 3 2");
		
		JLabel Caulkexpl = new JLabel("Plug up all holes and try to float.");
		RiverPanel.add(Caulkexpl, "cell 4 2");

*/		
		
JPanel RiverPanel = new JPanel();
RiverPanel.setBackground(Color.WHITE);
		rightPanel.add(RiverPanel, "cell 0 0,growx,aligny center");
		RiverPanel.setLayout(new MigLayout("", "[][][][][]", "[][][][]"));
		
		JLabel Rivermain = new JLabel("You have found a River! You have three choices");
		RiverPanel.add(Rivermain, "flowx,cell 1 0");
		
		JLabel ferryexpl = new JLabel("Pay 50 PokeDallars to get across the river safely.");
		RiverPanel.add(ferryexpl, "cell 2 2");
		
		JLabel Fordexpl = new JLabel("Try to pull your wagon across.");
		RiverPanel.add(Fordexpl, "cell 3 2");
		
		JLabel Caulkexpl = new JLabel("Plug up all holes and try to float.");
		RiverPanel.add(Caulkexpl, "cell 4 2");
		
		JButton Ferry = new JButton("Take Ferry");
		Ferry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// if you have enough money
					//subtract money and
					//display notification that you made it across safely and continue Journey
				//else 
					//notify user that he is unable to pay
			}
		});
		RiverPanel.add(Ferry, "cell 2 3");
		
		JButton Ford = new JButton("Ford");
		Ford.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//if river depth <3 feet
					//20% chance it will lose an item or drown a player
				//else
					//caulk chances
				//notify user
			}
		});
		RiverPanel.add(Ford, "cell 3 3");
		
		JButton Caulk = new JButton("Caulk");
		Caulk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//50% chance you will lose an item or drown a player
			}
		});
		RiverPanel.add(Caulk, "cell 4 3,aligny baseline");
		
		
		/*
		 * if location == 0{
		 * 	add all of this to display panel
		 * }
		 * else
		 * 	get Conditions and display appropriate picture
		 */
		
		
		
		JButton button_2 = new JButton("-");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(oxen>0){
					oxen--;
					TotalPrice=TotalPrice-s.getItem("oxen").getCost();
					lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
					label_4.setText(oxen.toString());
					TotalWeight=TotalWeight-s.getItem("oxen").getWeight();	
					lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
					
				}
			}
		});
		button_2.setMargin(new Insets(2, 2, 2, 2));
		
		
		JButton button = new JButton("-");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(food>0){
					food--;
					TotalPrice=TotalPrice-s.getItem("food").getCost();
					lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
					label_3.setText(food.toString());
					TotalWeight=TotalWeight-s.getItem("food").getWeight();	
					lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
				}
			}
		});
		button.setMargin(new Insets(2, 2, 2, 2));
		
		
		label_3 = new JLabel("0");
		label_3.setBackground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		JButton button_1 = new JButton("+");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				food++;
				TotalPrice=TotalPrice+s.getItem("food").getCost();
				lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
				label_3.setText(food.toString());
				TotalWeight=TotalWeight+s.getItem("food").getWeight();	
				lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
			}
		});
		button_1.setMargin(new Insets(2, 2, 2, 2));
		
		
		label_4 = new JLabel("0");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBackground(Color.WHITE);
		
		
		JButton button_3 = new JButton("+");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				oxen++;
				TotalPrice=TotalPrice+s.getItem("oxen").getCost();
				lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
				label_4.setText(oxen.toString());
				TotalWeight=TotalWeight+s.getItem("oxen").getWeight();	
				lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
			}
		});
		button_3.setMargin(new Insets(2, 2, 2, 2));
		
		JButton button_4 = new JButton("-");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(clothing>0){
					clothing--;
					TotalPrice=TotalPrice-s.getItem("clothing").getCost();
					lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
					label_16.setText(clothing.toString());
					TotalWeight=TotalWeight-s.getItem("clothing").getWeight();	
					lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
				}
			}
		});
		button_4.setMargin(new Insets(2, 2, 2, 2));
		
		
		JButton button_5 = new JButton("-");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pokeballs>0){
					pokeballs--;
					TotalPrice=TotalPrice-s.getItem("pokeball").getCost();
					lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
					label_17.setText(pokeballs.toString());
					TotalWeight=TotalWeight-s.getItem("pokeball").getWeight();	
					lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
				}
			}
		});
		button_5.setMargin(new Insets(2, 2, 2, 2));
		
		
		JButton button_6 = new JButton("-");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(medicine>0){
					medicine--;
					TotalPrice=TotalPrice-s.getItem("FullHeal").getCost();
					lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
					label_18.setText(medicine.toString());
					TotalWeight=TotalWeight-s.getItem("FullHeal").getWeight();	
					lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
				}
			}
		});
		button_6.setMargin(new Insets(2, 2, 2, 2));
		
		
		JButton button_7 = new JButton("-");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(spareaxle>0){
					spareaxle--;
					TotalPrice=TotalPrice-s.getItem("spareaxle").getCost();
					lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
					label_19.setText(spareaxle.toString());
					TotalWeight=TotalWeight-s.getItem("spareaxle").getWeight();	
					lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
				}
			}
		});
		button_7.setMargin(new Insets(2, 2, 2, 2));
		
		JButton button_8 = new JButton("-");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(sparewheel>0){
					sparewheel--;
					TotalPrice=TotalPrice-s.getItem("sparewheel").getCost();
					lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
					label_20.setText(sparewheel.toString());
					TotalWeight=TotalWeight-s.getItem("sparewheel").getWeight();	
					lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
				}
			}
		});
		button_8.setMargin(new Insets(2, 2, 2, 2));
		
		
		JButton button_9 = new JButton("-");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(sparetongue>0){
					sparetongue--;
					TotalPrice=TotalPrice-s.getItem("sparetongue").getCost();
					lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
					label_21.setText(sparetongue.toString());
					TotalWeight=TotalWeight-s.getItem("sparetongue").getWeight();	
					lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
				}
			}
		});
		button_9.setMargin(new Insets(2, 2, 2, 2));
		
		
		lblCurrentWeightLeft = new JLabel("Current Weight: ");
		lblCurrentWeightLeft.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		lblCurrentTotal = new JLabel("Current Total: 0 PokeDollars");
		lblCurrentTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Checking out
				if(Party0.getMoney()<TotalPrice){
					JOptionPane.showMessageDialog(contentPane,
						    "You cannot afford this.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else if(TotalWeight>w.getMaxWeight()){
					JOptionPane.showMessageDialog(contentPane,
						    "You're wagon cannot take on this much weight.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else if(TotalPrice==0){
					JOptionPane.showMessageDialog(contentPane,
						    "You didn't purchase anything.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else{
					Party0.subMoney(TotalPrice);
					lblYouHave.setText("You have "+Party0.getMoney()+" Pokedollars");
					w.setWeight(TotalWeight);
					if(oxen>0){
						w.addItem(new Oxen(), oxen);
						oxen=0;
						label_4.setText("0");
					}
					if(food>0){
						w.addItem(new Food(), food);
						food=0;
						label_3.setText("0");
					}
					if(clothing>0){
						w.addItem(new Clothing(), clothing);
						clothing=0;
						label_16.setText("0");
					}
					if(pokeballs>0){
						w.addItem(new Pokeball(), pokeballs);
						pokeballs=0;
						label_17.setText("0");
					}
					if(medicine>0){
						w.addItem(new FullHeal(), medicine);
						medicine=0;
						label_18.setText("0");
					}
					if(spareaxle>0){
						w.addItem(new SpareAxle(), spareaxle);
						spareaxle=0;
						label_19.setText("0");
					}
					if(sparewheel>0){
						w.addItem(new SpareWheel(), sparewheel);
						sparewheel=0;
						label_20.setText("0");
					}
					if(sparetongue>0){
						w.addItem(new SpareTongue(), sparetongue);
						sparetongue=0;
						label_21.setText("0");
					}
					TotalPrice=0;
					lblCurrentWeightLeft.setText("Current Weight: "+w.getWeight()+" lbs out of "+w.getMaxWeight()+" lbs");
					lblCurrentTotal.setText("Current Total: "+TotalPrice+" PokeDollars");
					lblYouHave.setText("You have "+Party0.getMoney()+" PokeDollars");
				}
			}
		});
	
		
		JButton btnBeginAdventure = new JButton("Begin Adventure");
		btnBeginAdventure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					HashMap<Item, Integer> inv= w.getInventory();
					JOptionPane.showMessageDialog(contentPane,
						    "You're inventory consists of: "+inv.toString(),
						    "Inventory",
						    JOptionPane.OK_OPTION);
				
			}
		});
		btnBeginAdventure.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		label_16 = new JLabel("0");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_16.setBackground(Color.WHITE);
		
		
		label_17 = new JLabel("0");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_17.setBackground(Color.WHITE);
		
		
		label_18 = new JLabel("0");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_18.setBackground(Color.WHITE);
	
		
		label_19 = new JLabel("0");
	
		JButton button_11 = new JButton("+");
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pokeballs++;
				TotalPrice=TotalPrice+s.getItem("pokeball").getCost();
				lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
				label_17.setText(pokeballs.toString());
				TotalWeight=TotalWeight+s.getItem("pokeball").getWeight();	
				lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
			}
		});

	
		JButton button_14 = new JButton("+");
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sparewheel++;
				TotalPrice=TotalPrice+s.getItem("sparewheel").getCost();
				lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
				label_20.setText(sparewheel.toString());
				TotalWeight=TotalWeight+s.getItem("sparewheel").getWeight();	
				lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
			}
		});
		button_14.setMargin(new Insets(2, 2, 2, 2));
	
		JButton button_15 = new JButton("+");
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sparetongue++;
				TotalPrice=TotalPrice+s.getItem("sparetongue").getCost();
				lblCurrentTotal.setText("Current Total: "+TotalPrice+" Pokedollars");
				label_21.setText(sparetongue.toString());
				TotalWeight=TotalWeight+s.getItem("sparetongue").getWeight();	
				lblCurrentWeightLeft.setText("Current Weight: "+TotalWeight+" lbs out of "+w.getMaxWeight()+" lbs");
			}
		});
		button_15.setMargin(new Insets(2, 2, 2, 2));
		
		/*
		 * END OF DISPLAY PANEL
		 */
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(new Color(0, 204, 51));
		rightPanel.add(progressBar, "cell 0 1,grow");
		
		TextArea textArea = new TextArea();
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textArea.setText("Welcome to Pallet Town, young adventurer.");
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		rightPanel.add(textArea, "cell 0 2,grow");
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.WHITE);
		contentPane.add(leftPanel, "cell 0 1,grow");
		leftPanel.setLayout(new MigLayout("", "[][119.00]", "[][][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/poketraillogo3.jpg")));
		leftPanel.add(label_11, "cell 0 0 2 1,aligny top");
		
		JLabel lblTravelLog = new JLabel("Travel Log:");
		lblTravelLog.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblTravelLog, "cell 0 2 2 1,alignx center");
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblDay, "flowx,cell 0 4,alignx left");
		
		JLabel label_22 = new JLabel("1");
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(label_22, "cell 1 4");
		
		JLabel lblTraveled = new JLabel("Traveled:");
		lblTraveled.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblTraveled, "cell 0 5");
		
		JLabel lblMiles_1 = new JLabel("0 miles");
		lblMiles_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblMiles_1, "cell 1 5");
		
		JLabel lblConditions = new JLabel("Conditions:");
		lblConditions.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblConditions, "cell 0 6");
		
		JLabel lblFair = new JLabel("Fair");
		lblFair.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblFair, "flowx,cell 1 6");
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblMoney, "flowx,cell 0 7");
		
		JLabel lblPokedollars = new JLabel("0 Pokedollars");
		lblPokedollars.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblPokedollars, "cell 1 7");
		
		JLabel lblFood_1 = new JLabel("Food:");
		lblFood_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblFood_1, "flowx,cell 0 8");
		
		JLabel lblMiles = new JLabel("0 lbs");
		lblMiles.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMiles.setHorizontalAlignment(SwingConstants.TRAILING);
		leftPanel.add(lblMiles, "cell 1 8,alignx leading");
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblHealth, "cell 0 10 2 1,alignx center");
		
		lblPlayer = new JLabel("$Player1");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblPlayer, "cell 0 12");
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setForeground(new Color(50, 205, 50));
		progressBar_1.setStringPainted(true);
		progressBar_1.setValue(100);
		leftPanel.add(progressBar_1, "cell 1 12");
		
		lblMember = new JLabel("$Member1");
		lblMember.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblMember, "cell 0 13");
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setForeground(new Color(50, 205, 50));
		progressBar_2.setStringPainted(true);
		progressBar_2.setValue(100);
		leftPanel.add(progressBar_2, "cell 1 13");
		
		lblMember_1 = new JLabel("$Member2");
		lblMember_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblMember_1, "cell 0 14");
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setForeground(new Color(50, 205, 50));
		progressBar_3.setStringPainted(true);
		progressBar_3.setValue(100);
		leftPanel.add(progressBar_3, "cell 1 14");
		
		lblMember_2 = new JLabel("$Member3");
		lblMember_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblMember_2, "cell 0 15");
		
		JProgressBar progressBar_4 = new JProgressBar();
		progressBar_4.setForeground(new Color(50, 205, 50));
		progressBar_4.setStringPainted(true);
		progressBar_4.setValue(100);
		leftPanel.add(progressBar_4, "cell 1 15");
		
		lblMember_3 = new JLabel("$Member4");
		lblMember_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblMember_3, "cell 0 16");
		
		JProgressBar progressBar_5 = new JProgressBar();
		progressBar_5.setForeground(new Color(50, 205, 50));
		progressBar_5.setStringPainted(true);
		progressBar_5.setValue(100);
		leftPanel.add(progressBar_5, "cell 1 16");
		
		JLabel lblWagon = new JLabel("Wagon:");
		lblWagon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblWagon, "cell 0 18 2 1,alignx center");
		
		JLabel lblWagon_1 = new JLabel("Wagon");
		lblWagon_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblWagon_1, "cell 0 20");
		
		JProgressBar progressBar_7 = new JProgressBar();
		progressBar_7.setValue(100);
		progressBar_7.setStringPainted(true);
		progressBar_7.setForeground(new Color(50, 205, 50));
		leftPanel.add(progressBar_7, "cell 1 20");
		
		JLabel lblTauros = new JLabel("Tauros");
		lblTauros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblTauros, "cell 0 21");
		
		JProgressBar progressBar_8 = new JProgressBar();
		progressBar_8.setValue(100);
		progressBar_8.setStringPainted(true);
		progressBar_8.setForeground(new Color(50, 205, 50));
		leftPanel.add(progressBar_8, "cell 1 21");
		
		JLabel lblTauros_1 = new JLabel("Tauros");
		lblTauros_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblTauros_1, "cell 0 22");
		
		JProgressBar progressBar_6 = new JProgressBar();
		progressBar_6.setValue(100);
		progressBar_6.setStringPainted(true);
		progressBar_6.setForeground(new Color(50, 205, 50));
		leftPanel.add(progressBar_6, "cell 1 22");
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.RED);
		contentPane.add(menuPanel, "cell 0 2 2 1,grow");
		menuPanel.setLayout(new MigLayout("", "[][][][][][][][][][]", "[130.00]"));
		
		JButton btnNewButton1 = new JButton("Exit Game");
		btnNewButton1.setBackground(Color.WHITE);
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton1.setMargin(new Insets(2, 4, 2, 4));
		btnNewButton1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton1.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/exitgame.png")));
		menuPanel.add(btnNewButton1, "cell 0 0,aligny center");
		
		JButton btnS = new JButton("Save Game");
		btnS.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/savegame.png")));
		btnS.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnS.setMargin(new Insets(2, 4, 2, 4));
		btnS.setHorizontalTextPosition(SwingConstants.CENTER);
		btnS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnS.setBackground(Color.WHITE);
		menuPanel.add(btnS, "cell 1 0,aligny center");
		
		JButton btnHunt = new JButton("Heal");
		btnHunt.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/potionIcon.png")));
		btnHunt.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHunt.setMargin(new Insets(2, 6, 2, 5));
		btnHunt.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHunt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHunt.setBackground(Color.WHITE);
		menuPanel.add(btnHunt, "cell 2 0,aligny center");
		
		JPopupMenu popupMenu_2 = new JPopupMenu();
		addPopup(btnHunt, popupMenu_2);
		
		JMenuItem mntmPlayer = new JMenuItem("Player1");
		popupMenu_2.add(mntmPlayer);
		
		JMenuItem mntmMember = new JMenuItem("Member1");
		popupMenu_2.add(mntmMember);
		
		JMenuItem mntmMember_1 = new JMenuItem("Member2");
		popupMenu_2.add(mntmMember_1);
		
		JMenuItem mntmMember_2 = new JMenuItem("Member3");
		popupMenu_2.add(mntmMember_2);
		
		JMenuItem mntmMember_3 = new JMenuItem("Member4");
		popupMenu_2.add(mntmMember_3);
		
		JButton btnHeal = new JButton("Hunt");
		btnHeal.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/ammoIcon.png")));
		btnHeal.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHeal.setMargin(new Insets(2, 6, 2, 5));
		btnHeal.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHeal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHeal.setBackground(Color.WHITE);
		menuPanel.add(btnHeal, "cell 3 0,aligny center");
		
		JButton btnRepairWagon = new JButton("Trade");
		btnRepairWagon.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/exitgame.png")));
		btnRepairWagon.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRepairWagon.setMargin(new Insets(2, 6, 2, 5));
		btnRepairWagon.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRepairWagon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRepairWagon.setBackground(Color.WHITE);
		menuPanel.add(btnRepairWagon, "cell 4 0,aligny center");
		
		JButton btnTrade = new JButton("Repair Wagon");
		btnTrade.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/exitgame.png")));
		btnTrade.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTrade.setMargin(new Insets(2, 6, 2, 5));
		btnTrade.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTrade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTrade.setBackground(Color.WHITE);
		menuPanel.add(btnTrade, "cell 5 0,aligny center");
		
		JPopupMenu popupMenu_3 = new JPopupMenu();
		addPopup(btnTrade, popupMenu_3);
		
		JMenuItem mntmUseSpareWheel = new JMenuItem("Use Spare Wheel");
		popupMenu_3.add(mntmUseSpareWheel);
		
		JMenuItem mntmUseSpareAxel = new JMenuItem("Use Spare Axel");
		popupMenu_3.add(mntmUseSpareAxel);
		
		JMenuItem mntmUseSpareTongue = new JMenuItem("Use Spare Tongue");
		popupMenu_3.add(mntmUseSpareTongue);
		
		JButton btnSetPace = new JButton("Set Pace");
		btnSetPace.setInheritsPopupMenu(true);
		btnSetPace.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/taurosIcon.png")));
		btnSetPace.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSetPace.setMargin(new Insets(2, 6, 2, 5));
		btnSetPace.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSetPace.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSetPace.setBackground(Color.WHITE);
		menuPanel.add(btnSetPace, "cell 6 0,aligny center");
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(btnSetPace, popupMenu);
		
		JMenuItem mntmStopped = new JMenuItem("Stopped");
		popupMenu.add(mntmStopped);
		
		JMenuItem mntmLeasurely = new JMenuItem("Leisurely");
		mntmLeasurely.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/slowpokeIcon.png")));
		popupMenu.add(mntmLeasurely);
		
		JMenuItem mntmSteady = new JMenuItem("Steady");
		mntmSteady.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/taurosIcon.png")));
		popupMenu.add(mntmSteady);
		
		JMenuItem mntmGrueling = new JMenuItem("Grueling");
		mntmGrueling.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/rapidashIcon.png")));
		popupMenu.add(mntmGrueling);
		
		JButton btnSetRations = new JButton("Set Rations");
		btnSetRations.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/foodIcon.png")));
		btnSetRations.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSetRations.setMargin(new Insets(2, 6, 2, 5));
		btnSetRations.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSetRations.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSetRations.setBackground(Color.WHITE);
		menuPanel.add(btnSetRations, "cell 7 0,aligny center");
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(btnSetRations, popupMenu_1);
		
		JMenuItem mntmNone = new JMenuItem("None");
		popupMenu_1.add(mntmNone);
		
		JMenuItem mntmBarebones = new JMenuItem("Bare-Bones");
		popupMenu_1.add(mntmBarebones);
		
		JMenuItem mntmMeager = new JMenuItem("Meager");
		popupMenu_1.add(mntmMeager);
		
		JMenuItem mntmNormal = new JMenuItem("Normal");
		popupMenu_1.add(mntmNormal);
		
		JMenuItem mntmWellfed = new JMenuItem("Well-Fed");
		popupMenu_1.add(mntmWellfed);
		
		JButton btnViewSupplies = new JButton("View Supplies");
		btnViewSupplies.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/clothingIcon.png")));
		btnViewSupplies.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnViewSupplies.setMargin(new Insets(2, 6, 2, 5));
		btnViewSupplies.setHorizontalTextPosition(SwingConstants.CENTER);
		btnViewSupplies.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnViewSupplies.setBackground(Color.WHITE);
		menuPanel.add(btnViewSupplies, "cell 8 0,aligny center");
		
		JButton btnViewMap = new JButton("View Map");
		btnViewMap.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/exitgame.png")));
		btnViewMap.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnViewMap.setMargin(new Insets(2, 6, 2, 5));
		btnViewMap.setHorizontalTextPosition(SwingConstants.CENTER);
		btnViewMap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnViewMap.setBackground(Color.WHITE);
		menuPanel.add(btnViewMap, "cell 9 0,aligny center");
		initDataBindings();
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}

		});
	}
	protected void initDataBindings() {
		BeanProperty<Person, String> personBeanProperty = BeanProperty.create("name");
		BeanProperty<JLabel, String> jLabelBeanProperty = BeanProperty.create("text");
		AutoBinding<Person, String, JLabel, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, Party0, personBeanProperty, lblPlayer, jLabelBeanProperty);
		autoBinding.bind();
		//
		AutoBinding<Person, String, JLabel, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ, Party1, personBeanProperty, lblMember, jLabelBeanProperty);
		autoBinding_1.bind();
		//
		AutoBinding<Person, String, JLabel, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ, Party2, personBeanProperty, lblMember_1, jLabelBeanProperty);
		autoBinding_2.bind();
		//
		AutoBinding<Person, String, JLabel, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ, Party3, personBeanProperty, lblMember_2, jLabelBeanProperty);
		autoBinding_3.bind();
		//
		AutoBinding<Person, String, JLabel, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ, Party4, personBeanProperty, lblMember_3, jLabelBeanProperty);
		autoBinding_4.bind();
		//
		AutoBinding<Integer, Integer, JLabel, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ, oxen, label_4, jLabelBeanProperty);
		autoBinding_5.bind();
		//
		AutoBinding<Integer, Integer, JLabel, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ, food, label_3, jLabelBeanProperty);
		autoBinding_6.bind();
		//
		AutoBinding<Integer, Integer, JLabel, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ, clothing, label_16, jLabelBeanProperty);
		autoBinding_7.bind();
		//
		AutoBinding<Integer, Integer, JLabel, String> autoBinding_8 = Bindings.createAutoBinding(UpdateStrategy.READ, pokeballs, label_17, jLabelBeanProperty);
		autoBinding_8.bind();
		//
		AutoBinding<Integer, Integer, JLabel, String> autoBinding_9 = Bindings.createAutoBinding(UpdateStrategy.READ, medicine, label_18, jLabelBeanProperty);
		autoBinding_9.bind();
		//
		AutoBinding<Integer, Integer, JLabel, String> autoBinding_10 = Bindings.createAutoBinding(UpdateStrategy.READ, spareaxle, label_19, jLabelBeanProperty);
		autoBinding_10.bind();
		//
		AutoBinding<Integer, Integer, JLabel, String> autoBinding_11 = Bindings.createAutoBinding(UpdateStrategy.READ, sparewheel, label_20, jLabelBeanProperty);
		autoBinding_11.bind();
		//
		AutoBinding<Integer, Integer, JLabel, String> autoBinding_12 = Bindings.createAutoBinding(UpdateStrategy.READ, sparetongue, label_21, jLabelBeanProperty);
		autoBinding_12.bind();
		//
		AutoBinding<String, String, JLabel, String> autoBinding_13 = Bindings.createAutoBinding(UpdateStrategy.READ, currentweight, lblCurrentWeightLeft, jLabelBeanProperty);
		autoBinding_13.bind();
		//
		AutoBinding<String, String, JLabel, String> autoBinding_14 = Bindings.createAutoBinding(UpdateStrategy.READ, youhave, lblYouHave, jLabelBeanProperty);
		autoBinding_14.bind();
	}
}
