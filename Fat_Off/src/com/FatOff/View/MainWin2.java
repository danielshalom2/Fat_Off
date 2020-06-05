
package com.FatOff.View;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
public class MainWin2 {
	private JTextField CustomerNametxt;
	private JTextField weighttxt;
	private JTextField heighttxt;
	private JTextField agetxt;
	private JTextField wristtxt;
	private JTextField waisttxt;
	private JTextField thightxt;
	private JTextField calculatedBMItxt;
	private JTextField calculatedEERtxt;
	private JTextField txtEnterGeneralSummary;
	private JTextField snack3txt;
	private JTextField snack2txt;
	private JTextField snack1txt;
	private JTextField breakfasttxt;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public MainWin2(Object cus, String type) {
		///declare the frame
		JFrame customerframe = new JFrame("custmer");
		customerframe.getContentPane().setLayout(null);
		customerframe.setBounds(0,22,1081,900);
		
		///creating a panel for the window
		JPanel panel = new JPanel();
		panel.setBounds(0, 22, 1081, 939);
		customerframe.getContentPane().add(panel);
		panel.setBackground((new Color(36,47,65)));
		
		//logo 
		JLabel logoLbl = new JLabel("");
		logoLbl.setBounds(0, 11, 139, 179);
		logoLbl.setIcon(new ImageIcon(MainWin2.class.getResource("/com/FatOff/View/fat_off_white.png")));
		
		//introducing the 
		JLabel custnameLbl = new JLabel("Customer Name :");
		custnameLbl.setBounds(321, 31, 154, 23);
		custnameLbl.setForeground(Color.WHITE);
		custnameLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		CustomerNametxt = new JTextField();
		CustomerNametxt.setBounds(479, 28, 328, 29);
		CustomerNametxt.setForeground(Color.WHITE);
		CustomerNametxt.setHorizontalAlignment(SwingConstants.CENTER);
		CustomerNametxt.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		CustomerNametxt.setText("Here will be the customer name");
		CustomerNametxt.setEditable(false);
		CustomerNametxt.setColumns(10);
		CustomerNametxt.setBackground(null);
	
		JLabel measuresLbl = new JLabel("Measures :");
		measuresLbl.setBounds(10, 228, 80, 21);
		measuresLbl.setForeground(Color.WHITE);
		measuresLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 208, 214, 2);
		
		JLabel weightLbl = new JLabel("Weight :");
		weightLbl.setBounds(10, 267, 89, 23);
		weightLbl.setForeground(Color.WHITE);
		weightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel heightLbl = new JLabel("Height :");
		heightLbl.setBounds(10, 296, 89, 23);
		heightLbl.setForeground(Color.WHITE);
		heightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel ageLbl = new JLabel("Age :");
		ageLbl.setBounds(10, 325, 89, 23);
		ageLbl.setForeground(Color.WHITE);
		ageLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel wristLbl = new JLabel("Wrist :");
		wristLbl.setBounds(10, 354, 89, 23);
		wristLbl.setForeground(Color.WHITE);
		wristLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel waistLbl = new JLabel("Waist :");
		waistLbl.setBounds(10, 383, 89, 23);
		waistLbl.setForeground(Color.WHITE);
		waistLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel thighLbl = new JLabel("Thigh :");
		thighLbl.setBounds(10, 412, 89, 23);
		thighLbl.setForeground(Color.WHITE);
		thighLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		weighttxt = new JTextField();
		weighttxt.setBounds(103, 269, 123, 21);
		weighttxt.setText("Enter Weight");
		weighttxt.setHorizontalAlignment(SwingConstants.CENTER);
		weighttxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		weighttxt.setColumns(10);
		
		heighttxt = new JTextField();
		heighttxt.setBounds(103, 298, 123, 21);
		heighttxt.setText("Height");
		heighttxt.setHorizontalAlignment(SwingConstants.CENTER);
		heighttxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		heighttxt.setEditable(false);
		heighttxt.setColumns(10);
		
		agetxt = new JTextField();
		agetxt.setBounds(103, 327, 123, 21);
		agetxt.setText("Age");
		agetxt.setHorizontalAlignment(SwingConstants.CENTER);
		agetxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		agetxt.setEditable(false);
		agetxt.setColumns(10);
		
		wristtxt = new JTextField();
		wristtxt.setBounds(103, 356, 123, 21);
		wristtxt.setText("Enter Wrist");
		wristtxt.setHorizontalAlignment(SwingConstants.CENTER);
		wristtxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		wristtxt.setColumns(10);
		
		waisttxt = new JTextField();
		waisttxt.setBounds(103, 385, 123, 21);
		waisttxt.setText("Enter Waist");
		waisttxt.setHorizontalAlignment(SwingConstants.CENTER);
		waisttxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		waisttxt.setColumns(10);
		
		thightxt = new JTextField();
		thightxt.setBounds(103, 414, 123, 21);
		thightxt.setText("Enter Thigh");
		thightxt.setHorizontalAlignment(SwingConstants.CENTER);
		thightxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		thightxt.setColumns(10);
		
		JButton clearbtn = new JButton("Clear");
		clearbtn.setBounds(22, 453, 81, 19);
		clearbtn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		clearbtn.setForeground(new Color(255, 255, 255));
		clearbtn.setBorder(null);
		clearbtn.setBackground(new Color(97,212,195));
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
		
		JButton calculatebtn = new JButton("Calculate");
		calculatebtn.setBounds(121, 453, 85, 19);
		calculatebtn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		calculatebtn.setForeground(new Color(255, 255, 255));
		calculatebtn.setBorder(null);
		calculatebtn.setBackground(new Color(97,212,195));
		calculatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 547, 0, 2);
		
		JLabel BMILbl = new JLabel("BMI update :");
		BMILbl.setBounds(10, 608, 107, 23);
		BMILbl.setForeground(Color.WHITE);
		BMILbl.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel EERLbl = new JLabel("EER update :");
		EERLbl.setBounds(10, 649, 107, 23);
		EERLbl.setForeground(Color.WHITE);
		EERLbl.setFont(new Font("Dialog", Font.BOLD, 16));
		
		calculatedBMItxt = new JTextField();
		calculatedBMItxt.setForeground(Color.WHITE);
		calculatedBMItxt.setBounds(135, 610, 149, 21);
		calculatedBMItxt.setEditable(false);
		calculatedBMItxt.setText("Calculated BMI");
		calculatedBMItxt.setHorizontalAlignment(SwingConstants.CENTER);
		calculatedBMItxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		calculatedBMItxt.setBackground(null);
		calculatedBMItxt.setColumns(10);
		
		calculatedEERtxt = new JTextField();
		calculatedEERtxt.setForeground(Color.WHITE);
		calculatedEERtxt.setBounds(135, 651, 149, 21);
		calculatedEERtxt.setEditable(false);
		calculatedEERtxt.setText("Calculated EER");
		calculatedEERtxt.setHorizontalAlignment(SwingConstants.CENTER);
		calculatedEERtxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		calculatedEERtxt.setBackground(null);
		calculatedEERtxt.setColumns(10);

		
		txtEnterGeneralSummary = new JTextField();
		txtEnterGeneralSummary.setBounds(149, 89, 834, 98);
		txtEnterGeneralSummary.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterGeneralSummary.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtEnterGeneralSummary.setText("Enter general summary of the meeting");
		txtEnterGeneralSummary.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 490, 214, 2);
		
		JLabel newMenuLbl = new JLabel("Enter new menu here :");
		newMenuLbl.setBounds(499, 208, 329, 21);
		newMenuLbl.setHorizontalAlignment(SwingConstants.CENTER);
		newMenuLbl.setForeground(Color.WHITE);
		newMenuLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel breakfastLbl = new JLabel("Breakfast :");
		breakfastLbl.setBounds(345, 250, 89, 23);
		breakfastLbl.setForeground(Color.WHITE);
		breakfastLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JLabel lunchLbl = new JLabel("Lunch :");
		lunchLbl.setBounds(345, 412, 89, 23);
		lunchLbl.setForeground(Color.WHITE);
		lunchLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JLabel dinnerLbl = new JLabel("Dinner :");
		dinnerLbl.setBounds(345, 570, 89, 23);
		dinnerLbl.setForeground(Color.WHITE);
		dinnerLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JLabel snack1Lbl = new JLabel("Snack 1 :");
		snack1Lbl.setBounds(374, 383, 89, 23);
		snack1Lbl.setForeground(Color.WHITE);
		snack1Lbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel snackLbl = new JLabel("Snack 2 :");
		snackLbl.setBounds(374, 544, 89, 23);
		snackLbl.setForeground(Color.WHITE);
		snackLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel snack3Lbl = new JLabel("Snack 3 :");
		snack3Lbl.setBounds(374, 713, 89, 23);
		snack3Lbl.setForeground(Color.WHITE);
		snack3Lbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		snack3txt = new JTextField();
		snack3txt.setBounds(467, 714, 589, 21);
		snack3txt.setText("Enter relevant snack");
		snack3txt.setHorizontalAlignment(SwingConstants.CENTER);
		snack3txt.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		snack3txt.setEditable(false);
		snack3txt.setColumns(10);
		
		snack2txt = new JTextField();
		snack2txt.setBounds(467, 545, 589, 21);
		snack2txt.setText("Enter relevant snack");
		snack2txt.setHorizontalAlignment(SwingConstants.CENTER);
		snack2txt.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		snack2txt.setEditable(false);
		snack2txt.setColumns(10);
		
		snack1txt = new JTextField();
		snack1txt.setBounds(467, 384, 589, 21);
		snack1txt.setText("Enter relevant snack");
		snack1txt.setHorizontalAlignment(SwingConstants.CENTER);
		snack1txt.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		snack1txt.setEditable(false);
		snack1txt.setColumns(10);
		panel.setLayout(null);
		panel.add(logoLbl);
		panel.add(txtEnterGeneralSummary);
		panel.add(custnameLbl);
		panel.add(CustomerNametxt);
		panel.add(separator_1);
		panel.add(EERLbl);
		panel.add(calculatedEERtxt);
		panel.add(BMILbl);
		panel.add(calculatedBMItxt);
		panel.add(clearbtn);
		panel.add(calculatebtn);
		panel.add(separator);
		panel.add(separator_2);
		panel.add(measuresLbl);
		panel.add(newMenuLbl);
		panel.add(snackLbl);
		panel.add(waistLbl);
		panel.add(waisttxt);
		panel.add(snack1Lbl);
		panel.add(snack3Lbl);
		panel.add(snack1txt);
		panel.add(snack2txt);
		panel.add(snack3txt);
		panel.add(weightLbl);
		panel.add(weighttxt);
		panel.add(thighLbl);
		panel.add(thightxt);
		panel.add(heightLbl);
		panel.add(heighttxt);
		panel.add(ageLbl);
		panel.add(agetxt);
		panel.add(wristLbl);
		panel.add(wristtxt);
		panel.add(dinnerLbl);
		panel.add(lunchLbl);
		panel.add(breakfastLbl);
		
		breakfasttxt = new JTextField();
		breakfasttxt.setText("Enter");
		breakfasttxt.setHorizontalAlignment(SwingConstants.CENTER);
		breakfasttxt.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		breakfasttxt.setColumns(10);
		breakfasttxt.setBounds(369, 276, 687, 98);
		panel.add(breakfasttxt);
		
		textField_1 = new JTextField();
		textField_1.setText("Enter general summary of the meeting");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(374, 437, 682, 98);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Enter general summary of the meeting");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(374, 604, 682, 98);
		panel.add(textField_2);
		
		JButton clearbtn_1 = new JButton("Clear");
		clearbtn_1.setForeground(Color.WHITE);
		clearbtn_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		clearbtn_1.setBorder(null);
		clearbtn_1.setBackground(new Color(97, 212, 195));
		clearbtn_1.setBounds(331, 766, 154, 46);
		panel.add(clearbtn_1);
		
		JButton savebtn = new JButton("Calculate");
		savebtn.setForeground(Color.WHITE);
		savebtn.setFont(new Font("Century Gothic", Font.BOLD, 16));
		savebtn.setBorder(null);
		savebtn.setBackground(new Color(97, 212, 195));
		savebtn.setBounds(512, 766, 154, 46);
		panel.add(savebtn);
		
		
		/// menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 437, 22);
		customerframe.getContentPane().add(menuBar);
	
		JMenuItem introMeetingLbl = new JMenuItem("Open Introductory Meeting");
		menuBar.add(introMeetingLbl);
		
		
		
	}
}
