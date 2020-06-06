
package com.FatOff.View;

import java.awt.Font;
import com.FatOff.Controller.AdminController;
import com.FatOff.Controller.NutritionistController;
import com.FatOff.Model.Admin;
import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.SaveRestore;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SignInWin {
	private JTextField yourIdField;
	private JPasswordField passwordField;

	public SignInWin() {

		JFrame signInFrame = new JFrame("Sign In");
		signInFrame.setResizable(false);
		signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signInFrame.setLocationRelativeTo(null);
		/////////////////////////////// set icon //////////////////////////////////
		ImageIcon icon = new ImageIcon("src/com/FatOff/View/fat_off_no_bcgnd.png");
		signInFrame.setIconImage(icon.getImage());
		//////////////////////////////////////////////////////////////////////////
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 47, 65));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 314, 490);
		panel.setBackground(new Color(97, 212, 195));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("The way you stay healthy");
		lblNewLabel.setBounds(48, 392, 229, 40);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(89, 86, 127, 228);
		lblNewLabel_1.setIcon(new ImageIcon(SignInWin.class.getResource("/com/FatOff/View/fat_off_white.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);

		JLabel yourIdWarnLbl = new JLabel("");
		yourIdWarnLbl.setBounds(324, 138, 323, 27);
		yourIdWarnLbl.setFont(new Font("Century Gothic", Font.BOLD, 10));
		yourIdWarnLbl.setForeground(new Color(255, 0, 0));
		contentPane.add(yourIdWarnLbl);

		JSeparator separator = new JSeparator();
		separator.setBounds(48, 325, 229, 27);
		separator.setForeground(new Color(255, 255, 255));
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(69, 352, 186, 27);
		separator_1.setForeground(new Color(255, 255, 255));
		panel.add(separator_1);

		JLabel lblWelcomeToFat = new JLabel("Welcome to FAT OFF");
		lblWelcomeToFat.setBounds(69, 11, 167, 40);
		lblWelcomeToFat.setForeground(Color.WHITE);
		lblWelcomeToFat.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel.add(lblWelcomeToFat);

		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(324, 77, 214, 40);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 14));
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(324, 166, 214, 40);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 14));
		contentPane.add(lblPassword);

		JLabel lblForgotPassword = new JLabel("forgot password");
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel lbl = (JLabel) e.getComponent();
				lbl.setForeground(Color.BLUE);
				lbl.setText(String.format("<html><u>%s</u><</html>", "forgot password"));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel lbl = (JLabel) e.getComponent();
				lbl.setForeground(Color.WHITE);
				lbl.setText(String.format("<html>%s<</html>", "forgot password"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new ResetPassWin();
			}
		});
		lblForgotPassword.setForeground(Color.WHITE);
		lblForgotPassword.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblForgotPassword.setBounds(324, 224, 101, 20);

		contentPane.add(lblForgotPassword);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(324, 138, 229, 27);
		separator_2.setForeground(Color.WHITE);
		contentPane.add(separator_2);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(324, 217, 229, 27);
		separator_2_1.setForeground(Color.WHITE);
		contentPane.add(separator_2_1);

		passwordField = new JPasswordField();
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		passwordField.setBounds(324, 195, 229, 20);
		passwordField.setBorder(null);
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(36, 47, 65));
		contentPane.add(passwordField);

		yourIdField = new JTextField();
		yourIdField.setCaretColor(Color.WHITE);
		yourIdField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				yourIdField.setText("");
				yourIdField.setEditable(true);

			}
		});
		yourIdField.setBounds(324, 109, 229, 27);

		yourIdField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		yourIdField.setText("Enter your username");
		yourIdField.setForeground(new Color(255, 255, 255));
		yourIdField.setDisabledTextColor(new Color(204, 204, 204));
		yourIdField.setBackground(new Color(36, 47, 65));
		yourIdField.setBorder(null);
		contentPane.add(yourIdField);
		yourIdField.setColumns(10);

		yourIdField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b') {
					yourIdField.setEditable(true);
					yourIdWarnLbl.setText("");
				} else {
					yourIdField.setEditable(false);
					yourIdWarnLbl.setText("* Enter only numeric digits(0-9)");
				}
				if (yourIdField.getText().length() < 9 || e.getKeyChar() == '\b') {
					yourIdField.setEditable(true);
					yourIdWarnLbl.setText("");
				} else {
					yourIdField.setEditable(false);
					yourIdWarnLbl.setText("Username must contain exactly 9 numeric characters!");
				}
			}
		}

		);

		JLabel lblSignInOr = new JLabel("Sign In or contact admin...");
		lblSignInOr.setBounds(323, 11, 288, 40);
		lblSignInOr.setForeground(Color.WHITE);
		lblSignInOr.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		contentPane.add(lblSignInOr);

		JButton signInBtn = new JButton("Sign In");
		signInBtn.setBounds(324, 389, 127, 40);
		signInBtn.setBorder(null);
		signInBtn.setBackground(new Color(97, 212, 195));
		signInBtn.setForeground(new Color(255, 255, 255));
		signInBtn.setFont(new Font("Century Gothic", Font.BOLD, 16));
		contentPane.add(signInBtn);

		JButton cancelBtn = new JButton("EXIT");
		cancelBtn.setBounds(497, 389, 127, 40);
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("Century Gothic", Font.BOLD, 16));
		cancelBtn.setBorder(null);
		cancelBtn.setBackground(new Color(255, 0, 0));
		contentPane.add(cancelBtn);

		cancelBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				signInFrame.dispose();
			}
		});

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
						if (desired.equals(".DS_Store")) {
							continue;
						}
						String ID[] = desired.split("_");
						if (ID[2].equals(yourIdField.getText())) {
							found = true;
							Admin adm = AdminController.restoreAdmin(desired);
							if (new String(passwordField.getPassword()).equals(adm.getPassword())) {
								new InitialWin(pathToAdmin,adm);
								signInFrame.dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Wrong Password!");
							}
						}
					}
					for (String desired : pathToDieticion.list()) {
						if (desired.equals(".DS_Store")) {
							continue;
						}
						String ID[] = desired.split("_");
						if (ID[2].equals(yourIdField.getText())) {
							found = true;
							Nutritionist nut = NutritionistController.restoreNut(desired);
							if (new String(passwordField.getPassword()).equals(nut.getPassword())) {
								new InitialWin(pathToDieticion, nut);
								signInFrame.dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Wrong Password!");
							}
						}
					}
					if (!found) {
						JOptionPane.showMessageDialog(null, "No such user found!");
						// signInFrame.dispose();
					}
				}
			}
		});
		signInFrame.getContentPane().add(contentPane);
		signInFrame.setSize(new Dimension(657, 476));
		signInFrame.setVisible(true);
	


	}

	private void setContentPane(JPanel contentPane) {
		// TODO Auto-generated method stub

	}

}
