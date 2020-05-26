
package com.FatOff.View;

import javax.swing.*;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import com.FatOff.Controller.AdminController;
import com.FatOff.Controller.NutritionistController;
import com.FatOff.Model.Admin;
import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.SaveRestore;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SignInWin {
	private JTextField yourIdField;
	private JPasswordField passwordField;

	public SignInWin() {

		JFrame signInFrame = new JFrame("Sign In");
		signInFrame.setResizable(true);
		signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signInFrame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));

		JLabel logoLbl = new JLabel("");
		logoLbl.setIcon(new ImageIcon(
				SignInWin.class.getResource("/com/FatOff/View/imgonline-com-ua-resize-5aRADIEx30404X17.png")));

		JLabel yourIdWarnLbl = new JLabel("");
		yourIdWarnLbl.setForeground(Color.RED);
		yourIdWarnLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 9));

		JLabel yourIdLbl = new JLabel("Your ID :");

		JLabel passwordLbl = new JLabel("Password :");

		yourIdField = new JTextField();
		yourIdField.setColumns(10);
		yourIdField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = yourIdField.getText();
				int l = value.length();
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b') {
					yourIdField.setEditable(true);
					yourIdWarnLbl.setText("");
				} else {
					yourIdField.setEditable(false);
					yourIdWarnLbl.setText("* Enter only numeric digits(0-9)");
				}
			}
		});

		passwordField = new JPasswordField();

		JLabel headerLbl = new JLabel("Welcome to Fat Off");
		headerLbl.setFont(new Font("Lucida Grande", Font.ITALIC, 16));

		JButton signInBtn = new JButton("Sign In");
		signInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (yourIdField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Your ID is required in order to identify you!");
				} else if (passwordField.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Your password is required in order to identify you!");
				} else {
					boolean found = false;
					String path = SaveRestore.getPath();
					File pathToAdmin = new File(path + "/Admin");
					File pathToDieticion = new File(path + "/Dieticions");
					for (String desired : pathToAdmin.list()) {
						if (desired.contains(yourIdField.getText())) {
							found = true;
							Admin adm = AdminController.restoreAdmin(desired);
							if (new String(passwordField.getPassword()).equals(adm.getPassword())) {
								new MainWin(adm, "Admin");
								signInFrame.dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Wrong Password!");
							}
						}
					}
					for (String desired : pathToDieticion.list()) {
						if (desired.contains(yourIdField.getText())) {
							found = true;
							Nutritionist nut = NutritionistController.restoreNut(desired);
							if (new String(passwordField.getPassword()).equals(nut.getPassword())) {
								new MainWin(nut, "Nutritionist");
								signInFrame.dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Wrong Password!");
							}
						}
					}
					if(!found) {
						JOptionPane.showMessageDialog(null, "No such user found!");
						signInFrame.dispose();
					}
				}
			}
		});

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signInFrame.dispose();
			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(147).addComponent(headerLbl,
						GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(16)
						.addComponent(logoLbl, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE).addGap(12)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
								.createSequentialGroup()
								.addComponent(yourIdLbl, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addGap(2)
												.addComponent(yourIdField, GroupLayout.DEFAULT_SIZE, 182,
														Short.MAX_VALUE)
												.addGap(11))
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(yourIdWarnLbl)
												.addContainerGap())))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(passwordLbl, GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addGap(2)
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
										.addGap(11))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 117,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(signInBtn,
												GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(5)
				.addComponent(headerLbl, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE).addGap(11)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(logoLbl, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup().addGap(38).addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING)
								.addComponent(yourIdLbl, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(yourIdField,
										GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
								.addGap(12)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordLbl, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(passwordField,
												GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
								.addGap(39)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(signInBtn, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE)))))
				.addGroup(Alignment.TRAILING,
						gl_panel.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
								.addComponent(yourIdWarnLbl, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
								.addGap(120)));
		panel.setLayout(gl_panel);

		JLabel copyrightLbl = new JLabel("All Rights Reserved\u00A9 Fat Off Developers 2020");
		copyrightLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(signInFrame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addComponent(copyrightLbl, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE).addGap(12))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(213, Short.MAX_VALUE)
						.addComponent(copyrightLbl, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(15)));
		signInFrame.getContentPane().setLayout(groupLayout);
		signInFrame.setSize(new Dimension(409, 268));
		signInFrame.setVisible(true);

	}
}
