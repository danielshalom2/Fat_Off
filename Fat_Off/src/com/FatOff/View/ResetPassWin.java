package com.FatOff.View;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;

import com.FatOff.Controller.AdminController;
import com.FatOff.Controller.NutritionistController;
import com.FatOff.Model.Admin;
import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.SaveRestore;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;

public class ResetPassWin {
	private final JButton ResetEmail = new JButton("Send Validation Code");
	private JTextField validCode;
	private JPasswordField newPass;
	private JPasswordField confPass;
	private String valCode;
	private Object nut;
	private JTextField IDreset;
	private String type;
	
	public ResetPassWin() {
		JFrame resetFrame= new JFrame("PassReset");
		resetFrame.getContentPane().setBackground(new Color(36, 47, 65));
//		ResetEmail.setBackground(new Color(97, 212, 195));
//		ResetEmail.setFont(new Font("Century Gothic", Font.PLAIN, 16));
//		//resetFrame.getContentPane().setLayout(null);
//		ResetEmail.setLayout(null);
//		ResetEmail.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (IDreset.getText().equals("")) {
//					JOptionPane.showMessageDialog(null, "Your ID is required in order to identify you!");
//				} else {
//					boolean found = false;
//					String path = SaveRestore.getPath();
//					File pathToAdmin = new File(path + "/Admin");
//					File pathToDieticion = new File(path + "/Dieticions");
//					for (String desired : pathToAdmin.list()) {
//						if (desired.equals(".DS_Store")) {
//							continue;
//						}
//						String ID[] = desired.split("_");
//						if (ID[2].equals(IDreset.getText())) {
//							found = true;
//							type = "Admin";
//							nut = AdminController.restoreAdmin(desired);
//							valCode=((Nutritionist) nut).resetPassword();
//						}
//					}
//					for (String desired : pathToDieticion.list()) {
//						if (desired.equals(".DS_Store")) {
//							continue;
//						}
//						String ID[] = desired.split("_");
//						if (ID[2].equals(IDreset.getText())) {
//							found = true;
//							type = "Nutritionist";
//							 nut = NutritionistController.restoreNut(desired);
//							valCode=((Nutritionist) nut).resetPassword();
//							
//						}
//					}
//					if (!found) {
//						JOptionPane.showMessageDialog(null, "No such user found!");
//						// signInFrame.dispose();
//					}
//				}
//				
//				
//			}
//		});
//		ResetEmail.setBounds(396, 29, 180, 21);
		
		JButton sendValidBtn = new JButton("Send Validation Code");
		sendValidBtn.setForeground(Color.WHITE);
		sendValidBtn.setFont(new Font("Century Gothic", Font.BOLD, 16));
		sendValidBtn.setBorder(null);
		sendValidBtn.setBackground(new Color(97, 212, 195));
		sendValidBtn.setBounds(396, 18, 180, 38);
		resetFrame.getContentPane().add(sendValidBtn);
		
		sendValidBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (IDreset.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Your ID is required in order to identify you!");
				} else {
					boolean found = false;
					String path = SaveRestore.getPath();
					File pathToAdmin = new File(path + "/Admin");
					File pathToDieticion = new File(path + "/Dieticions");
					for (String desired : pathToAdmin.list()) {
						if (desired.equals(".DS_Store")) {
							continue;
						}
						String ID[] = desired.split("_");
						if (ID[2].equals(IDreset.getText())) {
							found = true;
							type = "Admin";
							nut = AdminController.restoreAdmin(desired);
							valCode=((Nutritionist) nut).resetPassword();
							JOptionPane.showMessageDialog(null, "Validation code sent to your E-Mail!");
						}
					}
					for (String desired : pathToDieticion.list()) {
						if (desired.equals(".DS_Store")) {
							continue;
						}
						String ID[] = desired.split("_");
						if (ID[2].equals(IDreset.getText())) {
							found = true;
							type = "Nutritionist";
							 nut = NutritionistController.restoreNut(desired);
							valCode=((Nutritionist) nut).resetPassword();
							JOptionPane.showMessageDialog(null, "Validation code sent to your E-Mail!");
							
						}
					}
					if (!found) {
						JOptionPane.showMessageDialog(null, "No such user found!");
						// signInFrame.dispose();
					}
				}
				
				
			}
		});
		
		JButton btnChange = new JButton("Change");
		btnChange.setEnabled(false);
		btnChange.setForeground(Color.WHITE);
		btnChange.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnChange.setBorder(null);
		btnChange.setBackground(new Color(97, 212, 195));
		btnChange.setBounds(158, 201, 180, 38);
		JButton validBtn = new JButton("Validate");
		validBtn.setForeground(Color.WHITE);
		validBtn.setFont(new Font("Century Gothic", Font.BOLD, 16));
		validBtn.setBorder(null);
		validBtn.setBackground(new Color(97, 212, 195));
		validBtn.setBounds(396, 106, 180, 38);
		resetFrame.getContentPane().add(validBtn);
		
		validBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( valCode.equals(validCode.getText())) {
					newPass.setEnabled(true);
					newPass.setEditable(true);
					confPass.setEnabled(true);
					confPass.setEditable(true);
					btnChange.setEnabled(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Validation Code");
				}
			}
		});
		
<<<<<<< HEAD
		JButton changeBtn = new JButton("Change");
		changeBtn.addActionListener(new ActionListener() {
=======
		
		
		
		
		
		
		resetFrame.getContentPane().add(btnChange);
		btnChange.addActionListener(new ActionListener() {
>>>>>>> stash
			public void actionPerformed(ActionEvent e) {
				if(new String(newPass.getPassword()).equals(new String(confPass.getPassword())))
				{
					((Nutritionist)nut).setPassword(new String(newPass.getPassword()));
					if(type.equals("Admin")) {
						if(AdminController.storeAdmin((Admin)nut)) {
							JOptionPane.showMessageDialog(null, "Your password has been changed");
							resetFrame.dispose();							
						}
					}
					else {
						if(type.equals("Nutritionist")) {
							if(NutritionistController.storeNutritionist((Nutritionist)nut)) {
								JOptionPane.showMessageDialog(null, "Your password has been changed");
								resetFrame.dispose();
							}
						}
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "The confirmation password didn't match");
				}
			}
		});
		btnChange.setBounds(158, 201, 180, 21);
		
		JLabel lblNewLabel = new JLabel("Validation Code:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(16, 106, 138, 19);
		
		validCode = new JTextField();
		validCode.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		validCode.setBounds(158, 106, 192, 19);
		validCode.setColumns(10);
		

		
		JLabel text = new JLabel("New Password:");
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		text.setBounds(16, 146, 133, 19);
		
		JLabel text2 = new JLabel("Confirm Password:");
		text2.setForeground(new Color(255, 255, 255));
		text2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		text2.setBounds(16, 174, 138, 19);
		
		newPass = new JPasswordField();
		newPass.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		newPass.setBounds(158, 144, 192, 19);
		newPass.setColumns(10);
		
		confPass = new JPasswordField();
		confPass.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		confPass.setBounds(158, 172, 192, 19);
		confPass.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID Account:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(16, 29, 133, 19);
		
		IDreset = new JTextField();
		IDreset.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		IDreset.setBounds(157, 31, 193, 19);
		IDreset.setColumns(10);
<<<<<<< HEAD
		GroupLayout groupLayout = new GroupLayout(resetFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(IDreset, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(ResetEmail, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(text2)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(confPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(text, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
											.addGap(38)
											.addComponent(newPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(changeBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(validCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(checkBtn, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(166)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(text2)
								.addComponent(confPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(changeBtn)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(138)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(text)
								.addComponent(newPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(98)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel)
									.addComponent(validCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(checkBtn)))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(25)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(IDreset, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(ResetEmail))))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		resetFrame.getContentPane().setLayout(groupLayout);
=======
		resetFrame.getContentPane().setLayout(null);
		resetFrame.getContentPane().add(confPass);
		resetFrame.getContentPane().add(validCode);
		resetFrame.getContentPane().add(validBtn);
		resetFrame.getContentPane().add(lblNewLabel_1);
		resetFrame.getContentPane().add(IDreset);
		resetFrame.getContentPane().add(newPass);
		resetFrame.getContentPane().add(text2);
		resetFrame.getContentPane().add(lblNewLabel);
		resetFrame.getContentPane().add(btnChange);
		resetFrame.getContentPane().add(ResetEmail);
		resetFrame.getContentPane().add(text);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(16, 76, 560, 2);
		resetFrame.getContentPane().add(separator);
		

		
		
>>>>>>> stash
		

		resetFrame.setSize(new Dimension(453, 270));
		
		resetFrame.setLocationRelativeTo(null);

		resetFrame.setVisible(true);
	}
}
