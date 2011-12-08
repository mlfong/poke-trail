package org.jamieandtheboys.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InGame window = new InGame();
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
	public InGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 761, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mapPanel = new JPanel();
		frame.getContentPane().add(mapPanel, BorderLayout.CENTER);
		mapPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel mappic = new JLabel("");
		mappic.setIcon(new ImageIcon(InGame.class.getResource("/images/map1.png")));
		mapPanel.add(mappic, BorderLayout.CENTER);
		
		JButton returnbutton = new JButton("Return to game");
		returnbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		mapPanel.add(returnbutton, BorderLayout.SOUTH);
	}

}
