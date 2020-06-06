/**
 * 
 */
package com.FatOff.View;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;


/**
 * This class represents the main program window
 * @author FatOff Development Team
 * @version 1.0
 */
public class MainWin {
	private JTextArea diatitionNameArea;
	private JTextArea custNameArea;
	private JTextArea dateArea;
	private JTextArea sessionArea;
	
	public MainWin() {
		
		JFrame mainFrame = new JFrame("Fat Off");
		mainFrame.setSize(1707, 954);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setExtendedState(mainFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		mainFrame.addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentResized(ComponentEvent event) {
	            Dimension d = mainFrame.getContentPane().getSize();
	            // code to save frame size or calculate internal frame sizes
	            mainFrame.validate();
	        }
	    });
		
		
		/**
		 * Top Details Panel ---  Session information and sign in
		 */
		JPanel topDetailsPanel = new JPanel();
		topDetailsPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		topDetailsPanel.setBounds(125, 6, 1526, 58);
		topDetailsPanel.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(20, 35, 113, 16);
		lblCustomerName.setVisible(true);
		topDetailsPanel.add(lblCustomerName);
		
		JLabel lblDietitianName = new JLabel("Dietician Name:");
		lblDietitianName.setBounds(20, 6, 104, 16);
		topDetailsPanel.add(lblDietitianName);
		
		diatitionNameArea = new JTextArea();
		diatitionNameArea.setEditable(false);
		diatitionNameArea.setBounds(136, 1, 130, 21);
		topDetailsPanel.add(diatitionNameArea);
		diatitionNameArea.setColumns(10);
		
		custNameArea = new JTextArea();
		custNameArea.setEditable(false);
		custNameArea.setBounds(136, 30, 130, 21);
		topDetailsPanel.add(custNameArea);
		custNameArea.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(353, 6, 61, 16);
		topDetailsPanel.add(lblDate);
		
		JLabel lblSession = new JLabel("Session:");
		lblSession.setBounds(353, 35, 61, 16);
		topDetailsPanel.add(lblSession);
		
		dateArea = new JTextArea();
		dateArea.setEditable(false);
		dateArea.setBounds(426, 1, 130, 21);
		topDetailsPanel.add(dateArea);
		dateArea.setColumns(10);
		
		sessionArea = new JTextArea();
		sessionArea.setEditable(false);
		sessionArea.setBounds(426, 30, 130, 21);
		topDetailsPanel.add(sessionArea);
		sessionArea.setColumns(10);
		
		JLabel lblBmi = new JLabel("BMI :");
		lblBmi.setBounds(647, 6, 54, 45);
		topDetailsPanel.add(lblBmi);
		
		JLabel lblEer = new JLabel("EER :");
		lblEer.setBounds(915, 6, 47, 45);
		topDetailsPanel.add(lblEer);
		
		JTextPane bmiArea = new JTextPane();
		bmiArea.setEditable(false);
		bmiArea.setBounds(683, 16, 77, 21);
		topDetailsPanel.add(bmiArea);
		
		JTextPane eerArea = new JTextPane();
		eerArea.setEditable(false);
		eerArea.setBounds(952, 16, 77, 21);
		topDetailsPanel.add(eerArea);
		
		JButton signInBtn = new JButton("Sign In");
		signInBtn.setBounds(1426, 16, 77, 26);
		topDetailsPanel.add(signInBtn);
		
		mainFrame.getContentPane().add(topDetailsPanel);
		
		
		/**
		 * Logo Panel
		 */
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(new Color(211, 211, 211));
		layeredPane.setBackground(new Color(211, 211, 211));
		layeredPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		layeredPane.setBounds(6, 0, 120, 194);
		layeredPane.setLayout(null);
		layeredPane.setOpaque(true);
		mainFrame.getContentPane().add(layeredPane);
		
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(14, 6, 100, 182);
		layeredPane.add(logoLabel);
		logoLabel.setIcon(new ImageIcon(MainWin.class.getResource("/com/FatOff/View/imgonline-com-ua-resize-5aRADIEx30404X17.png")));
		
		
		/**
		 * Top Menu Panel ---  Open customer / Create customer 
		 */
		JPanel topMenuPanel = new JPanel();
		topMenuPanel.setForeground(Color.GRAY);
		topMenuPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		topMenuPanel.setBounds(125, 65, 1526, 66);
		mainFrame.getContentPane().add(topMenuPanel);
		topMenuPanel.setLayout(null);
		
		
		/**
		 * Right panel with info and select
		 */
		JPanel rightInfoSelectPanel = new JPanel();
		rightInfoSelectPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		rightInfoSelectPanel.setBounds(6, 130, 730, 735);
		mainFrame.getContentPane().add(rightInfoSelectPanel);
		rightInfoSelectPanel.setLayout(null);
		
		
		/**
		 * Left panel with Recommended menu table
		 */
		JPanel sessionMenuSummPanel = new JPanel();
		sessionMenuSummPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		sessionMenuSummPanel.setBounds(739, 130, 912, 735);
		mainFrame.getContentPane().add(sessionMenuSummPanel);
		sessionMenuSummPanel.setLayout(null);
		
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);



		
		
	}

}
