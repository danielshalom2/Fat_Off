package com.FatOff.View;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
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

public class ResetPassWin {
	private final JButton ResetEmail = new JButton("Send Validation Code");
	private JTextField validCode;
	private JTextField newPass;
	private JTextField confPass;
	private JTextField IDreset;
	private String valCode;
	private Object nut;
	
	public ResetPassWin() {
		JFrame resetFrame= new JFrame("PassReset");
		resetFrame.getContentPane().setLayout(null);
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
		resetFrame.getContentPane().add(ResetEmail);
		
		JLabel lblNewLabel = new JLabel("Validation Code");
		lblNewLabel.setBounds(16, 98, 138, 16);
		resetFrame.getContentPane().add(lblNewLabel);
		
		validCode = new JTextField();
		validCode.setBounds(158, 95, 130, 26);
		resetFrame.getContentPane().add(validCode);
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
		resetFrame.getContentPane().add(changeBtn);
		
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
		resetFrame.getContentPane().add(checkBtn);
		
		JLabel text = new JLabel("New Password");
		text.setBounds(16, 138, 104, 16);
		resetFrame.getContentPane().add(text);
		
		JLabel text2 = new JLabel("Confirm Password");
		text2.setBounds(16, 166, 114, 16);
		resetFrame.getContentPane().add(text2);
		
		newPass = new JTextField();
		newPass.setEnabled(false);
		newPass.setEditable(false);
		newPass.setBounds(158, 133, 130, 26);
		resetFrame.getContentPane().add(newPass);
		newPass.setColumns(10);
		
		confPass = new JTextField();
		confPass.setEnabled(false);
		confPass.setEditable(false);
		confPass.setBounds(158, 161, 130, 26);
		resetFrame.getContentPane().add(confPass);
		confPass.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID Account");
		lblNewLabel_1.setBounds(6, 29, 117, 16);
		resetFrame.getContentPane().add(lblNewLabel_1);
		
		IDreset = new JTextField();
		IDreset.setBounds(158, 24, 130, 26);
		resetFrame.getContentPane().add(IDreset);
		IDreset.setColumns(10);
	}
	
	
	
}
