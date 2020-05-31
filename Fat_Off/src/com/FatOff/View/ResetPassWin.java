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

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ResetPassWin {
	private final JButton ResetEmail = new JButton("Send Validation Code");
	private JTextField validCode;
	private JTextField newPass;
	private JTextField confPass;
	private String valCode;
	private Object nut;
	private JTextField IDreset;
	
	public ResetPassWin() {
		JFrame resetFrame= new JFrame("PassReset");
		//resetFrame.getContentPane().setLayout(null);
		ResetEmail.addActionListener(new ActionListener() {
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
							 nut = AdminController.restoreAdmin(desired);
							valCode=((Nutritionist) nut).resetPassword();
						}
					}
					for (String desired : pathToDieticion.list()) {
						if (desired.equals(".DS_Store")) {
							continue;
						}
						String ID[] = desired.split("_");
						if (ID[2].equals(IDreset.getText())) {
							found = true;
							 nut = NutritionistController.restoreNut(desired);
							valCode=((Nutritionist) nut).resetPassword();
							
						}
					}
					if (!found) {
						JOptionPane.showMessageDialog(null, "No such user found!");
						// signInFrame.dispose();
					}
				}
				
				
			}
		});
		ResetEmail.setBounds(0, 57, 450, 29);
		
		JLabel lblNewLabel = new JLabel("Validation Code");
		lblNewLabel.setBounds(16, 98, 138, 16);
		
		validCode = new JTextField();
		validCode.setBounds(158, 95, 130, 26);
		validCode.setColumns(10);
		
		JButton changeBtn = new JButton("Confirm");
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(newPass.getText().equals(confPass.getText()))
				{
					((Nutritionist)nut).setPassword(newPass.getText());
					JOptionPane.showMessageDialog(null, "Pass Reset");
				}
				else {
					JOptionPane.showMessageDialog(null, "Different Passwords");
				}
			}
		});
		changeBtn.setEnabled(false);
		changeBtn.setBounds(300, 161, 117, 29);
		
		JButton checkBtn = new JButton("Check Code");
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( valCode.equals(validCode.getText())) {
					newPass.setEnabled(true);
					newPass.setEditable(true);
					confPass.setEnabled(true);
					confPass.setEditable(true);
					changeBtn.setEnabled(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Validation Code");
				}
			}
		});
		checkBtn.setBounds(300, 95, 117, 29);
		
		JLabel text = new JLabel("New Password");
		text.setBounds(16, 138, 104, 16);
		
		JLabel text2 = new JLabel("Confirm Password");
		text2.setBounds(16, 166, 114, 16);
		
		newPass = new JTextField();
		newPass.setEnabled(false);
		newPass.setEditable(false);
		newPass.setBounds(158, 133, 130, 26);
		newPass.setColumns(10);
		
		confPass = new JTextField();
		confPass.setEnabled(false);
		confPass.setEditable(false);
		confPass.setBounds(158, 161, 130, 26);
		confPass.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID Account");
		lblNewLabel_1.setBounds(6, 29, 117, 16);
		
		IDreset = new JTextField();
		IDreset.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(resetFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(158)
							.addComponent(confPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(158)
							.addComponent(validCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(300)
							.addComponent(checkBtn, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(IDreset, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(158)
							.addComponent(newPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(text2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(300)
							.addComponent(changeBtn, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addComponent(ResetEmail, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(text, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(150, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addComponent(checkBtn))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel_1))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(text2))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(lblNewLabel))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(161)
					.addComponent(changeBtn))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(138)
					.addComponent(text))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(IDreset, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(116)
							.addComponent(confPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(validCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(newPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ResetEmail))))
		);
		resetFrame.getContentPane().setLayout(groupLayout);
		

		resetFrame.setSize(new Dimension(600, 300));
		
		resetFrame.setLocationRelativeTo(null);

		resetFrame.setVisible(true);
	}
	
	
	
}
