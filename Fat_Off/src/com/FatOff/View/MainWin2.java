
package com.FatOff.View;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.FatOff.Model.Customer;
import com.FatOff.Model.Nutritionist;
import java.awt.Frame;
import java.awt.Rectangle;
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
	
	public MainWin2(Customer cust, Nutritionist nut) {
		///declare the frame
		JFrame customerframe = new JFrame("custmer");
		customerframe.setBounds(new Rectangle(100, 23, 200, 500));
		customerframe.setFocusCycleRoot(false);
		customerframe.setFocusTraversalKeysEnabled(false);
		customerframe.setFocusable(false);
		customerframe.setFocusableWindowState(false);
		customerframe.setAutoRequestFocus(false);
		customerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//customerframe.setAlwaysOnTop(true);
		//customerframe.setBounds(0,22,1081,932);
		
		///creating a panel for the window
		JPanel panel = new JPanel();
		panel.setBackground((new Color(36,47,65)));
		
		//logo 
		JLabel logoLbl = new JLabel("");
		logoLbl.setIcon(new ImageIcon(MainWin2.class.getResource("/com/FatOff/View/fat_off_white.png")));
		
		//introducing the 
		JLabel custnameLbl = new JLabel("Customer Name :");
		custnameLbl.setForeground(Color.WHITE);
		custnameLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		CustomerNametxt = new JTextField();
		CustomerNametxt.setForeground(Color.WHITE);
		CustomerNametxt.setHorizontalAlignment(SwingConstants.CENTER);
		CustomerNametxt.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		CustomerNametxt.setText("Here will be the customer name");
		CustomerNametxt.setEditable(false);
		CustomerNametxt.setColumns(10);
		CustomerNametxt.setBackground(null);
	
		JLabel measuresLbl = new JLabel("Measures :");
		measuresLbl.setForeground(Color.WHITE);
		measuresLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		JLabel weightLbl = new JLabel("Weight :");
		weightLbl.setForeground(Color.WHITE);
		weightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel heightLbl = new JLabel("Height :");
		heightLbl.setForeground(Color.WHITE);
		heightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel ageLbl = new JLabel("Age :");
		ageLbl.setForeground(Color.WHITE);
		ageLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel wristLbl = new JLabel("Wrist :");
		wristLbl.setForeground(Color.WHITE);
		wristLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel waistLbl = new JLabel("Waist :");
		waistLbl.setForeground(Color.WHITE);
		waistLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel thighLbl = new JLabel("Thigh :");
		thighLbl.setForeground(Color.WHITE);
		thighLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		weighttxt = new JTextField();
		weighttxt.setText("Enter Weight");
		weighttxt.setHorizontalAlignment(SwingConstants.CENTER);
		weighttxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		weighttxt.setColumns(10);
		
		heighttxt = new JTextField();
		heighttxt.setText("Height");
		heighttxt.setHorizontalAlignment(SwingConstants.CENTER);
		heighttxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		heighttxt.setEditable(false);
		heighttxt.setColumns(10);
		
		agetxt = new JTextField();
		agetxt.setText("Age");
		agetxt.setHorizontalAlignment(SwingConstants.CENTER);
		agetxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		agetxt.setEditable(false);
		agetxt.setColumns(10);
		
		wristtxt = new JTextField();
		wristtxt.setText("Enter Wrist");
		wristtxt.setHorizontalAlignment(SwingConstants.CENTER);
		wristtxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		wristtxt.setColumns(10);
		
		waisttxt = new JTextField();
		waisttxt.setText("Enter Waist");
		waisttxt.setHorizontalAlignment(SwingConstants.CENTER);
		waisttxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		waisttxt.setColumns(10);
		
		thightxt = new JTextField();
		thightxt.setText("Enter Thigh");
		thightxt.setHorizontalAlignment(SwingConstants.CENTER);
		thightxt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		thightxt.setColumns(10);
		
		JButton clearbtn = new JButton("Clear");
		clearbtn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		clearbtn.setForeground(new Color(255, 255, 255));
		clearbtn.setBorder(null);
		clearbtn.setBackground(new Color(97,212,195));
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
		
		JButton calculatebtn = new JButton("Calculate");
		calculatebtn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		calculatebtn.setForeground(new Color(255, 255, 255));
		calculatebtn.setBorder(null);
		calculatebtn.setBackground(new Color(97,212,195));
		calculatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel BMILbl = new JLabel("BMI update :");
		BMILbl.setForeground(Color.WHITE);
		BMILbl.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel EERLbl = new JLabel("EER update :");
		EERLbl.setForeground(Color.WHITE);
		EERLbl.setFont(new Font("Dialog", Font.BOLD, 16));
		
		calculatedBMItxt = new JTextField();
		calculatedBMItxt.setForeground(Color.WHITE);
		calculatedBMItxt.setEditable(false);
		calculatedBMItxt.setText("Calculated BMI");
		calculatedBMItxt.setHorizontalAlignment(SwingConstants.CENTER);
		calculatedBMItxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		calculatedBMItxt.setBackground(null);
		calculatedBMItxt.setColumns(10);
		
		calculatedEERtxt = new JTextField();
		calculatedEERtxt.setForeground(Color.WHITE);
		calculatedEERtxt.setEditable(false);
		calculatedEERtxt.setText("Calculated EER");
		calculatedEERtxt.setHorizontalAlignment(SwingConstants.CENTER);
		calculatedEERtxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		calculatedEERtxt.setBackground(null);
		calculatedEERtxt.setColumns(10);

		
		txtEnterGeneralSummary = new JTextField();
		txtEnterGeneralSummary.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterGeneralSummary.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtEnterGeneralSummary.setText("Enter general summary of the meeting");
		txtEnterGeneralSummary.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel newMenuLbl = new JLabel("Enter new menu here :");
		newMenuLbl.setHorizontalAlignment(SwingConstants.CENTER);
		newMenuLbl.setForeground(Color.WHITE);
		newMenuLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel breakfastLbl = new JLabel("Breakfast :");
		breakfastLbl.setForeground(Color.WHITE);
		breakfastLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JLabel lunchLbl = new JLabel("Lunch :");
		lunchLbl.setForeground(Color.WHITE);
		lunchLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JLabel dinnerLbl = new JLabel("Dinner :");
		dinnerLbl.setForeground(Color.WHITE);
		dinnerLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JLabel snack1Lbl = new JLabel("Snack 1 :");
		snack1Lbl.setForeground(Color.WHITE);
		snack1Lbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel snackLbl = new JLabel("Snack 2 :");
		snackLbl.setForeground(Color.WHITE);
		snackLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel snack3Lbl = new JLabel("Snack 3 :");
		snack3Lbl.setForeground(Color.WHITE);
		snack3Lbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		snack3txt = new JTextField();
		snack3txt.setText("Enter relevant snack");
		snack3txt.setHorizontalAlignment(SwingConstants.CENTER);
		snack3txt.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		snack3txt.setEditable(false);
		snack3txt.setColumns(10);
		
		snack2txt = new JTextField();
		snack2txt.setText("Enter relevant snack");
		snack2txt.setHorizontalAlignment(SwingConstants.CENTER);
		snack2txt.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		snack2txt.setEditable(false);
		snack2txt.setColumns(10);
		
		snack1txt = new JTextField();
		snack1txt.setText("Enter relevant snack");
		snack1txt.setHorizontalAlignment(SwingConstants.CENTER);
		snack1txt.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		snack1txt.setEditable(false);
		snack1txt.setColumns(10);
		
		breakfasttxt = new JTextField();
		breakfasttxt.setText("Enter");
		breakfasttxt.setHorizontalAlignment(SwingConstants.CENTER);
		breakfasttxt.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		breakfasttxt.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("Enter general summary of the meeting");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("Enter general summary of the meeting");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_2.setColumns(10);
		
		JButton clearbtn_1 = new JButton("Clear");
		clearbtn_1.setForeground(Color.WHITE);
		clearbtn_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		clearbtn_1.setBorder(null);
		clearbtn_1.setBackground(new Color(97, 212, 195));
		
		JButton savebtn = new JButton("Calculate");
		savebtn.setForeground(Color.WHITE);
		savebtn.setFont(new Font("Century Gothic", Font.BOLD, 16));
		savebtn.setBorder(null);
		savebtn.setBackground(new Color(97, 212, 195));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(logoLbl, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(95)
									.addComponent(custnameLbl, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(CustomerNametxt, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(txtEnterGeneralSummary, GroupLayout.PREFERRED_SIZE, 834, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(waistLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(waisttxt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(148)
							.addComponent(snack1Lbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(snack1txt, GroupLayout.PREFERRED_SIZE, 589, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(thighLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(thightxt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(119)
							.addComponent(lunchLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(12)
									.addComponent(clearbtn, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(calculatebtn, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
							.addGap(150)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(374)
							.addComponent(snackLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(snack2txt, GroupLayout.PREFERRED_SIZE, 589, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(345)
							.addComponent(dinnerLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(BMILbl, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addComponent(EERLbl, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(calculatedBMItxt, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(calculatedEERtxt, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
							.addGap(90)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(374)
							.addComponent(snack3Lbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(snack3txt, GroupLayout.PREFERRED_SIZE, 589, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(331)
							.addComponent(clearbtn_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(savebtn, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(separator, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(6)
											.addComponent(measuresLbl, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
									.addGap(285)
									.addComponent(newMenuLbl, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(weightLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(heightLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addComponent(wristLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
												.addComponent(ageLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(weighttxt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
										.addComponent(heighttxt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(agetxt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(wristtxt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
									.addGap(115)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(breakfastLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(24)
											.addComponent(breakfasttxt, GroupLayout.PREFERRED_SIZE, 687, GroupLayout.PREFERRED_SIZE)))))))
					.addGap(25))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(logoLbl)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(custnameLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(CustomerNametxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtEnterGeneralSummary, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(measuresLbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(newMenuLbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(breakfastLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(breakfasttxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(weightLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(weighttxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(heightLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(heighttxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(agetxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(ageLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(wristtxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(wristLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(12)))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(waistLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(waisttxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(snack1Lbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(snack1txt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(thighLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(thightxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(lunchLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(clearbtn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(calculatebtn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE))
						.addComponent(snackLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(snack2txt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(3)
					.addComponent(dinnerLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(BMILbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(EERLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(calculatedBMItxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(calculatedEERtxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(snack3Lbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(snack3txt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(clearbtn_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(savebtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
		
		/// menu bar
		JMenuBar menuBar = new JMenuBar();
	
		JMenuItem introMeetingLbl = new JMenuItem("Open Introductory Meeting");
		menuBar.add(introMeetingLbl);
		GroupLayout groupLayout = new GroupLayout(customerframe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1081, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE))
		);
		customerframe.getContentPane().setLayout(groupLayout);
		
		
	}
}
