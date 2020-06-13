package com.FatOff.View;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import com.FatOff.Controller.AdminController;
import com.FatOff.Controller.NutritionistController;
import com.FatOff.Model.Admin;
import com.FatOff.Model.Nutritionist;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NutResetPass {
	private JTextField curPass;
	private JPasswordField pass1;
	private JPasswordField pass2;

public NutResetPass(Object nut) {
		JFrame nutReestPass= new JFrame("Nutritionist Reset Pass");
	nutReestPass.getContentPane().setBackground(new Color(36, 47, 65));
	nutReestPass.getContentPane().setLayout(null);
	
	/////////////////////////////// set icon //////////////////////////////////
	ImageIcon icon = new ImageIcon("src/com/FatOff/View/IconFatOff.PNG");
	nutReestPass.setIconImage(icon.getImage());
	//////////////////////////////////////////////////////////////////////////
	
	JLabel lblNewLabel = new JLabel("Current Pass:");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
	lblNewLabel.setBounds(6, 6, 138, 19);
	nutReestPass.getContentPane().add(lblNewLabel);
	
	curPass = new JTextField();
	curPass.setFont(new Font("Dialog", Font.PLAIN, 12));
	curPass.setColumns(10);
	curPass.setBounds(148, 6, 192, 19);
	nutReestPass.getContentPane().add(curPass);
	
	JButton validBtn = new JButton("Validate");
	
	validBtn.setForeground(Color.WHITE);
	validBtn.setFont(new Font("Dialog", Font.BOLD, 16));
	validBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
	validBtn.setBackground(new Color(97, 212, 195));
	validBtn.setBounds(148, 37, 192, 38);
	nutReestPass.getContentPane().add(validBtn);
	
	pass1 = new JPasswordField();
	pass1.setFont(new Font("Dialog", Font.PLAIN, 12));
	pass1.setEnabled(false);
	pass1.setEditable(false);
	pass1.setColumns(10);
	pass1.setBounds(148, 91, 192, 19);
	nutReestPass.getContentPane().add(pass1);
	
	JLabel text = new JLabel("New Password:");
	text.setForeground(Color.WHITE);
	text.setFont(new Font("Dialog", Font.PLAIN, 14));
	text.setBounds(6, 90, 133, 19);
	nutReestPass.getContentPane().add(text);
	
	JLabel text2 = new JLabel("Confirm Password:");
	text2.setForeground(Color.WHITE);
	text2.setFont(new Font("Dialog", Font.PLAIN, 14));
	text2.setBounds(6, 118, 138, 19);
	nutReestPass.getContentPane().add(text2);
	
	pass2 = new JPasswordField();
	pass2.setFont(new Font("Dialog", Font.PLAIN, 12));
	pass2.setEnabled(false);
	pass2.setEditable(false);
	pass2.setColumns(10);
	pass2.setBounds(148, 116, 192, 19);
	nutReestPass.getContentPane().add(pass2);
	
	JButton Change = new JButton("Change");
	Change.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(new String(pass1.getPassword()).equals(new String(pass2.getPassword())))
			{
			
			((Nutritionist)nut).setPassword(new String(pass1.getPassword()));
				
				if(nut.getClass().equals(Admin.class)) {
					if(AdminController.storeAdmin((Admin)nut)) {
						JOptionPane.showMessageDialog(null, "Your password has been changed");
					}
				}
				else {
					if(nut.getClass().equals(Nutritionist.class)) {
						if(NutritionistController.storeNutritionist((Nutritionist)nut)) {
							JOptionPane.showMessageDialog(null, "Your password has been changed");
							nutReestPass.dispose();
						}
					}
				}
				nutReestPass.setVisible(false);
			}
			else
			{
				
				JOptionPane.showMessageDialog(null, "Different Passwords Entered");
			}
		}
	});
	Change.setEnabled(false);
	Change.setForeground(Color.WHITE);
	Change.setFont(new Font("Dialog", Font.BOLD, 16));
	Change.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
	Change.setBackground(new Color(97, 212, 195));
	Change.setBounds(148, 147, 192, 38);
	nutReestPass.getContentPane().add(Change);
	
	
	
validBtn.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		if(new String(((Nutritionist) nut).getPassword()).equals(curPass.getText())) {
			Change.setEnabled(true);
			pass2.setEnabled(true);
			pass1.setEnabled(true);
			pass2.setEditable(true);
			pass1.setEditable(true);
		}
		else {
			
			JOptionPane.showMessageDialog(null, "Wrong Password Code");
		}
	}
});
nutReestPass.setSize(new Dimension(600, 300));

nutReestPass.setLocationRelativeTo(null);

nutReestPass.setVisible(true);
}
}
