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
							type = "Admin";
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
							type = "Nutritionist";
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
		
		JButton changeBtn = new JButton("Change");
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new String(newPass.getPassword()).equals(new String(confPass.getPassword())))
				{
					((Nutritionist)nut).setPassword(new String(newPass.getPassword()));
					if(type.equals("Admin")) {
						if(AdminController.storeAdmin((Admin)nut)) {
							JOptionPane.showMessageDialog(null, "Your password has been changed");
						}
					}
					else {
						if(type.equals("Nutritionist")) {
							if(NutritionistController.storeNutritionist((Nutritionist)nut)) {
								JOptionPane.showMessageDialog(null, "Your password has been changed");
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
		changeBtn.setEnabled(false);
		changeBtn.setBounds(300, 161, 117, 29);
		
		JButton checkBtn = new JButton("Validate");
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
		
		newPass = new JPasswordField();
		newPass.setEnabled(false);
		newPass.setEditable(false);
		newPass.setBounds(158, 133, 130, 26);
		newPass.setColumns(10);
		
		confPass = new JPasswordField();
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
		

		resetFrame.setSize(new Dimension(453, 270));
		
		resetFrame.setLocationRelativeTo(null);

		resetFrame.setVisible(true);
	}
	
	
	
}
