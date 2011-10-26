import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
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
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;



public class GameFrameMain extends JFrame {

	private JPanel contentPane;

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
	public GameFrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 768);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[196.00][grow]", "[][569.00,grow][grow]"));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.WHITE);
		contentPane.add(rightPanel, "cell 1 1,growx,aligny top");
		rightPanel.setLayout(new MigLayout("", "[780.00]", "[342.00,grow][47.00][148.00,grow]"));
		
		/*
		 * DISPLAY PANEL! 
		 * 
		 * }
		 */
		
		
		JPanel displayPanel = new JPanel();
		displayPanel.setBackground(Color.WHITE);
		rightPanel.add(displayPanel, "cell 0 0,growx,aligny center");
		displayPanel.setLayout(new MigLayout("", "[47.00][][][][][][][][]", "[grow][][][][][][][][][][][]"));
		
		/*
		 * if location == 0{
		 * 	add all of this to display panel
		 * }
		 * else
		 * 	get Conditions and display appropriate picture
		 */
		
		JLabel lblPalletTownGeneral = new JLabel("PALLET TOWN GENERAL STORE");
		lblPalletTownGeneral.setFont(new Font("Tahoma", Font.PLAIN, 16));
		displayPanel.add(lblPalletTownGeneral, "cell 1 0 8 1,alignx center");
		
		JLabel lblYouHave = new JLabel("You have 100 PokeDollars.");
		lblYouHave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblYouHave, "cell 1 2 3 1");
		
		JLabel lblOxen = new JLabel("Oxen");
		lblOxen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblOxen, "cell 1 4,alignx center");
		
		JLabel lblFood = new JLabel("Food");
		lblFood.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblFood, "cell 2 4,alignx center");
		
		JLabel lblClothing = new JLabel("Clothing");
		lblClothing.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblClothing, "cell 3 4,alignx center");
		
		JLabel lblPokeballs = new JLabel("Pokeballs");
		lblPokeballs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblPokeballs, "cell 4 4,alignx center");
		
		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblMedicine, "cell 5 4,alignx center");
		
		JLabel lblWagonAxel = new JLabel("Spare Axel");
		lblWagonAxel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblWagonAxel, "cell 6 4,alignx center");
		
		JLabel lblWagonWheel = new JLabel("Spare Wheel");
		lblWagonWheel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblWagonWheel, "cell 7 4,alignx center");
		
		JLabel lblWagonTongue = new JLabel("Spare Tongue");
		lblWagonTongue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblWagonTongue, "cell 8 4,alignx center");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/taurosItemIcon.png")));
		displayPanel.add(lblNewLabel, "cell 1 5");
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/foodIcon.png")));
		displayPanel.add(label, "cell 2 5");
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/clothingIcon.png")));
		displayPanel.add(label_1, "cell 3 5");
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/ammoIcon.png")));
		displayPanel.add(label_5, "cell 4 5");
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(GameFrameMain.class.getResource("images/potionIcon.png")));
		displayPanel.add(label_6, "cell 5 5");
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/exitgame.png")));
		displayPanel.add(label_7, "cell 6 5");
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/exitgame.png")));
		displayPanel.add(label_8, "cell 7 5");
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/exitgame.png")));
		displayPanel.add(label_9, "cell 8 5");
		
		JLabel lblyoke = new JLabel("$40");
		lblyoke.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblyoke, "cell 1 6,alignx center");
		
		JLabel label_2 = new JLabel("$1");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(label_2, "cell 2 6,alignx center");
		
		JLabel label_10 = new JLabel("$10");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(label_10, "cell 3 6,alignx center");
		
		JLabel lblbox = new JLabel("$2/box");
		lblbox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblbox, "cell 4 6,alignx center");
		
		JLabel label_12 = new JLabel("$15");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(label_12, "cell 5 6,alignx center");
		
		JLabel label_13 = new JLabel("$10");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(label_13, "cell 6 6,alignx center");
		
		JLabel label_14 = new JLabel("$10");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(label_14, "cell 7 6,alignx center");
		
		JLabel label_15 = new JLabel("$10");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(label_15, "cell 8 6,alignx center");
		
		JLabel lblPerYoke = new JLabel("per yoke");
		displayPanel.add(lblPerYoke, "cell 1 7,alignx center");
		
		JLabel lblLbs = new JLabel("5 lbs");
		lblLbs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblLbs, "cell 2 7,alignx center");
		
		JLabel lblLbs_1 = new JLabel("2 lbs");
		lblLbs_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblLbs_1, "cell 3 7,alignx center");
		
		JLabel lblLbs_2 = new JLabel("3 lbs");
		lblLbs_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblLbs_2, "cell 4 7,alignx center");
		
		JLabel lblLbs_3 = new JLabel("2 lbs");
		lblLbs_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblLbs_3, "cell 5 7,alignx center");
		
		JLabel lblLbs_4 = new JLabel("75 lbs");
		lblLbs_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblLbs_4, "cell 6 7,alignx center");
		
		JLabel lblLbs_5 = new JLabel("75 lbs");
		lblLbs_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblLbs_5, "cell 7 7,alignx center");
		
		JLabel lblLbs_6 = new JLabel("100 lbs");
		lblLbs_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblLbs_6, "cell 8 7,alignx center");
		
		JButton button_2 = new JButton("-");
		button_2.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_2, "flowx,cell 1 8,alignx center");
		
		JButton button = new JButton("-");
		button.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button, "flowx,cell 2 8,alignx center");
		
		JLabel label_3 = new JLabel("0");
		label_3.setBackground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(label_3, "cell 2 8,alignx center");
		
		JButton button_1 = new JButton("+");
		button_1.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_1, "cell 2 8,alignx center");
		
		JLabel label_4 = new JLabel("0");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBackground(Color.WHITE);
		displayPanel.add(label_4, "cell 1 8,alignx center");
		
		JButton button_3 = new JButton("+");
		button_3.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_3, "cell 1 8,alignx center");
		
		JButton button_4 = new JButton("-");
		button_4.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_4, "flowx,cell 3 8,alignx center");
		
		JButton button_5 = new JButton("-");
		button_5.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_5, "flowx,cell 4 8,alignx center");
		
		JButton button_6 = new JButton("-");
		button_6.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_6, "flowx,cell 5 8,alignx center");
		
		JButton button_7 = new JButton("-");
		button_7.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_7, "flowx,cell 6 8,alignx center");
		
		JButton button_8 = new JButton("-");
		button_8.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_8, "flowx,cell 7 8,alignx center");
		
		JButton button_9 = new JButton("-");
		button_9.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_9, "flowx,cell 8 8,alignx center");
		
		JLabel lblCurrentWeightLeft = new JLabel("Current Weight Left: 2500 lbs");
		lblCurrentWeightLeft.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblCurrentWeightLeft, "cell 1 10 3 1");
		
		JLabel lblCurrentTotal = new JLabel("Current Total: 70 PokeDollars");
		lblCurrentTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(lblCurrentTotal, "cell 1 11 3 1");
		
		JButton btnBeginAdventure = new JButton("Begin Adventure");
		btnBeginAdventure.setFont(new Font("Tahoma", Font.PLAIN, 13));
		displayPanel.add(btnBeginAdventure, "cell 7 11 2 1,alignx right");
		
		JLabel label_16 = new JLabel("0");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_16.setBackground(Color.WHITE);
		displayPanel.add(label_16, "cell 3 8,alignx center");
		
		JLabel label_17 = new JLabel("0");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_17.setBackground(Color.WHITE);
		displayPanel.add(label_17, "cell 4 8,alignx center");
		
		JLabel label_18 = new JLabel("0");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_18.setBackground(Color.WHITE);
		displayPanel.add(label_18, "cell 5 8,alignx center");
		
		JLabel label_19 = new JLabel("0");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_19.setBackground(Color.WHITE);
		displayPanel.add(label_19, "cell 6 8,alignx center");
		
		JLabel label_20 = new JLabel("0");
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_20.setBackground(Color.WHITE);
		displayPanel.add(label_20, "cell 7 8,alignx center");
		
		JLabel label_21 = new JLabel("0");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_21.setBackground(Color.WHITE);
		displayPanel.add(label_21, "cell 8 8,alignx center");
		
		JButton button_10 = new JButton("+");
		button_10.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_10, "cell 3 8,alignx center");
		
		JButton button_11 = new JButton("+");
		button_11.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_11, "cell 4 8,alignx center");
		
		JButton button_12 = new JButton("+");
		button_12.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_12, "cell 5 8,alignx center");
		
		JButton button_13 = new JButton("+");
		button_13.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_13, "cell 6 8,alignx center");
		
		JButton button_14 = new JButton("+");
		button_14.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_14, "cell 7 8,alignx center");
		
		JButton button_15 = new JButton("+");
		button_15.setMargin(new Insets(2, 2, 2, 2));
		displayPanel.add(button_15, "cell 8 8,alignx center");
		
		
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
		
		JLabel lblConditions = new JLabel("Conditions:");
		lblConditions.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblConditions, "cell 0 6");
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblMoney, "flowx,cell 0 7");
		
		JLabel lblPokedollars = new JLabel("0 Pokedollars");
		lblPokedollars.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblPokedollars, "cell 1 7");
		
		JLabel lblFood_1 = new JLabel("Food:");
		lblFood_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblFood_1, "flowx,cell 0 8");
		
		JLabel lblPlayer = new JLabel("Player1");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblPlayer, "cell 0 12");
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setForeground(new Color(50, 205, 50));
		progressBar_1.setStringPainted(true);
		progressBar_1.setValue(100);
		leftPanel.add(progressBar_1, "cell 1 12");
		
		JLabel lblMember = new JLabel("Member1");
		lblMember.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblMember, "cell 0 13");
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setForeground(new Color(50, 205, 50));
		progressBar_2.setStringPainted(true);
		progressBar_2.setValue(100);
		leftPanel.add(progressBar_2, "cell 1 13");
		
		JLabel lblMember_1 = new JLabel("Member2");
		lblMember_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblMember_1, "cell 0 14");
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setForeground(new Color(50, 205, 50));
		progressBar_3.setStringPainted(true);
		progressBar_3.setValue(100);
		leftPanel.add(progressBar_3, "cell 1 14");
		
		JLabel lblMember_2 = new JLabel("Member3");
		lblMember_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblMember_2, "cell 0 15");
		
		JProgressBar progressBar_4 = new JProgressBar();
		progressBar_4.setForeground(new Color(50, 205, 50));
		progressBar_4.setStringPainted(true);
		progressBar_4.setValue(100);
		leftPanel.add(progressBar_4, "cell 1 15");
		
		JLabel lblMember_3 = new JLabel("Member4");
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
		
		JLabel lblTauros = new JLabel("Tauros1");
		lblTauros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftPanel.add(lblTauros, "cell 0 21");
		
		JProgressBar progressBar_8 = new JProgressBar();
		progressBar_8.setValue(100);
		progressBar_8.setStringPainted(true);
		progressBar_8.setForeground(new Color(50, 205, 50));
		leftPanel.add(progressBar_8, "cell 1 21");
		
		JLabel lblTauros_1 = new JLabel("Tauros2");
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
		
		JButton btnNewButton = new JButton("Exit Game");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setMargin(new Insets(2, 4, 2, 4));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setIcon(new ImageIcon(GameFrameMain.class.getResource("/images/exitgame.png")));
		menuPanel.add(btnNewButton, "cell 0 0,aligny center");
		
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
		
		JMenuItem mntmLeasurely = new JMenuItem("Leasurely");
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
}
