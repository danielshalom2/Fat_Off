package com.FatOff.View;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import com.FatOff.Controller.AdminController;
import com.FatOff.Model.Admin;
import com.FatOff.Model.Customer;
import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.Person;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;



public class MoveCustomerWin {
	
	public MoveCustomerWin (Admin adm) throws IOException {
		
		JFrame moveFrame = new JFrame("Assign Customer");
		moveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 47, 65));
		GroupLayout groupLayout = new GroupLayout(moveFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 728, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE)
					.addContainerGap())
		);

		moveFrame.getContentPane().setLayout(groupLayout);
		
		JLabel srcNutSelectLbl = new JLabel("Pick source a dietician:");
		srcNutSelectLbl.setFont(new Font("Dialog", Font.PLAIN, 13));
		srcNutSelectLbl.setForeground(Color.WHITE);

		// Nutritionist Combo Box Model
		List<Nutritionist> nuts = AdminController.getNutsList();
		nuts.add(adm);
		DefaultComboBoxModel<Nutritionist> nutsComboModel = new DefaultComboBoxModel<Nutritionist>(nuts.toArray(new Nutritionist[nuts.size()]));

		// Source Nut Combo Box
		JComboBox<Nutritionist> srcNutsComboBox = new JComboBox<>(nutsComboModel);
		CustomerSearchDecorator<Nutritionist> srcNutDecorate = CustomerSearchDecorator.decorate(srcNutsComboBox,MoveCustomerWin::nutFilter);
        srcNutsComboBox.setRenderer(new CustomComboRenderer(srcNutDecorate.getFilterLabel()));
		
		JLabel custToMoveLbl = new JLabel("Pick a customer to assign:");
		custToMoveLbl.setForeground(Color.WHITE);
		custToMoveLbl.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		// Customer Combo Box Model
		List<Customer> custs = ((Nutritionist)srcNutsComboBox.getSelectedItem()).getCustomersList();
		DefaultComboBoxModel<Customer> custComboModel = new DefaultComboBoxModel<Customer>(custs.toArray(new Customer[custs.size()]));
		
		// Source Nut Combo Box
		JComboBox<Customer> custComboBox = new JComboBox<>(custComboModel);
		CustomerSearchDecorator<Customer> custDecorate = CustomerSearchDecorator.decorate(custComboBox,MoveCustomerWin::nutFilter);
		custComboBox.setRenderer(new CustomComboRenderer(custDecorate.getFilterLabel()));
		
		JLabel lblPickDieticianTo = new JLabel("Pick dietician to assign to:");
		lblPickDieticianTo.setForeground(Color.WHITE);
		lblPickDieticianTo.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JComboBox<Nutritionist> destNutComboBox = new JComboBox<>(nutsComboModel);
		CustomerSearchDecorator<Nutritionist> destNutDecorate = CustomerSearchDecorator.decorate(destNutComboBox,MoveCustomerWin::nutFilter);
		destNutComboBox.setRenderer(new CustomComboRenderer(destNutDecorate.getFilterLabel()));
		
		JLabel lblNewLabel = new JLabel("Re-Assign Customer To Dietician");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveFrame.dispose();
			}
		});
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		cancelBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		cancelBtn.setBackground(new Color(97, 212, 195));
		
		JButton assignBtn = new JButton("Re-Assign");
		assignBtn.setForeground(Color.WHITE);
		assignBtn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		assignBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		assignBtn.setBackground(new Color(97, 212, 195));
		
		JLabel arrows1 = new JLabel("-------->");
		arrows1.setForeground(Color.WHITE);
		
		JLabel arrows2 = new JLabel("-------->");
		arrows2.setForeground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(srcNutSelectLbl)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(246)
									.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(assignBtn, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(custToMoveLbl)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(srcNutsComboBox, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(arrows2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
											.addGap(12)
											.addComponent(custComboBox, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addComponent(arrows1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPickDieticianTo, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(destNutComboBox, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE))
					.addGap(970))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(217)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1192, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(srcNutSelectLbl)
						.addComponent(lblPickDieticianTo)
						.addComponent(custToMoveLbl))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(srcNutsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(custComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(destNutComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(arrows2)
						.addComponent(arrows1))
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelBtn, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addComponent(assignBtn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
		panel.setLayout(gl_panel);
		
	}
	
	private static boolean nutFilter(Person nut, String textToFilter) {
        if (textToFilter.isEmpty()) {
            return true;
        }
        return CustomComboRenderer.getCustomerDisplayText(nut).toLowerCase()
                                  .contains(textToFilter.toLowerCase());
    }
}
