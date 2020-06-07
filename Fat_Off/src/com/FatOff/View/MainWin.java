
package com.FatOff.View;

import javax.swing.*;

import com.FatOff.Controller.CustomerController;
import com.FatOff.Model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import java.awt.ComponentOrientation;

public class MainWin {
	private JTextField customerNameField;
	private JTextField wightTField;
	private JTextField heightTField;
	private JTextField wristTField;
	private JTextField ageTFIeld;
	private JTextField weistTField;
	private JTextField thighTField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField bmiTField;
	private JTextField textField_3;

	public MainWin(Nutritionist nut, Customer cust , String activity) {
		
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/////////////////////////////// set icon //////////////////////////////////
		ImageIcon icon = new ImageIcon("src/com/FatOff/View/IconFatOff.PNG");
		mainFrame.setIconImage(icon.getImage());
		//////////////////////////////////////////////////////////////////////////
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground((new Color(36,47,65)));
		GroupLayout groupLayout = new GroupLayout(mainFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
		);
		
		JLabel logoLbl = new JLabel("");
		logoLbl.setIcon(new ImageIcon(MainWin.class.getResource("/com/FatOff/View/fat_off_white.png")));
		
		JLabel customerNameLbl = new JLabel("Customer Name: ");
		customerNameLbl.setForeground(Color.WHITE);
		customerNameLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		customerNameField = new JTextField(cust.toString());
		customerNameField.setForeground(Color.WHITE);
		customerNameField.setFont(new Font("Century Gothic", Font.BOLD, 18));
		customerNameField.setFocusable(false);
		customerNameField.setFocusTraversalKeysEnabled(false);
		customerNameField.setDragEnabled(false);
		customerNameField.setRequestFocusEnabled(false);
		customerNameField.setVerifyInputWhenFocusTarget(false);
		customerNameField.setEditable(false);
		customerNameField.setAutoscrolls(false);
		customerNameField.setColumns(10);
		customerNameField.setBackground(null);
		
		JLabel measuresLbl = new JLabel("Measures:");
		measuresLbl.setForeground(Color.WHITE);
		measuresLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		wightTField = new JTextField();
		wightTField.setText("Enter Weight");
		wightTField.setHorizontalAlignment(SwingConstants.CENTER);
		wightTField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		wightTField.setColumns(10);
		
		JLabel weightLbl = new JLabel("Weight :");
		weightLbl.setForeground(Color.WHITE);
		weightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		heightTField = new JTextField();
		heightTField.setText("Enter Height");
		heightTField.setHorizontalAlignment(SwingConstants.CENTER);
		heightTField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		heightTField.setColumns(10);
		
		JLabel heightLbl = new JLabel("Height :");
		heightLbl.setForeground(Color.WHITE);
		heightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		wristTField = new JTextField();
		wristTField.setText("Enter Wrist");
		wristTField.setHorizontalAlignment(SwingConstants.CENTER);
		wristTField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		wristTField.setColumns(10);
		
		JLabel wristLbl = new JLabel("Wrist:");
		wristLbl.setForeground(Color.WHITE);
		wristLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel ageLbl = new JLabel("Age: ");
		ageLbl.setForeground(Color.WHITE);
		ageLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		ageTFIeld = new JTextField(CustomerController.calcAge(cust));
		ageTFIeld.setForeground(Color.WHITE);
		ageTFIeld.setFont(new Font("Century Gothic", Font.BOLD, 18));
		ageTFIeld.setVerifyInputWhenFocusTarget(false);
		ageTFIeld.setRequestFocusEnabled(false);
		ageTFIeld.setFocusable(false);
		ageTFIeld.setFocusTraversalKeysEnabled(false);
		ageTFIeld.setDragEnabled(false);
		ageTFIeld.setEditable(false);
		ageTFIeld.setColumns(10);
		ageTFIeld.setBackground((Color) null);
		
		JLabel weistLbl = new JLabel("Weist:");
		weistLbl.setForeground(Color.WHITE);
		weistLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		weistTField = new JTextField();
		weistTField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		weistTField.setHorizontalAlignment(SwingConstants.CENTER);
		weistTField.setText("Enter Weist");
		weistTField.setColumns(10);
		
		JScrollPane summaryScrlPane = new JScrollPane();
		
		JLabel thighLbl = new JLabel("Thigh:");
		thighLbl.setForeground(Color.WHITE);
		thighLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		thighTField = new JTextField();
		thighTField.setHorizontalAlignment(SwingConstants.CENTER);
		thighTField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		thighTField.setText("Enter Thigh");
		thighTField.setColumns(10);
		
		JLabel menuLbl = new JLabel("Enter Menu Here:");
		menuLbl.setForeground(Color.WHITE);
		menuLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel breakfastLbl = new JLabel("Breakfast:");
		breakfastLbl.setForeground(Color.WHITE);
		breakfastLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JScrollPane breakfastScrlPane = new JScrollPane();
		
		JLabel snack1Lbl = new JLabel("Snack 1:");
		snack1Lbl.setForeground(Color.WHITE);
		snack1Lbl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lunchLbl = new JLabel("Lunch:");
		lunchLbl.setForeground(Color.WHITE);
		lunchLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JScrollPane lunchfastScrlPane = new JScrollPane();
		
		JLabel snack2Lbl = new JLabel("Snack 2:");
		snack2Lbl.setForeground(Color.WHITE);
		snack2Lbl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel dinnerLbl = new JLabel("Dinner:");
		dinnerLbl.setForeground(Color.WHITE);
		dinnerLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JScrollPane dinnerScrlPane = new JScrollPane();
		
		JTextPane gnrlSummTPane = new JTextPane();
		gnrlSummTPane.setForeground(Color.WHITE);
		gnrlSummTPane.setBackground(null);
		gnrlSummTPane.setEditable(false);
		gnrlSummTPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		gnrlSummTPane.setText("General\nSummary");
		gnrlSummTPane.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JLabel bmiLbl = new JLabel("BMI:");
		bmiLbl.setForeground(Color.WHITE);
		bmiLbl.setFont(new Font("Dialog", Font.BOLD, 16));
		
		bmiTField = new JTextField();
		bmiTField.setColumns(10);
		
		JLabel eerLbl = new JLabel("EER:");
		eerLbl.setForeground(Color.WHITE);
		eerLbl.setFont(new Font("Dialog", Font.BOLD, 16));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton clearBtn = new JButton("Clear");
		
		JButton calcBtn = new JButton("Claculate");
		
		JButton emailSummBtn = new JButton("Save and Send");
		
		JButton btnNewButton = new JButton("Show Graph");
		
		JLabel dateLbl = new JLabel("Date:");
		dateLbl.setForeground(Color.WHITE);
		dateLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		LocalDateTime now = LocalDateTime.now();
		JLabel todayLbl = new JLabel(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(now).toString());
		todayLbl.setForeground(Color.WHITE);
		todayLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addGap(24)
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(thighLbl)
										.addGroup(gl_mainPanel.createSequentialGroup()
											.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(bmiLbl)
												.addComponent(eerLbl))
											.addGap(18)
											.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(bmiTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_mainPanel.createSequentialGroup()
												.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
													.addComponent(heightLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
													.addComponent(weightLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
													.addComponent(measuresLbl))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
													.addComponent(heightTField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
													.addComponent(wightTField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
											.addGroup(gl_mainPanel.createSequentialGroup()
												.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
													.addComponent(wristLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
													.addComponent(weistLbl))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
													.addComponent(weistTField, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
													.addComponent(wristTField, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
													.addComponent(thighTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_mainPanel.createSequentialGroup()
											.addComponent(clearBtn)
											.addGap(18)
											.addComponent(calcBtn)))
									.addGap(107))
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addComponent(logoLbl)
									.addGap(41)
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(customerNameLbl)
										.addComponent(ageLbl))))
							.addGap(7)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addGap(20)
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(summaryScrlPane, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
										.addComponent(lunchfastScrlPane, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
										.addComponent(breakfastScrlPane, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
										.addGroup(gl_mainPanel.createSequentialGroup()
											.addComponent(snack1Lbl)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
										.addGroup(gl_mainPanel.createSequentialGroup()
											.addComponent(snack2Lbl)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
										.addComponent(dinnerScrlPane, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
										.addGroup(gl_mainPanel.createSequentialGroup()
											.addComponent(menuLbl)
											.addGap(437))
										.addComponent(breakfastLbl, Alignment.LEADING)
										.addComponent(lunchLbl, Alignment.LEADING)
										.addComponent(dinnerLbl, Alignment.LEADING)
										.addGroup(gl_mainPanel.createSequentialGroup()
											.addComponent(btnNewButton)
											.addGap(26)
											.addComponent(emailSummBtn))))
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(ageTFIeld, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_mainPanel.createSequentialGroup()
											.addComponent(customerNameField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
											.addComponent(dateLbl)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(todayLbl)))))
							.addGap(96))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(266)
							.addComponent(gnrlSummTPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(logoLbl)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addContainerGap(15, Short.MAX_VALUE)
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(customerNameLbl)
										.addComponent(customerNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(ageLbl)
										.addComponent(ageTFIeld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(todayLbl)
										.addComponent(dateLbl))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addGap(18)
									.addComponent(summaryScrlPane, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addGap(32)
									.addComponent(gnrlSummTPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(16)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(menuLbl)
							.addGap(20)
							.addComponent(breakfastLbl))
						.addComponent(measuresLbl))
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(weightLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(wightTField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(heightLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(heightTField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(wristLbl)
								.addComponent(wristTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(weistLbl)
								.addComponent(weistTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(thighLbl)
								.addComponent(thighTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(clearBtn)
								.addComponent(calcBtn)))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(breakfastScrlPane, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(snack1Lbl)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lunchLbl)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lunchfastScrlPane, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(snack2Lbl)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(dinnerLbl)
						.addComponent(bmiLbl)
						.addComponent(bmiTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(dinnerScrlPane, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(eerLbl)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailSummBtn)
						.addComponent(btnNewButton))
					.addGap(40))
		);
		
		JTextArea dinnerArea = new JTextArea();
		dinnerScrlPane.setViewportView(dinnerArea);
		
		JTextArea lunchArea = new JTextArea();
		lunchfastScrlPane.setViewportView(lunchArea);
		
		JTextArea breakfastArea = new JTextArea();
		breakfastScrlPane.setViewportView(breakfastArea);
		
		JTextArea summaryArea = new JTextArea();
		summaryScrlPane.setViewportView(summaryArea);
		mainPanel.setLayout(gl_mainPanel);
		mainFrame.getContentPane().setLayout(groupLayout);
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.pack();
	
	}
}
