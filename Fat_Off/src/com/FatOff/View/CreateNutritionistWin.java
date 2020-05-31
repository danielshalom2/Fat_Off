package com.FatOff.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.FatOff.Controller.NutritionistController;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateNutritionistWin {
	private JPasswordField passConfirmField;
	private JPasswordField passField;
	private JTextField licenseIdField;
	private JTextField idField;
	private JTextField emailAddrField;
	private JTextField phoneNumField;
	private JTextField lNameField;
	private JTextField fNameField;
	private JTextField mailAppPassField;

	public CreateNutritionistWin() {
		JFrame nutritionistCrtFrame = new JFrame("Nutritionist Creation");
		nutritionistCrtFrame.getContentPane().setBackground(new Color(36, 47, 65));
		nutritionistCrtFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel formPanel = new JPanel();
		formPanel.setBackground(new Color(36, 47, 65));
		formPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));

		JLabel copyRightLbl = new JLabel("All Rights Reserved\u00A9 Fat Off Developers 2020");
		copyRightLbl.setBackground(new Color(36, 47, 65));
		copyRightLbl.setForeground(new Color(255, 255, 255));
		copyRightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		copyRightLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(nutritionistCrtFrame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(formPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addGap(131)
						.addComponent(copyRightLbl, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE).addGap(105)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(formPanel, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(copyRightLbl, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)));

		JLabel logoLbl = new JLabel("");
		logoLbl.setBounds(11, 11, 121, 191);
		logoLbl.setIcon(new ImageIcon(
				CreateNutritionistWin.class.getResource("/com/FatOff/View/fat_off_white.png")));

		JLabel fNameLbl = new JLabel("First Name: ");
		fNameLbl.setForeground(new Color(255, 255, 255));
		fNameLbl.setBounds(128, 57, 143, 17);
		fNameLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		JLabel lNameLbl = new JLabel("Last Name: ");
		lNameLbl.setForeground(new Color(255, 255, 255));
		lNameLbl.setBounds(128, 84, 143, 17);
		lNameLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		JLabel phoneNumLbl = new JLabel("Phone Number:");
		phoneNumLbl.setForeground(new Color(255, 255, 255));
		phoneNumLbl.setBounds(130, 123, 141, 17);
		phoneNumLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		JLabel emailAddrLbl = new JLabel("Email Address:");
		emailAddrLbl.setForeground(new Color(255, 255, 255));
		emailAddrLbl.setBounds(130, 157, 141, 17);
		emailAddrLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		JLabel idLbl = new JLabel("ID:");
		idLbl.setForeground(new Color(255, 255, 255));
		idLbl.setBounds(130, 221, 141, 17);
		idLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		JLabel headerLbl = new JLabel("Welcome to Fat-Off nutritionist creation");
		headerLbl.setForeground(new Color(255, 255, 255));
		headerLbl.setBounds(172, 11, 315, 17);
		headerLbl.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));

		JLabel licenseIdLbl = new JLabel("License ID:");
		licenseIdLbl.setForeground(new Color(255, 255, 255));
		licenseIdLbl.setBounds(130, 248, 141, 17);
		licenseIdLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		JLabel passLbl = new JLabel("Password: ");
		passLbl.setForeground(new Color(255, 255, 255));
		passLbl.setBounds(130, 306, 141, 17);
		passLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		JLabel passConfirmLbl = new JLabel("Confirm Password: ");
		passConfirmLbl.setForeground(new Color(255, 255, 255));
		passConfirmLbl.setBounds(130, 332, 141, 17);
		passConfirmLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		JLabel idWarnLbl = new JLabel("");
		idWarnLbl.setBounds(310, 273, 230, 0);
		idWarnLbl.setForeground(Color.RED);
		idWarnLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 9));

		JLabel phoneWarnLbl = new JLabel("");
		phoneWarnLbl.setBounds(310, 148, 230, 0);
		phoneWarnLbl.setForeground(Color.RED);
		phoneWarnLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		
		mailAppPassField = new JTextField();
		mailAppPassField.setBounds(264, 279, 276, 19);
		mailAppPassField.setColumns(10);
		
		JLabel mailAppPassLbl = new JLabel("Mail App Pass:");
		mailAppPassLbl.setForeground(new Color(255, 255, 255));
		mailAppPassLbl.setBounds(130, 275, 141, 17);
		mailAppPassLbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		passConfirmField = new JPasswordField();
		passConfirmField.setBounds(264, 332, 276, 19);

		passField = new JPasswordField();
		passField.setBounds(264, 306, 276, 19);

		licenseIdField = new JTextField();
		licenseIdField.setBounds(264, 248, 276, 19);
		licenseIdField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = licenseIdField.getText();
				int l = value.length();
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b') {
					licenseIdField.setEditable(true);
					idWarnLbl.setText("");
				} else {
					licenseIdField.setEditable(false);
					idWarnLbl.setText("* Enter only numeric digits(0-9)");
				}
			}
		});
		licenseIdField.setColumns(10);

		idField = new JTextField();
		idField.setBounds(264, 216, 276, 19);
		idField.setColumns(10);

		emailAddrField = new JTextField();
		emailAddrField.setBounds(264, 157, 276, 19);
		emailAddrField.setColumns(10);

		phoneNumField = new JTextField();
		phoneNumField.setBounds(264, 123, 276, 19);
		phoneNumField.setColumns(10);
		phoneNumField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = phoneNumField.getText();
				int l = value.length();
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b') {
					phoneNumField.setEditable(true);
					phoneWarnLbl.setText("");
				} else {
					phoneNumField.setEditable(false);
					phoneWarnLbl.setText("* Enter only numeric digits(0-9)");
				}
			}
		});

		lNameField = new JTextField();
		lNameField.setBounds(264, 90, 276, 19);
		lNameField.setColumns(10);

		fNameField = new JTextField();
		fNameField.setBounds(264, 57, 276, 19);
		fNameField.setColumns(10);

		JButton clearBtn = new JButton("Clear");
		clearBtn.setForeground(new Color(255, 255, 255));
		clearBtn.setBackground(new Color(97, 212, 195));
		clearBtn.setBorder(null);
		clearBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		clearBtn.setBounds(171, 357, 77, 30);
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fNameField.setText("");
				lNameField.setText("");
				phoneNumField.setText("");
				emailAddrField.setText("");
				idField.setText("");
				licenseIdField.setText("");
				passField.setText("");
				passConfirmField.setText("");
				mailAppPassField.setText("");
			}
		});

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(375, 357, 77, 30);
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		cancelBtn.setBorder(null);
		cancelBtn.setBackground(new Color(97, 212, 195));
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nutritionistCrtFrame.dispose();
			}
		});

		JButton createBtn = new JButton("Create");
		createBtn.setBounds(462, 357, 77, 30);
		createBtn.setBackground(new Color(97, 212, 195));
		createBtn.setBorder(null);
		createBtn.setForeground(new Color(255, 255, 255));
		createBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		createBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fNameField.getText().equals("") || lNameField.getText().equals("") || phoneNumField.getText().equals("")
						|| emailAddrField.getText().equals("") || idField.getText().equals("") || licenseIdField.getText().equals("")
						|| mailAppPassField.getText().equals("")
						|| passField.getPassword().length == 0 || passConfirmField.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "All the fields are required for nutritionist creation!");
				} 
				else if(!new String(passField.getPassword()).equals(new String(passConfirmField.getPassword()))) {
					JOptionPane.showMessageDialog(null, "The password confirmation does not match");
					passField.setText("");
					passConfirmField.setText("");
				}
				else {
					if(NutritionistController.createNutritionist(fNameField.getText(), lNameField.getText(), phoneNumField.getText(), 
							emailAddrField.getText(), idField.getText(), Integer.parseInt(licenseIdField.getText()), 
							mailAppPassField.getText(), new String(passField.getPassword()))) {
						JOptionPane.showMessageDialog(null, "Nutritionist was created succesfully");
						nutritionistCrtFrame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Nutritionist Creation Failed");
					}
				}
			}
		});
		formPanel.setLayout(null);
		formPanel.add(logoLbl);
		formPanel.add(licenseIdLbl);
		formPanel.add(phoneNumLbl);
		formPanel.add(lNameLbl);
		formPanel.add(clearBtn);
		formPanel.add(fNameLbl);
		formPanel.add(emailAddrLbl);
		formPanel.add(idLbl);
		formPanel.add(mailAppPassLbl);
		formPanel.add(cancelBtn);
		formPanel.add(createBtn);
		formPanel.add(idWarnLbl);
		formPanel.add(lNameField);
		formPanel.add(emailAddrField);
		formPanel.add(licenseIdField);
		formPanel.add(idField);
		formPanel.add(phoneWarnLbl);
		formPanel.add(phoneNumField);
		formPanel.add(mailAppPassField);
		formPanel.add(fNameField);
		formPanel.add(headerLbl);
		formPanel.add(passConfirmLbl);
		formPanel.add(passLbl);
		formPanel.add(passField);
		formPanel.add(passConfirmField);
		nutritionistCrtFrame.getContentPane().setLayout(groupLayout);
		nutritionistCrtFrame.setVisible(true);
		nutritionistCrtFrame.pack();
	}
}
