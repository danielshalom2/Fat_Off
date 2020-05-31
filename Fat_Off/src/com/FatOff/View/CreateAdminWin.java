package com.FatOff.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import com.FatOff.Controller.AdminController;


public class CreateAdminWin {
	private JPasswordField passConfirmField;
	private JPasswordField passField;
	private JTextField licenseIdField;
	private JTextField idField;
	private JTextField emailAddrField;
	private JTextField phoneNumField;
	private JTextField lNameField;
	private JTextField fNameField;
	private JTextField mailAppPassField;

	public CreateAdminWin() {
		JFrame adminCrtFrame = new JFrame("Admin Creation");
		adminCrtFrame.getContentPane().setBackground(new Color(36, 47, 65));
		adminCrtFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel formPanel = new JPanel();
		formPanel.setBackground(new Color(36, 47, 65));
		formPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));

		JLabel copyRightLbl = new JLabel("All Rights Reserved\u00A9 Fat Off Developers 2020");
		copyRightLbl.setForeground(new Color(255, 255, 255));
		copyRightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		copyRightLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(adminCrtFrame.getContentPane());
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
				CreateAdminWin.class.getResource("/com/FatOff/View/fat_off_white.png")));

		JLabel fNameLbl = new JLabel("First Name: ");
		fNameLbl.setForeground(new Color(255, 255, 255));
		fNameLbl.setBounds(131, 38, 122, 19);
		fNameLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel lNameLbl = new JLabel("Last Name: ");
		lNameLbl.setForeground(new Color(255, 255, 255));
		lNameLbl.setBounds(131, 67, 122, 19);
		lNameLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel phoneNumLbl = new JLabel("Phone Number:");
		phoneNumLbl.setForeground(new Color(255, 255, 255));
		phoneNumLbl.setBounds(131, 98, 122, 19);
		phoneNumLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel emailAddrLbl = new JLabel("Email Address:");
		emailAddrLbl.setForeground(new Color(255, 255, 255));
		emailAddrLbl.setBounds(131, 127, 122, 19);
		emailAddrLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel idLbl = new JLabel("ID:");
		idLbl.setForeground(new Color(255, 255, 255));
		idLbl.setBounds(131, 156, 122, 19);
		idLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel headerLbl = new JLabel("Welcome to Fat-Off admin creation");
		headerLbl.setForeground(new Color(255, 255, 255));
		headerLbl.setBounds(172, 11, 305, 17);
		headerLbl.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));

		JLabel licenseIdLbl = new JLabel("License ID:");
		licenseIdLbl.setForeground(new Color(255, 255, 255));
		licenseIdLbl.setBounds(131, 183, 122, 19);
		licenseIdLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel passLbl = new JLabel("Password: ");
		passLbl.setForeground(new Color(255, 255, 255));
		passLbl.setBounds(131, 239, 122, 19);
		passLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel passConfirmLbl = new JLabel("Confirm Password: ");
		passConfirmLbl.setForeground(new Color(255, 255, 255));
		passConfirmLbl.setBounds(131, 273, 122, 19);
		passConfirmLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel idWarnLbl = new JLabel("");
		idWarnLbl.setBounds(253, 273, 230, 0);
		idWarnLbl.setForeground(Color.RED);
		idWarnLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 9));

		JLabel phoneWarnLbl = new JLabel("");
		phoneWarnLbl.setBounds(247, 148, 230, 0);
		phoneWarnLbl.setForeground(Color.RED);
		phoneWarnLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		
		mailAppPassField = new JTextField();
		mailAppPassField.setBounds(263, 212, 277, 19);
		mailAppPassField.setColumns(10);
		
		JLabel mailAppPassLbl = new JLabel("Mail App Pass:");
		mailAppPassLbl.setForeground(new Color(255, 255, 255));
		mailAppPassLbl.setBounds(131, 212, 122, 17);
		mailAppPassLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		passConfirmField = new JPasswordField();
		passConfirmField.setBounds(263, 270, 277, 19);

		passField = new JPasswordField();
		passField.setBounds(263, 241, 277, 19);

		licenseIdField = new JTextField();
		licenseIdField.setBounds(263, 184, 277, 19);
		licenseIdField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
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
		idField.setBounds(263, 157, 277, 19);
		idField.setColumns(10);

		emailAddrField = new JTextField();
		emailAddrField.setBounds(263, 128, 277, 19);
		emailAddrField.setColumns(10);

		phoneNumField = new JTextField();
		phoneNumField.setBounds(263, 99, 277, 19);
		phoneNumField.setColumns(10);
		phoneNumField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
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
		lNameField.setBounds(263, 69, 277, 19);
		lNameField.setColumns(10);

		fNameField = new JTextField();
		fNameField.setBounds(263, 39, 277, 19);
		fNameField.setColumns(10);

		JButton clearBtn = new JButton("Clear");
		clearBtn.setForeground(new Color(255, 255, 255));
		clearBtn.setBackground(new Color(97, 212, 195));
		clearBtn.setBorder(null);
		clearBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		clearBtn.setBounds(150, 348, 77, 30);
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
		
		cancelBtn.setBounds(369, 348, 77, 30);
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		cancelBtn.setBorder(null);
		cancelBtn.setBackground(new Color(97, 212, 195));
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminCrtFrame.dispose();
			}
		});

		JButton createBtn = new JButton("Create");
		createBtn.setBackground(new Color(97, 212, 195));
		createBtn.setBorder(null);
		createBtn.setForeground(new Color(255, 255, 255));
		createBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		createBtn.setBounds(452, 348, 77, 30);
		createBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fNameField.getText().equals("") || lNameField.getText().equals("") || phoneNumField.getText().equals("")
						|| emailAddrField.getText().equals("") || idField.getText().equals("") || licenseIdField.getText().equals("")
						|| mailAppPassField.getText().equals("")
						|| passField.getPassword().length == 0 || passConfirmField.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "All the fields are required for admin creation!");
				} 
				else if(!new String(passField.getPassword()).equals(new String(passConfirmField.getPassword()))) {
					JOptionPane.showMessageDialog(null, "The password confirmation does not match");
					passField.setText("");
					passConfirmField.setText("");
				}
				else {
					if(AdminController.createAdmin(fNameField.getText(), lNameField.getText(), phoneNumField.getText(), 
							emailAddrField.getText(), idField.getText(), Integer.parseInt(licenseIdField.getText()), 
							mailAppPassField.getText(), new String(passField.getPassword()))) {
						JOptionPane.showMessageDialog(null, "Admin was created succesfully");
						new SignInWin();
						adminCrtFrame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Admin Creation Failed");
					}
				}
			}
		});
		formPanel.setLayout(null);
		formPanel.add(logoLbl);
		formPanel.add(headerLbl);
		formPanel.add(phoneNumLbl);
		formPanel.add(lNameLbl);
		formPanel.add(licenseIdLbl);
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
		formPanel.add(passConfirmLbl);
		formPanel.add(passLbl);
		formPanel.add(passField);
		formPanel.add(passConfirmField);
		adminCrtFrame.getContentPane().setLayout(groupLayout);
		adminCrtFrame.setVisible(true);
		adminCrtFrame.pack();
	}
}
