/**
 * 
 */
package com.FatOff.View;

import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import com.FatOff.Controller.CustomerController;
import com.FatOff.Model.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Fat Off development team
 *
 */
public class CreateCustomerWin {
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField idField;

	public CreateCustomerWin(String path, Object nut) {
		JFrame customerCrtFrame = new JFrame("Customer Creation");
		customerCrtFrame.setResizable(false);
		customerCrtFrame.getContentPane().setBackground(new Color(36, 47, 65));
		customerCrtFrame.setBackground(new Color(36, 47, 65));
		customerCrtFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		/////////////////////////////// set icon //////////////////////////////////
		ImageIcon icon = new ImageIcon("src/com/FatOff/View/IconFatOff.PNG");
		customerCrtFrame.setIconImage(icon.getImage());
		//////////////////////////////////////////////////////////////////////////

		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 47, 65));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));

		JLabel copyRightLbl = new JLabel("All Rights Reserved© Fat Off Developers 2020");
		copyRightLbl.setForeground(new Color(255, 255, 255));
		copyRightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		copyRightLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(customerCrtFrame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(100)
						.addComponent(copyRightLbl, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE).addGap(105))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(copyRightLbl).addContainerGap()));

		JLabel logoLbl = new JLabel("");
		logoLbl.setBounds(6, 7, 128, 180);
		logoLbl.setIcon(new ImageIcon(CreateCustomerWin.class.getResource("/com/FatOff/View/fat_off_white.png")));

		JLabel lblWelcomeToFatoff = new JLabel("Fat-Off customer creation");
		lblWelcomeToFatoff.setForeground(new Color(255, 255, 255));
		lblWelcomeToFatoff.setBounds(218, 7, 222, 17);
		lblWelcomeToFatoff.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));

		JLabel firstNameLbl = new JLabel("First Name:");
		firstNameLbl.setForeground(new Color(255, 255, 255));
		firstNameLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		firstNameLbl.setBounds(139, 69, 79, 13);

		JLabel lastNameLbl = new JLabel("Last Name:");
		lastNameLbl.setForeground(new Color(255, 255, 255));
		lastNameLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lastNameLbl.setBounds(139, 98, 79, 13);

		JLabel emailLbl = new JLabel("Email:");
		emailLbl.setForeground(new Color(255, 255, 255));
		emailLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		emailLbl.setBounds(139, 158, 79, 13);

		JLabel phoneLbl = new JLabel("Phone:");
		phoneLbl.setForeground(new Color(255, 255, 255));
		phoneLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		phoneLbl.setBounds(139, 127, 79, 13);

		JLabel idLbl = new JLabel("ID:");
		idLbl.setForeground(new Color(255, 255, 255));
		idLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		idLbl.setBounds(139, 190, 79, 13);

		JLabel genderLbl = new JLabel("Gender:");
		genderLbl.setForeground(new Color(255, 255, 255));
		genderLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		genderLbl.setBounds(139, 268, 63, 13);

		JLabel phoneWarnLbl = new JLabel("");
		phoneWarnLbl.setBounds(211, 152, 229, 20);
		phoneWarnLbl.setForeground(Color.RED);
		phoneWarnLbl.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		panel.add(phoneWarnLbl);

		JLabel idWarnLbl = new JLabel("");
		idWarnLbl.setForeground(Color.RED);
		idWarnLbl.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		idWarnLbl.setBounds(211, 210, 229, 20);
		panel.add(idWarnLbl);

		Properties props = new Properties();
		props.put("text.today", "Today");
		props.put("text.month", "Month");
		props.put("text.year", "Year");

		UtilDateModel dateModel = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, props);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (((Date) datePicker.getModel().getValue()).compareTo(new Date()) >= 0) {
					JOptionPane.showMessageDialog(null, "Invalid date selected ");
					datePicker.getModel().setValue(null);
					datePicker.getModel().setSelected(false);
				}
			}
		});

		datePicker.getJFormattedTextField().setHorizontalAlignment(SwingConstants.CENTER);
		datePicker.setButtonFocusable(false);
		datePicker.setDoubleClickAction(false);
		datePicker.setTextEditable(false);
		datePicker.setShowYearButtons(true);
		datePicker.setBackground(Color.WHITE);
		datePicker.setBounds(239, 224, 150, 27);

		firstNameField = new JTextField();
		firstNameField.setCaretColor(Color.WHITE);
		firstNameField.setBorder(null);
		firstNameField.setBackground(new Color(36, 47, 65));
		firstNameField.setForeground(new Color(255, 255, 255));
		firstNameField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		firstNameField.setBounds(211, 63, 229, 19);
		firstNameField.setColumns(10);

		lastNameField = new JTextField();
		lastNameField.setCaretColor(Color.WHITE);
		lastNameField.setBorder(null);
		lastNameField.setBackground(new Color(36, 47, 65));
		lastNameField.setForeground(new Color(255, 255, 255));
		lastNameField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lastNameField.setBounds(211, 92, 229, 19);
		lastNameField.setColumns(10);

		phoneField = new JTextField();
		phoneField.setCaretColor(Color.WHITE);
		phoneField.setBorder(null);
		phoneField.setBackground(new Color(36, 47, 65));
		phoneField.setForeground(new Color(255, 255, 255));
		phoneField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		phoneField.setBounds(211, 125, 229, 19);
		phoneField.setColumns(10);
		phoneField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b') {
					phoneField.setEditable(true);
					phoneWarnLbl.setText("");
				} else {
					phoneField.setEditable(false);
					phoneWarnLbl.setText("* Enter only numeric digits(0-9)");
				}
			}
		});

		emailField = new JTextField();
		emailField.setCaretColor(Color.WHITE);
		emailField.setBorder(null);
		emailField.setBackground(new Color(36, 47, 65));
		emailField.setForeground(new Color(255, 255, 255));
		emailField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		emailField.setBounds(211, 150, 229, 19);
		emailField.setColumns(10);

		idField = new JTextField();
		idField.setCaretColor(Color.WHITE);
		idField.setBorder(null);
		idField.setBackground(new Color(36, 47, 65));
		idField.setForeground(new Color(255, 255, 255));
		idField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		idField.setBounds(211, 184, 229, 19);
		idField.setColumns(10);
		idField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b')
						&& idField.getText().length() < 9) {
					idField.setEditable(true);
					idWarnLbl.setText("");
				} else {
					idField.setEditable(false);
					idWarnLbl.setText("ID must contain exactly 9 numeric characters!");
				}

			}
		});

		ButtonGroup radios = new ButtonGroup();
		JRadioButton maleRadio = new JRadioButton("Male");
		maleRadio.setForeground(new Color(255, 255, 255));
		maleRadio.setBackground(new Color(36, 47, 65));
		maleRadio.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		maleRadio.setBounds(211, 263, 63, 21);
		JRadioButton femaleRadio = new JRadioButton("Female");
		femaleRadio.setForeground(new Color(255, 255, 255));
		femaleRadio.setBackground(new Color(36, 47, 65));
		femaleRadio.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		femaleRadio.setBounds(271, 263, 84, 21);

		radios.add(maleRadio);
		radios.add(femaleRadio);

		JButton clearBtn = new JButton("Clear");
		clearBtn.setBounds(139, 296, 63, 21);
		clearBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		clearBtn.setBackground(new Color(97, 212, 195));
		clearBtn.setForeground(new Color(255, 255, 255));
		clearBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNameField.setText("");
				lastNameField.setText("");
				phoneField.setText("");
				phoneField.setEditable(true);
				emailField.setText("");
				idField.setText("");
				idField.setEditable(true);
				radios.clearSelection();
			}
		});

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setBackground(new Color(97, 212, 195));
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		cancelBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		cancelBtn.setBounds(239, 296, 79, 21);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerCrtFrame.dispose();
			}
		});

		JButton createBtn = new JButton("Create");
		createBtn.setBackground(new Color(97, 212, 195));
		createBtn.setForeground(new Color(255, 255, 255));
		createBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		createBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		createBtn.setBounds(328, 296, 79, 21);
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstNameField.getText().equals("") || lastNameField.getText().contentEquals("")
						|| phoneField.getText().contentEquals("") || idField.getText().contentEquals("")
						|| emailField.getText().contentEquals("") || radios.getSelection() == null
						|| datePicker.getModel().isSelected() == false) {
					JOptionPane.showMessageDialog(null, "All Fileds are required for customer creation!");
				} else if (idField.getText().length() != 9) {
					JOptionPane.showMessageDialog(null, "ID must contain exactly 9 numeric characters!");
				} else {
					String pathToCust = path + "/" + ((Nutritionist) nut).getFirstName() + "_"
							+ ((Nutritionist) nut).getLastName() + "_" + ((Nutritionist) nut).getId();
					Customer cust = CustomerController.createCustomer(firstNameField.getText(), lastNameField.getText(),
							phoneField.getText(), emailField.getText(), idField.getText(),
							(Date) datePicker.getModel().getValue(), getSelectedButtonText(radios),
							pathToCust + "/Customers");

					((Nutritionist) nut).addCustomer(cust);
					new InterviewWin(cust, pathToCust, (Nutritionist) nut);
					customerCrtFrame.dispose();
				}
			}
		});
		panel.setLayout(null);

		panel.add(logoLbl);
		panel.add(lblWelcomeToFatoff);
		panel.add(firstNameLbl);
		panel.add(lastNameLbl);
		panel.add(phoneLbl);
		panel.add(idLbl);
		panel.add(genderLbl);
		panel.add(firstNameField);
		panel.add(lastNameField);
		panel.add(emailField);
		panel.add(idField);
		panel.add(phoneField);
		panel.add(datePicker);
		panel.add(maleRadio);
		panel.add(femaleRadio);
		panel.add(emailLbl);
		panel.add(clearBtn);
		panel.add(cancelBtn);
		panel.add(createBtn);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(211, 82, 229, 27);
		panel.add(separator_2);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(Color.WHITE);
		separator_2_1.setBounds(211, 113, 229, 27);
		panel.add(separator_2_1);

		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setForeground(Color.WHITE);
		separator_2_2.setBounds(211, 144, 229, 27);
		panel.add(separator_2_2);

		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setForeground(Color.WHITE);
		separator_2_3.setBounds(211, 173, 229, 27);
		panel.add(separator_2_3);

		JSeparator separator_2_4 = new JSeparator();
		separator_2_4.setInheritsPopupMenu(true);
		separator_2_4.setForeground(Color.WHITE);
		separator_2_4.setBounds(211, 204, 229, 12);
		panel.add(separator_2_4);

		customerCrtFrame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("Date Of Birth:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel.setBounds(139, 226, 94, 16);
		panel.add(lblNewLabel);
		customerCrtFrame.setSize(new Dimension(557, 392));
		customerCrtFrame.setVisible(true);
		customerCrtFrame.setLocationRelativeTo(null);

	}

	String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = (AbstractButton) buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}
	//
}
