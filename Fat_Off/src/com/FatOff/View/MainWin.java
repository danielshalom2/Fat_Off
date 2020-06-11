
package com.FatOff.View;

import javax.mail.MessagingException;
import javax.swing.*;

import com.FatOff.Controller.CustomerController;
import com.FatOff.Controller.SessionMeasureController;
import com.FatOff.Model.*;
import com.itextpdf.text.DocumentException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class MainWin {
	private JTextField customerNameField;
	private JTextField weightTField;
	private JTextField heightTField;
	private JTextField wristTField;
	private JTextField ageTFIeld;
	private JTextField weistTField;
	private JTextField thighTField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField bmiTField;
	private JTextField eerTField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField physiqueTField;

	public MainWin(Nutritionist nut, Customer cust, String activity) {
		
		UIManager UI=new UIManager();
		  UI.put("OptionPane.background", new Color(36, 47, 65));
		  UI.put("Panel.background", new Color(36, 47, 65));
		  UI.put("OptionPane.messageForeground", Color.WHITE);

		Session sess = new Session(cust.getSessions().size()+1);
		
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		/////////////////////////////// set icon //////////////////////////////////
		ImageIcon icon = new ImageIcon("src/com/FatOff/View/IconFatOff.PNG");
		mainFrame.setIconImage(icon.getImage());
		//////////////////////////////////////////////////////////////////////////

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground((new Color(36, 47, 65)));
		GroupLayout groupLayout = new GroupLayout(mainFrame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(mainPanel,
				GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(mainPanel,
				GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE));

		JLabel logoLbl = new JLabel("");
		logoLbl.setIcon(new ImageIcon(MainWin.class.getResource("/com/FatOff/View/fat_off_white.png")));

		JLabel customerNameLbl = new JLabel("Customer Name: ");
		customerNameLbl.setForeground(Color.WHITE);
		customerNameLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));

		customerNameField = new JTextField(cust.toString());
		customerNameField.setForeground(Color.WHITE);
		customerNameField.setFont(new Font("Century Gothic", Font.BOLD, 18));
		customerNameField.setFocusable(false);
		customerNameField.setFocusTraversalKeysEnabled(false);
		customerNameField.setDragEnabled(false);
		customerNameField.setRequestFocusEnabled(false);
		customerNameField.setVerifyInputWhenFocusTarget(false);
		customerNameField.setEditable(false);
		customerNameField.setAutoscrolls(false);
		customerNameField.setColumns(10);
		customerNameField.setBackground(null);

		JLabel measuresLbl = new JLabel("Measures:");
		measuresLbl.setForeground(Color.WHITE);
		measuresLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));

		weightTField = new JTextField();
		weightTField.setText("Enter Weight");
		weightTField.setHorizontalAlignment(SwingConstants.CENTER);
		weightTField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		weightTField.setColumns(10);
		weightTField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				weightTField.setText("");
			}
		});

		JLabel weightLbl = new JLabel("Weight :");
		weightLbl.setForeground(Color.WHITE);
		weightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		heightTField = new JTextField();
		heightTField.setText("Enter Height");
		heightTField.setHorizontalAlignment(SwingConstants.CENTER);
		heightTField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		heightTField.setColumns(10);
		heightTField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				heightTField.setText("");
			}
		});

		JLabel heightLbl = new JLabel("Height :");
		heightLbl.setForeground(Color.WHITE);
		heightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		wristTField = new JTextField();
		wristTField.setText("Enter Wrist");
		wristTField.setHorizontalAlignment(SwingConstants.CENTER);
		wristTField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		wristTField.setColumns(10);
		wristTField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				wristTField.setText("");
			}
		});

		JLabel wristLbl = new JLabel("Wrist:");
		wristLbl.setForeground(Color.WHITE);
		wristLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel ageLbl = new JLabel("Age: ");
		ageLbl.setForeground(Color.WHITE);
		ageLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));

		ageTFIeld = new JTextField(CustomerController.calcAge(cust));
		ageTFIeld.setForeground(Color.WHITE);
		ageTFIeld.setFont(new Font("Century Gothic", Font.BOLD, 18));
		ageTFIeld.setVerifyInputWhenFocusTarget(false);
		ageTFIeld.setRequestFocusEnabled(false);
		ageTFIeld.setFocusable(false);
		ageTFIeld.setFocusTraversalKeysEnabled(false);
		ageTFIeld.setDragEnabled(false);
		ageTFIeld.setEditable(false);
		ageTFIeld.setColumns(10);
		ageTFIeld.setBackground((Color) null);

		JLabel weistLbl = new JLabel("Weist:");
		weistLbl.setForeground(Color.WHITE);
		weistLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		weistTField = new JTextField();
		weistTField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		weistTField.setHorizontalAlignment(SwingConstants.CENTER);
		weistTField.setText("Enter Weist");
		weistTField.setColumns(10);
		weistTField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				weistTField.setText("");
			}
		});

		JScrollPane summaryScrlPane = new JScrollPane();

		JLabel thighLbl = new JLabel("Thigh:");
		thighLbl.setForeground(Color.WHITE);
		thighLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		thighTField = new JTextField();
		thighTField.setHorizontalAlignment(SwingConstants.CENTER);
		thighTField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		thighTField.setText("Enter Thigh");
		thighTField.setColumns(10);
		thighTField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thighTField.setText("");
			}
		});

		JLabel menuLbl = new JLabel("Enter Menu Here:");
		menuLbl.setForeground(Color.WHITE);
		menuLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));

		JLabel breakfastLbl = new JLabel("Breakfast:");
		breakfastLbl.setForeground(Color.WHITE);
		breakfastLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));

		JScrollPane breakfastScrlPane = new JScrollPane();

		JLabel snack1Lbl = new JLabel("Snack 1:");
		snack1Lbl.setForeground(Color.WHITE);
		snack1Lbl.setFont(new Font("Century Gothic", Font.BOLD, 14));

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel lunchLbl = new JLabel("Lunch:");
		lunchLbl.setForeground(Color.WHITE);
		lunchLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));

		JScrollPane lunchfastScrlPane = new JScrollPane();

		JLabel snack2Lbl = new JLabel("Snack 2:");
		snack2Lbl.setForeground(Color.WHITE);
		snack2Lbl.setFont(new Font("Century Gothic", Font.BOLD, 14));

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel dinnerLbl = new JLabel("Dinner:");
		dinnerLbl.setForeground(Color.WHITE);
		dinnerLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));

		JScrollPane dinnerScrlPane = new JScrollPane();

		JTextPane gnrlSummTPane = new JTextPane();
		gnrlSummTPane.setForeground(Color.WHITE);
		gnrlSummTPane.setBackground(null);
		gnrlSummTPane.setEditable(false);
		gnrlSummTPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		gnrlSummTPane.setText("General\nSummary");
		gnrlSummTPane.setFont(new Font("Century Gothic", Font.BOLD, 14));

		JLabel bmiLbl = new JLabel("BMI:");
		bmiLbl.setForeground(Color.WHITE);
		bmiLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));

		bmiTField = new JTextField();
		bmiTField.setEditable(false);
		bmiTField.setColumns(10);

		JLabel eerLbl = new JLabel("EER:");
		eerLbl.setForeground(Color.WHITE);
		eerLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));

		eerTField = new JTextField();
		eerTField.setEditable(false);
		eerTField.setColumns(10);
		
		JLabel physiqueLbl = new JLabel("Physique:");
		physiqueLbl.setForeground(Color.WHITE);
		physiqueLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		physiqueTField = new JTextField();
		physiqueTField.setEditable(false);
		physiqueTField.setColumns(10);
		
		JTextArea dinnerArea = new JTextArea();
		dinnerScrlPane.setViewportView(dinnerArea);

		JTextArea lunchArea = new JTextArea();
		lunchfastScrlPane.setViewportView(lunchArea);

		JTextArea breakfastArea = new JTextArea();
		breakfastScrlPane.setViewportView(breakfastArea);

		JTextArea summaryArea = new JTextArea();
		summaryScrlPane.setViewportView(summaryArea);

		JButton clearBtn = new JButton("Clear");
		clearBtn.setFont(new Font("Century Gothic", Font.PLAIN, 10));

		JButton calcBtn = new JButton("Claculate");
		calcBtn.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		calcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Measures temp = new Measures(
						Math.round(Float.parseFloat(ageTFIeld.getText())),
						Float.parseFloat(weightTField.getText()),
						Float.parseFloat(heightTField.getText()), Float.parseFloat(wristTField.getText()),
						Float.parseFloat(weistTField.getText()), Float.parseFloat(thighTField.getText()),
						cust.getGender(),getSelectedButtonText(buttonGroup));

				
				bmiTField.setText(new DecimalFormat("##.##").format((float) temp.getBmi()));
				eerTField.setText(new DecimalFormat("##.##").format((float) temp.getEer()));
				physiqueTField.setText(temp.getPhysique());
				
				sess.setMeasures(temp);
				cust.getSessions().add(sess);
			}
		});

		JButton emailSummBtn = new JButton("Save and Send");
		emailSummBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean succeed;
				String pathToNut = SaveRestore.getNutPath(nut);
				try {
					try {
						succeed = SessionMeasureController.storeSession(sess, cust, pathToNut, summaryArea.getText(),
								breakfastArea.getText(), textField_1.getText(), lunchArea.getText(), 
								textField_2.getText(), dinnerArea.getText(), nut.getFirstName() + " " + nut.getLastName(), nut.getEmailAddress(), nut.getPhoneNumber());
					} catch (DocumentException | MessagingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						succeed = false;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					succeed = false;
				}
				if(succeed) {
					JOptionPane.showMessageDialog(null, "This session was saved and sent successfuly");
					mainFrame.dispose();
				}
			}
		});
		emailSummBtn.setFont(new Font("Century Gothic", Font.PLAIN, 10));

		JButton btnNewButton = new JButton("Show Progress");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Double> bmiReport = SessionMeasureController.generateBmiProgressReport(cust.getSessions());
				ArrayList<Double> waistReport = SessionMeasureController.generateWaistProgressReport(cust.getSessions());
				new ProgressReportWin(bmiReport , waistReport);
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 10));

		JLabel dateLbl = new JLabel("Date:");
		dateLbl.setForeground(Color.WHITE);
		dateLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));

		LocalDateTime now = LocalDateTime.now();
		JLabel todayLbl = new JLabel(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(now).toString());
		todayLbl.setForeground(Color.WHITE);
		todayLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));

		JLabel lblActivity = new JLabel("Activity:");
		lblActivity.setForeground(Color.WHITE);
		lblActivity.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Sedentary");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(36, 47, 65));

		rdbtnNewRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtnNewRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);

		rdbtnNewRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);

		rdbtnNewRadioButton.setForeground(Color.WHITE);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Active");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(new Color(36, 47, 65));

		rdbtnNewRadioButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtnNewRadioButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.LEFT);

		rdbtnNewRadioButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.LEFT);

		rdbtnNewRadioButton_1.setForeground(Color.WHITE);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Very Active");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBackground(new Color(36, 47, 65));

		rdbtnNewRadioButton_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtnNewRadioButton_2.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_2.setForeground(Color.WHITE);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Low Active");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBackground(new Color(36, 47, 65));

		rdbtnNewRadioButton_3.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtnNewRadioButton_3.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_3.setForeground(Color.WHITE);
		
		JButton openIntroMeetBtn = new JButton("Open Introductory Meeting");
		openIntroMeetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();
				File file = new File(CustomerController.pathToType(nut, cust.getFirstName()+"_" + cust.getLastName() +"_" + cust.getId()) + "/Interview.pdf");
				try {
					desktop.open(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		openIntroMeetBtn.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		
		JButton prevSessionBtn = new JButton("Open Previous Session");
		prevSessionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				ArrayList<String> sessions = new ArrayList<String>();
				Desktop desktop = Desktop.getDesktop();
				File specSess;
				JPanel selectionPanel = new JPanel();
				selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.Y_AXIS));
				String selectedSess;
				selectionPanel.setBackground((new Color(36, 47, 65)));
				
				File sesses = new File(CustomerController.pathToType(nut, cust.getFirstName()+"_" + cust.getLastName() 
										+"_" + cust.getId() + "/Sessions"));
				
				for (String item : sesses.list()) {
					if(!(item.equalsIgnoreCase(".DS_Store")))
						sessions.add(item);
				}
				Collections.sort(sessions);
				DefaultComboBoxModel<String> sessionComboModel = new DefaultComboBoxModel<String>(
						sessions.toArray(new String[sessions.size()]));
				JComboBox<String> sessionComboBox = new JComboBox<>(sessionComboModel);
				selectionPanel.add(sessionComboBox);
				
				int selected = JOptionPane.showConfirmDialog(null, selectionPanel, "Session Selection", JOptionPane.OK_CANCEL_OPTION);
				if (selected == 0) {
					selectedSess = (String) sessionComboBox.getSelectedItem();
					String[] files = new File(sesses + "/" + selectedSess).list();
					String pdfName = "";
					for (String name : files) {
						if(name.substring(name.length() - 3).equals("pdf")) {
							pdfName = name;
							break;
						}
					}
					try {
						desktop.open(new File(sesses + "/" + selectedSess + "/" + pdfName));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});

		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(thighLbl)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addComponent(clearBtn)
									.addGap(18)
									.addComponent(calcBtn))
								.addComponent(measuresLbl)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(weistLbl)
										.addComponent(lblActivity, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
										.addComponent(wristLbl, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
										.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(heightLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(weightLbl, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_mainPanel.createSequentialGroup()
											.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(rdbtnNewRadioButton)
												.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(rdbtnNewRadioButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(rdbtnNewRadioButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(thighTField, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
											.addComponent(weistTField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
											.addComponent(weightTField, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
											.addComponent(heightTField, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
										.addComponent(wristTField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
									.addGap(20))
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_mainPanel.createSequentialGroup()
										.addComponent(physiqueLbl)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(physiqueTField, 0, 0, Short.MAX_VALUE))
									.addGroup(gl_mainPanel.createSequentialGroup()
										.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(bmiLbl)
											.addComponent(eerLbl))
										.addGap(18)
										.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(eerTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(bmiTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(logoLbl)
							.addGap(41)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(customerNameLbl)
								.addComponent(ageLbl))))
					.addGap(18)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addComponent(ageTFIeld, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
									.addComponent(openIntroMeetBtn, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addComponent(customerNameField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
									.addComponent(dateLbl)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(todayLbl))))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(dinnerScrlPane, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
								.addComponent(summaryScrlPane, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
								.addComponent(lunchfastScrlPane, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
								.addComponent(breakfastScrlPane, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addComponent(snack1Lbl)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addComponent(snack2Lbl)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addGap(25)
									.addComponent(menuLbl)
									.addGap(437))
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addComponent(prevSessionBtn)
									.addGap(18)
									.addComponent(btnNewButton)
									.addGap(26)
									.addComponent(emailSummBtn))
								.addComponent(breakfastLbl, Alignment.LEADING)
								.addComponent(lunchLbl, Alignment.LEADING)
								.addComponent(dinnerLbl, Alignment.LEADING))))
					.addGap(63))
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(299)
					.addComponent(gnrlSummTPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(675, Short.MAX_VALUE))
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(logoLbl)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addGap(13)
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(customerNameLbl)
										.addComponent(customerNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(ageLbl)
										.addComponent(ageTFIeld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(todayLbl)
										.addComponent(dateLbl))
									.addGap(39)
									.addComponent(openIntroMeetBtn, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(summaryScrlPane, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addComponent(gnrlSummTPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(19)))))
					.addGap(16)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(menuLbl)
							.addGap(20)
							.addComponent(breakfastLbl))
						.addComponent(measuresLbl))
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(weightLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(weightTField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(heightLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(heightTField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(wristLbl)
								.addComponent(wristTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(weistLbl)
								.addComponent(weistTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(thighLbl)
								.addComponent(thighTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblActivity, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(rdbtnNewRadioButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnNewRadioButton_1)
								.addComponent(rdbtnNewRadioButton_3))
							.addGap(12))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(breakfastScrlPane, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(snack1Lbl)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addComponent(lunchLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lunchfastScrlPane, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(21)))
					.addGap(10)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(snack2Lbl)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(clearBtn)
						.addComponent(calcBtn))
					.addGap(18)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(bmiLbl)
								.addComponent(bmiTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(12))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(dinnerLbl)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(eerLbl)
								.addComponent(eerTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(physiqueLbl)
								.addComponent(physiqueTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(dinnerScrlPane, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
					.addGap(61)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailSummBtn)
						.addComponent(btnNewButton)
						.addComponent(prevSessionBtn))
					.addGap(40))
		);

		
		mainPanel.setLayout(gl_mainPanel);
		mainFrame.getContentPane().setLayout(groupLayout);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.pack();
	}

	String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = (AbstractButton) buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}
}
