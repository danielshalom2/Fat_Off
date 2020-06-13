package com.FatOff.View;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;

import javax.swing.JTextField;

import com.FatOff.Controller.AdminController;
import com.FatOff.Controller.NutritionistController;
import com.FatOff.Model.Admin;
import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.SaveRestore;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;

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
		JFrame resetFrame = new JFrame("PassReset");
		resetFrame.getContentPane().setBackground(new Color(36, 47, 65));

		/////////////////////////////// set icon //////////////////////////////////
		ImageIcon icon = new ImageIcon("src/com/FatOff/View/IconFatOff.PNG");
		resetFrame.setIconImage(icon.getImage());
		//////////////////////////////////////////////////////////////////////////

		JButton sendValidBtn = new JButton("Send Validation Code");
		sendValidBtn.setForeground(Color.WHITE);
		sendValidBtn.setFont(new Font("Century Gothic", Font.BOLD, 16));
		sendValidBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
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
							JOptionPane.showMessageDialog(null,
									"Valdiation code was sent to your email\nPlease check and validate!");
							type = "Admin";
							nut = AdminController.restoreAdmin(desired);
							valCode = ((Nutritionist) nut).resetPassword();
							
						}
					}
					for (String desired : pathToDieticion.list()) {
						if (desired.equals(".DS_Store")) {
							continue;
						}
						String ID[] = desired.split("_");
						if (ID[2].equals(IDreset.getText())) {
							found = true;
							JOptionPane.showMessageDialog(null,
									"Valdiation code was sent to your email\nPlease check and validate!");
							type = "Nutritionist";
							nut = NutritionistController.restoreNut(desired);
							valCode = ((Nutritionist) nut).resetPassword();

						}
					}
					if (!found) {
						JOptionPane.showMessageDialog(null, "No such user found!");
					}

				}

			}
		});

		JButton btnChange = new JButton("Change");
		btnChange.setEnabled(false);
		btnChange.setForeground(Color.WHITE);
		btnChange.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnChange.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		btnChange.setBackground(new Color(97, 212, 195));
		btnChange.setBounds(162, 201, 108, 21);
		JButton validBtn = new JButton("Validate");
		validBtn.setForeground(Color.WHITE);
		validBtn.setFont(new Font("Century Gothic", Font.BOLD, 16));
		validBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		validBtn.setBackground(new Color(97, 212, 195));
		validBtn.setBounds(396, 106, 180, 38);
		resetFrame.getContentPane().add(validBtn);

		validBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valCode.equals(validCode.getText())) {
					newPass.setEnabled(true);
					newPass.setEditable(true);
					confPass.setEnabled(true);
					confPass.setEditable(true);
					btnChange.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Wrong Validation Code");
				}
			}
		});

		resetFrame.getContentPane().add(btnChange);
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new String(newPass.getPassword()).equals(new String(confPass.getPassword()))) {
					((Nutritionist) nut).setPassword(new String(newPass.getPassword()));
					if (type.equals("Admin")) {
						if (AdminController.storeAdmin((Admin) nut)) {
							JOptionPane.showMessageDialog(null, "Your password has been changed");
							resetFrame.dispose();
						}
					} else {
						if (type.equals("Nutritionist")) {
							if (NutritionistController.storeNutritionist((Nutritionist) nut)) {
								JOptionPane.showMessageDialog(null, "Your password has been changed");
								resetFrame.dispose();
							}
						}
					}
				} else {
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
		newPass.setEnabled(false);
		newPass.setEditable(false);
		newPass.setBounds(158, 144, 192, 19);
		newPass.setColumns(10);

		confPass = new JPasswordField();
		confPass.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		confPass.setEnabled(false);
		confPass.setEditable(false);
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

		resetFrame.setSize(new Dimension(600, 300));

		resetFrame.setLocationRelativeTo(null);

		resetFrame.setVisible(true);
	}
}