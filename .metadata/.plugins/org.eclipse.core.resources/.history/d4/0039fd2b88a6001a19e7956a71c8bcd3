
package com.FatOff.View;
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import com.FatOff.Model.Customer;
import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.SaveRestore;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class InitialWin {
	private JMenuItem changePassNut2;
	///need to check what need to be X
	public InitialWin(File path,Object nut) {
	
		JFrame initailframe =new JFrame("Initial Window - FatOff");
		initailframe.setResizable(false);
		initailframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initailframe.getContentPane().setBackground(new Color(36, 47, 65));
		initailframe.getContentPane().setLayout(null);
		
		/////////////////////////////// set icon //////////////////////////////////
		ImageIcon icon = new ImageIcon("src/com/FatOff/View/��IconFatOff.PNG");
		initailframe.setIconImage(icon.getImage());
		//////////////////////////////////////////////////////////////////////////
		
		
		JLabel Logolbl = new JLabel("");
		Logolbl.setIcon(new ImageIcon(MainWin.class.getResource("/com/FatOff/View/fat_off_white.png")));
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
		openCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Search Customer");
				List<Customer> customers = ((Nutritionist)nut).getCustomersList();
		        JComboBox<Customer> comboBox = new JComboBox<>(
		                customers.toArray(new Customer[customers.size()]));

		        CustomerSearchDecorator<Customer> decorate = CustomerSearchDecorator.decorate(comboBox,InitialWin::customerFilter);

		        comboBox.setRenderer(new CustomComboRenderer(decorate.getFilterLabel()));
		        
		        JButton selectBtn = new JButton("Select");
		        selectBtn.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		Customer selected = (Customer) comboBox.getSelectedItem();
		        		new MainWin(((Nutritionist)nut),selected);
		        		initailframe.dispose();	
		        		frame.dispose();
		        		}
		        });
		        JPanel panel = new JPanel();
				panel.add(comboBox);
				panel.add(selectBtn);

				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(new Dimension(350, 200));
				frame.getContentPane().add(panel);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		});
		//openCus.setBorderPainted(false);
		openCus.setForeground(Color.WHITE);
		openCus.setFont(new Font("Century Gothic", Font.BOLD, 14));
		openCus.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		openCus.setBackground(new Color(97, 212, 195));
		openCus.setBounds(241, 112, 199, 45);
		initailframe.getContentPane().add(openCus);
		
		JButton createCus = new JButton("Create New Customer");
		createCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateCustomerWin(path.toString() , nut);
			}
		});
		createCus.setForeground(Color.WHITE);
		createCus.setFont(new Font("Century Gothic", Font.BOLD, 14));
		createCus.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		createCus.setBackground(new Color(97, 212, 195));
		createCus.setBounds(241, 168, 199, 45);
		initailframe.getContentPane().add(createCus);
		
		JButton quitbtn = new JButton("Quit");
		quitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initailframe.dispose();
			}
		});
		quitbtn.setForeground(Color.WHITE);
		quitbtn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		quitbtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		quitbtn.setBackground(new Color(97, 212, 195));
		quitbtn.setBounds(489, 251, 67, 19);
		initailframe.getContentPane().add(quitbtn);
		
		JMenuBar menuBar = new JMenuBar();
		initailframe.setJMenuBar(menuBar);
		
		JMenu nutriMenu = new JMenu("Nutritionist Menu");
		menuBar.add(nutriMenu);
		
		changePassNut2 = new JMenuItem("Change Password");
		nutriMenu.add(changePassNut2);
		
		JMenu adminMenu = new JMenu("Admin Menu");
		menuBar.add(adminMenu);
		
		JMenuItem resetPassNut1 = new JMenuItem("Reset Password Nutritionist");
		adminMenu.add(resetPassNut1);
		
		JMenuItem createNut = new JMenuItem("Create Nutritionist");
		createNut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new CreateNutritionistWin();
			}
		});
		adminMenu.add(createNut);
		
		JMenuItem moveCus = new JMenuItem("Move Customer");
		adminMenu.add(moveCus);
		
		initailframe.setVisible(true);
		initailframe.setSize(new Dimension(621, 351));
		initailframe.setLocationRelativeTo(null);
	}		
		
	private static boolean customerFilter(Customer cust, String textToFilter) {
        if (textToFilter.isEmpty()) {
            return true;
        }
        return CustomComboRenderer.getCustomerDisplayText(cust).toLowerCase()
                                  .contains(textToFilter.toLowerCase());
    }

}
