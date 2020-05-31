package com.FatOff.View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;

import com.FatOff.Model.Admin;
import com.FatOff.Model.Customer;
import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.SaveRestore;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JSeparator;

public class MainWin {

	public MainWin(Object nut, String type) {
		// TODO Auto-generated constructor stub
		JFrame newFrame = new JFrame("Fat Off");
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setForeground(new Color(255, 255, 255));
		mainPanel.setBackground(new Color(36, 47, 65));

		newFrame.setBackground(new Color(36, 47, 65));

		JPanel sessionDataPanel = new JPanel();
		sessionDataPanel.setForeground(new Color(255, 255, 255));
		sessionDataPanel.setBackground(new Color(36, 47, 65));
		sessionDataPanel.setBounds(131, 0, 762, 87);
		sessionDataPanel.setFont(new Font("Centory Gothic", Font.BOLD, 10));
		sessionDataPanel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Session Data",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));

		JLabel diaticianNameLbl = new JLabel("Dietician Name:");
		diaticianNameLbl.setForeground(new Color(255, 255, 255));
		diaticianNameLbl.setBackground(new Color(36, 47, 65));
		diaticianNameLbl.setFont(new Font("Century Gothic", Font.BOLD, 13));
		diaticianNameLbl.setBounds(15, 27, 114, 21);

		JLabel customerNameLbl = new JLabel("Customer name:");
		customerNameLbl.setForeground(new Color(255, 255, 255));
		customerNameLbl.setBackground(new Color(36, 47, 65));
		customerNameLbl.setFont(new Font("Century Gothic", Font.BOLD, 13));
		customerNameLbl.setBounds(15, 61, 114, 14);

		JTextPane dieticianNameTxtPane = new JTextPane();
		dieticianNameTxtPane.setBounds(122, 20, 155, 21);
		dieticianNameTxtPane.setBackground(new Color(36, 47, 65));
		dieticianNameTxtPane.setEditable(false);

		JTextPane customerNameTxtPane = new JTextPane();
		customerNameTxtPane.setBounds(122, 52, 155, 23);
		customerNameTxtPane.setBackground(new Color(36, 47, 65));
		customerNameTxtPane.setEditable(false);

		JLabel dateLbl = new JLabel("Date:");
		dateLbl.setForeground(new Color(255, 255, 255));
		dateLbl.setBackground(new Color(36, 47, 65));
		dateLbl.setFont(new Font("Century Gothic", Font.BOLD, 13));
		dateLbl.setBounds(292, 27, 53, 21);

		JLabel sessionNumLbl = new JLabel("Session:");
		sessionNumLbl.setForeground(new Color(255, 255, 255));
		sessionNumLbl.setBackground(new Color(36, 47, 65));
		sessionNumLbl.setFont(new Font("Century Gothic", Font.BOLD, 13));
		sessionNumLbl.setBounds(287, 58, 53, 21);

		JTextPane dateTxtPane = new JTextPane();
		dateTxtPane.setBounds(333, 20, 155, 21);
		dateTxtPane.setBackground(new Color(36, 47, 65));
		dateTxtPane.setEditable(false);

		JTextPane sessionNumTxtPane = new JTextPane();
		sessionNumTxtPane.setBounds(343, 52, 139, 14);
		sessionNumTxtPane.setBackground(new Color(36, 47, 65));
		sessionNumTxtPane.setEditable(false);

		JLabel bmiLbl = new JLabel("BMI :");
		bmiLbl.setForeground(new Color(255, 255, 255));
		bmiLbl.setBackground(new Color(36, 47, 65));
		bmiLbl.setFont(new Font("Century Gothic", Font.BOLD, 13));
		bmiLbl.setBounds(506, 27, 32, 21);

		JLabel eerLbl = new JLabel("EER :");
		eerLbl.setForeground(new Color(255, 255, 255));
		eerLbl.setBackground(new Color(36, 47, 65));
		eerLbl.setFont(new Font("Century Gothic", Font.BOLD, 13));
		eerLbl.setBounds(506, 54, 32, 21);

		JTextPane bmiTxtPane = new JTextPane();
		bmiTxtPane.setBounds(542, 27, 82, 6);
		bmiTxtPane.setBackground(new Color(36, 47, 65));
		bmiTxtPane.setEditable(false);

		JTextPane eerTxtPane = new JTextPane();
		eerTxtPane.setBounds(542, 69, 82, 6);
		eerTxtPane.setBackground(new Color(36, 47, 65));
		eerTxtPane.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(newFrame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup()
						.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 900, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		newFrame.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		newFrame.setJMenuBar(menuBar);

		JMenu menuMenuItem = new JMenu("Menu");
		menuBar.add(menuMenuItem);

		JMenuItem createCustomerMenuItem = new JMenuItem("Create customer");
		createCustomerMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (type.equals("Admin")) {
					new CreateCustomerWin(SaveRestore.getPath() + "/Admin", (Admin) nut);
				} else {
					new CreateCustomerWin(SaveRestore.getPath() + "/Dieticions", (Nutritionist) nut);
				}
			}
		});
		menuMenuItem.add(createCustomerMenuItem);

		JMenuItem openCustomerMenuItem = new JMenuItem("Open customer");
		openCustomerMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JComboBox<Customer> comboBox = new JComboBox<>(((Nutritionist) nut).getCustomersList()
						.toArray(new Customer[((Nutritionist) nut).getCustomersList().size()]));
				CustomerSearchDecorator<Customer> decorate = CustomerSearchDecorator.decorate(comboBox,
						MainWin::customerFilter);
				comboBox.setRenderer(new CustomComboRenderer(decorate.getFilterLabel()));

				JPanel panel = new JPanel();
				panel.add(comboBox);

				JFrame frame = new JFrame("JComboBox Filter Example");
				// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(new Dimension(600, 300));
				frame.getContentPane().add(panel);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
				comboBox.addActionListener(new java.awt.event.ActionListener() {
				    public void actionPerformed(java.awt.event.ActionEvent evt) {
				    	
				    	Customer temp = (Customer) comboBox.getSelectedItem();
						System.out.println(temp.getFirstName());
						frame.setVisible(false);
				    }
				});
			}
		});
		menuMenuItem.add(openCustomerMenuItem);

		JMenu customerMenu = new JMenu("Customer");
		menuBar.add(customerMenu);

		JMenuItem openIntroMeeting = new JMenuItem("Open introductory summary");
		customerMenu.add(openIntroMeeting);

		JMenuItem prevSumMenuItem = new JMenuItem("Open summary of previous meeting");
		customerMenu.add(prevSumMenuItem);

		JMenu menuAdminItem = new JMenu("Admin");
		menuBar.add(menuAdminItem);
		menuAdminItem.setVisible(false);

		JMenuItem addDieticion = new JMenuItem("Add Dieticion");
		menuAdminItem.add(addDieticion);
		addDieticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateNutritionistWin();
			}
		});

		JMenuItem removeDieticion = new JMenuItem("Remove Dieticion");
		menuAdminItem.add(removeDieticion);
		JMenuItem moveCustomer = new JMenuItem("Move Customer");
		menuAdminItem.add(moveCustomer);

		if (type.equals("Admin")) // decide if to show the Admin menu
			menuAdminItem.setVisible(true);

		JMenuItem helpMenuItem = new JMenuItem("Help");
		helpMenuItem.setHorizontalAlignment(SwingConstants.TRAILING);
		helpMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		helpMenuItem.setPreferredSize(new Dimension(10, 0));
		menuBar.add(helpMenuItem);

		newFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.add(sessionDataPanel);
		sessionDataPanel.setLayout(null);
		sessionDataPanel.add(diaticianNameLbl);
		sessionDataPanel.add(customerNameLbl);
		sessionDataPanel.add(customerNameTxtPane);
		sessionDataPanel.add(dieticianNameTxtPane);
		sessionDataPanel.add(dateLbl);
		sessionDataPanel.add(sessionNumLbl);
		sessionDataPanel.add(sessionNumTxtPane);
		sessionDataPanel.add(dateTxtPane);
		sessionDataPanel.add(bmiLbl);
		sessionDataPanel.add(bmiTxtPane);
		sessionDataPanel.add(eerLbl);
		sessionDataPanel.add(eerTxtPane);

		JSeparator separator = new JSeparator();
		separator.setBounds(122, 42, 155, 6);
		sessionDataPanel.add(separator);
		JLabel Logolbl = new JLabel("");
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(333, 44, 155, 6);
		sessionDataPanel.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(122, 76, 155, 6);
		sessionDataPanel.add(separator_2);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(Color.WHITE);
		separator_2_1.setBounds(343, 77, 145, 6);
		sessionDataPanel.add(separator_2_1);

		Logolbl.setIcon(new ImageIcon(MainWin.class.getResource("/com/FatOff/View/fat_off_no_bc.pnggnd.png")));
		Logolbl.setForeground(Color.WHITE);
		Logolbl.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Logolbl.setBounds(0, 0, 133, 199);
		mainPanel.add(Logolbl);
		newFrame.pack();
		newFrame.setVisible(true);
	}

	private static boolean customerFilter(Customer cust, String textToFilter) {
		if (textToFilter.isEmpty()) {
			return true;
		}
		return CustomComboRenderer.getCustomerDisplayText(cust).toLowerCase().contains(textToFilter.toLowerCase());
	}
}
