
package com.FatOff.View;

import javax.swing.*;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class SignInWin {
	private JTextField textField;
	private JPasswordField passwordField;
	
	public SignInWin() {

		JFrame signInFrame = new JFrame("Sign In");
		signInFrame.setResizable(false);
		signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signInFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		panel.setBounds(0, 0, 405, 252);
		signInFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel logoLbl = new JLabel("");
		logoLbl.setIcon(new ImageIcon(SignInWin.class.getResource("/com/FatOff/View/imgonline-com-ua-resize-5aRADIEx30404X17.png")));
		logoLbl.setBounds(17, 33, 108, 180);
		panel.add(logoLbl);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setBounds(137, 71, 76, 31);
		panel.add(lblNewLabel);
		
		JLabel passwordLbl = new JLabel("Password :");
		passwordLbl.setBounds(137, 114, 76, 31);
		panel.add(passwordLbl);
		
		textField = new JTextField();
		textField.setBounds(215, 73, 168, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(215, 116, 168, 26);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to Fat Off");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(148, 6, 168, 16);
		panel.add(lblNewLabel_1);
		
		JButton signInBtn = new JButton("Sign In");
		signInBtn.setBounds(277, 184, 117, 29);
		panel.add(signInBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signInFrame.dispose();
			}
		});
		cancelBtn.setBounds(148, 184, 117, 29);
		panel.add(cancelBtn);
		
		JLabel lblNewLabel_2 = new JLabel("All Right Reserved © Fat Off Developers 2020");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 256, 373, 16);
		signInFrame.getContentPane().add(lblNewLabel_2);
		signInFrame.setSize(new Dimension(404, 298));
		signInFrame.setVisible(true);
		
	}
}


