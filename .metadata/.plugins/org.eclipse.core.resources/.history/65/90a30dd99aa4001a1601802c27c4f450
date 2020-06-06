
package com.FatOff.View;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitialWin {
	private JMenuItem resetPassNut2;
	///need to check what need to be X
	public InitialWin(String X,Object nut) {
	
		JFrame initailframe =new JFrame("Initial Window - FatOff");
		initailframe.getContentPane().setBackground(new Color(36, 47, 65));
		initailframe.getContentPane().setLayout(null);
		
		
		JLabel Logolbl = new JLabel("");
		Logolbl.setIcon(new ImageIcon(MainWin2.class.getResource("/com/FatOff/View/fat_off_white.png")));
		Logolbl.setForeground(Color.WHITE);
		Logolbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Logolbl.setBounds(0, 44, 133, 199);
		initailframe.getContentPane().add(Logolbl, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Welcome to Fat Off");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(194, 22, 296, 45);
		initailframe.getContentPane().add(lblNewLabel);
		
		JLabel lblPleaseChooseYour = new JLabel("Please choose your action");
		lblPleaseChooseYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseChooseYour.setForeground(Color.WHITE);
		lblPleaseChooseYour.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblPleaseChooseYour.setBounds(194, 57, 296, 45);
		initailframe.getContentPane().add(lblPleaseChooseYour);
		
		JButton openCus = new JButton("Open Existing Customer");
		openCus.setBorderPainted(false);
		openCus.setForeground(Color.WHITE);
		openCus.setFont(new Font("Century Gothic", Font.BOLD, 14));
		openCus.setBorder(null);
		openCus.setBackground(new Color(97, 212, 195));
		openCus.setBounds(241, 112, 199, 45);
		initailframe.getContentPane().add(openCus);
		
		JButton createCus = new JButton("Create New Customer");
		createCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateCustomerWin();
			}
		});
		createCus.setForeground(Color.WHITE);
		createCus.setFont(new Font("Century Gothic", Font.BOLD, 14));
		createCus.setBorder(null);
		createCus.setBackground(new Color(97, 212, 195));
		createCus.setBounds(241, 168, 199, 45);
		initailframe.getContentPane().add(createCus);
		
		JButton quitbtn = new JButton("Quit");
		quitbtn.setForeground(Color.WHITE);
		quitbtn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		quitbtn.setBorder(null);
		quitbtn.setBackground(new Color(97, 212, 195));
		quitbtn.setBounds(563, 327, 67, 19);
		initailframe.getContentPane().add(quitbtn);
		
		JMenuBar menuBar = new JMenuBar();
		initailframe.setJMenuBar(menuBar);
		
		JMenu nutriMenu = new JMenu("Nutritionist Menu");
		menuBar.add(nutriMenu);
		
		resetPassNut2 = new JMenuItem("Reset Password");
		nutriMenu.add(resetPassNut2);
		
		JMenu adminMenu = new JMenu("Admin Menu");
		menuBar.add(adminMenu);
		
		JMenuItem resetPassNut1 = new JMenuItem("Reset Password Nutritionist");
		adminMenu.add(resetPassNut1);
		
		JMenuItem createNut = new JMenuItem("Create Nutritionist");
		adminMenu.add(createNut);
		
		JMenuItem moveCus = new JMenuItem("Move Customer");
		adminMenu.add(moveCus);
		
		
	}
}
