
package com.FatOff.View;

import javax.mail.MessagingException;
import javax.swing.*;

import com.FatOff.Controller.CustomerController;
import com.FatOff.Controller.SessionMeasureController;
import com.FatOff.Model.*;
import com.itextpdf.text.DocumentException;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class MainWin {

	private final LocalDateTime now = LocalDateTime.now();

	// Labels
	private final JLabel logoLbl = new JLabel("");
	private final JLabel customerNameLbl = new JLabel("Customer Name: ");
	private final JLabel measuresLbl = new JLabel("Measures:");
	private final JLabel weightLbl = new JLabel("Weight :");
	private final JLabel heightLbl = new JLabel("Height :");
	private final JLabel wristLbl = new JLabel("Wrist:");
	private final JLabel ageLbl = new JLabel("Age: ");
	private final JLabel weistLbl = new JLabel("Weist:");
	private final JLabel thighLbl = new JLabel("Thigh:");
	private final JLabel menuLbl = new JLabel("Enter Menu Here:");
	private final JLabel breakfastLbl = new JLabel("Breakfast:");
	private final JLabel snack1Lbl = new JLabel("Snack 1:");
	private final JLabel lunchLbl = new JLabel("Lunch:");
	private final JLabel snack2Lbl = new JLabel("Snack 2:");
	private final JLabel dinnerLbl = new JLabel("Dinner:");
	private final JLabel bmiLbl = new JLabel("BMI:");
	private final JLabel eerLbl = new JLabel("EER:");
	private final JLabel physiqueLbl = new JLabel("Physique:");
	private final JLabel dateLbl = new JLabel("Date:");
	private final JLabel lblActivity = new JLabel("Activity:");
	private final JLabel todayLbl = new JLabel(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(now).toString());

	// Text Fields
	private JTextField customerNameField;
	private JTextField weightTField;
	private JTextField heightTField;
	private JTextField wristTField;
	private JTextField ageTFIeld;
	private JTextField weistTField;
	private JTextField thighTField;
	private JTextField snack1TField;
	private JTextField snack2TField;
	private JTextField bmiTField;
	private JTextField eerTField;
	private JTextField physiqueTField;

	// Radio Buttons
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JRadioButton rdbtnNewRadioButton = new JRadioButton("Sedentary");
	private final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Active");
	private final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Very Active");
	private final JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Low Active");

	// Regular Buttons
	private final JButton openIntroMeetBtn = new JButton("Open Introductory Meeting");
	private final JButton emailSummBtn = new JButton("Save and Send");
	private final JButton btnNewButton = new JButton("Show Progress");
	private final JButton calcBtn = new JButton("Claculate");
	private final JButton clearBtn = new JButton("Clear");
	private final JButton prevSessionBtn = new JButton("Open Previous Session");

	// Scroll Panes
	private final JScrollPane summaryScrlPane = new JScrollPane();
	private final JScrollPane breakfastScrlPane = new JScrollPane();
	private final JScrollPane lunchfastScrlPane = new JScrollPane();
	private final JScrollPane dinnerScrlPane = new JScrollPane();

	// Text Panes
	private JTextPane gnrlSummTPane;

	public MainWin(Nutritionist nut, Customer cust) {

		Session sess = new Session(cust.getSessions().size() + 1);

		UIManager.put("OptionPane.background", new Color(36, 47, 65));
		UIManager.put("Panel.background", new Color(36, 47, 65));
		UIManager.put("OptionPane.messageForeground", Color.WHITE);

		// Initialize the main frame of the window
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		/////////////////////////////// set icon //////////////////////////////////
		ImageIcon icon = new ImageIcon("src/com/FatOff/View/IconFatOff.PNG");
		mainFrame.setIconImage(icon.getImage());
		//////////////////////////////////////////////////////////////////////////

		// Initialize the main window panel, set its color and layout
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground((new Color(36, 47, 65)));
		GroupLayout groupLayout = new GroupLayout(mainFrame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(mainPanel,
				GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(mainPanel,
				GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE));

		/////////////////////////////// Labels Configurations
		/////////////////////////////// //////////////////////////////////

		logoLbl.setIcon(new ImageIcon(MainWin.class.getResource("/com/FatOff/View/fat_off_white.png")));

		// GENERAL INFO LABELS
		customerNameLbl.setForeground(Color.WHITE);
		customerNameLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));

		ageLbl.setForeground(Color.WHITE);
		ageLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));

		dateLbl.setForeground(Color.WHITE);
		dateLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));

		todayLbl.setForeground(Color.WHITE);
		todayLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));

		// CUSTOMER MEASURES LABELS
		measuresLbl.setForeground(Color.WHITE);
		measuresLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));

		weightLbl.setForeground(Color.WHITE);
		weightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		heightLbl.setForeground(Color.WHITE);
		heightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		wristLbl.setForeground(Color.WHITE);
		wristLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		thighLbl.setForeground(Color.WHITE);
		thighLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		weistLbl.setForeground(Color.WHITE);
		weistLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		bmiLbl.setForeground(Color.WHITE);
		bmiLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));

		eerLbl.setForeground(Color.WHITE);
		eerLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));

		physiqueLbl.setForeground(Color.WHITE);
		physiqueLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));

		lblActivity.setForeground(Color.WHITE);
		lblActivity.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		// MENU LABELS
		menuLbl.setForeground(Color.WHITE);
		menuLbl.setFont(new Font("Century Gothic", Font.BOLD, 16));

		breakfastLbl.setForeground(Color.WHITE);
		breakfastLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));

		snack1Lbl.setForeground(Color.WHITE);
		snack1Lbl.setFont(new Font("Century Gothic", Font.BOLD, 14));

		lunchLbl.setForeground(Color.WHITE);
		lunchLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));

		snack2Lbl.setForeground(Color.WHITE);
		snack2Lbl.setFont(new Font("Century Gothic", Font.BOLD, 14));

		dinnerLbl.setForeground(Color.WHITE);
		dinnerLbl.setFont(new Font("Century Gothic", Font.BOLD, 14));

		////////////////////////////// Text Field Configurations
		////////////////////////////// ////////////////////////////////

		// CUSTOMER INFO TEXT FIELDS
		customerNameField = new JTextField(cust.toString());
		customerNameField.setForeground(Color.WHITE);
		customerNameField.setFont(new Font("Century Gothic", Font.BOLD, 18));
		customerNameField.setEditable(false);
		customerNameField.setBackground(null);

		ageTFIeld = new JTextField(CustomerController.calcAge(cust));
		ageTFIeld.setForeground(Color.WHITE);
		ageTFIeld.setFont(new Font("Century Gothic", Font.BOLD, 18));
		ageTFIeld.setEditable(false);
		ageTFIeld.setColumns(10);
		ageTFIeld.setBackground((Color) null);

		// MEASURES TEXT FIELDS
		weightTField = new JTextField();
		weightTField.setText("Enter Weight");
		weightTField.setHorizontalAlignment(SwingConstants.CENTER);
		weightTField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		weightTField.setColumns(10);
		// Clear the text when mouse clicked
		weightTField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				weightTField.setText("");
			}
		});

		// disable typing non-numeric charecters
		weightTField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b')
						|| e.getKeyChar() == '.') {
					weightTField.setEditable(true);
				} else {
					weightTField.setEditable(false);
				}
			}
		});

		heightTField = new JTextField();
		heightTField.setText("Enter Height");
		heightTField.setHorizontalAlignment(SwingConstants.CENTER);
		heightTField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		heightTField.setColumns(10);
		// Clear the text when mouse clicked
		heightTField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				heightTField.setText("");
			}
		});

		// disable typing non-numeric charecters
		heightTField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b')
						|| e.getKeyChar() == '.') {
					heightTField.setEditable(true);
				} else {
					heightTField.setEditable(false);
				}
			}
		});

		wristTField = new JTextField();
		wristTField.setText("Enter Wrist");
		wristTField.setHorizontalAlignment(SwingConstants.CENTER);
		wristTField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		wristTField.setColumns(10);
		// Clear the text when mouse clicked
		wristTField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				wristTField.setText("");
			}
		});

		// disable typing non-numeric charecters
		wristTField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b')
						|| e.getKeyChar() == '.') {
					wristTField.setEditable(true);
				} else {
					wristTField.setEditable(false);
				}
			}
		});

		weistTField = new JTextField();
		weistTField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		weistTField.setHorizontalAlignment(SwingConstants.CENTER);
		weistTField.setText("Enter Weist");
		weistTField.setColumns(10);
		// Clear the text when mouse clicked
		weistTField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				weistTField.setText("");
			}
		});

		// disable typing non-numeric charecters
		weistTField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b')
						|| e.getKeyChar() == '.') {
					weistTField.setEditable(true);
				} else {
					weistTField.setEditable(false);
				}
			}
		});

		thighTField = new JTextField();
		thighTField.setHorizontalAlignment(SwingConstants.CENTER);
		thighTField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		thighTField.setText("Enter Thigh");
		thighTField.setColumns(10);
		// Clear the text when mouse clicked
		thighTField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thighTField.setText("");
			}
		});

		// disable typing non-numeric charecters
		thighTField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b')
						|| e.getKeyChar() == '.') {
					thighTField.setEditable(true);
				} else {
					thighTField.setEditable(false);
				}
			}
		});

		bmiTField = new JTextField();
		bmiTField.setEditable(false);
		bmiTField.setColumns(10);

		eerTField = new JTextField();
		eerTField.setEditable(false);
		eerTField.setColumns(10);

		physiqueTField = new JTextField();
		physiqueTField.setEditable(false);
		physiqueTField.setColumns(10);

		// SNACKS TEXT FIELDS
		snack1TField = new JTextField();
		snack1TField.setColumns(10);

		snack2TField = new JTextField();
		snack2TField.setColumns(10);

		////////// Text Panes and Areas and Scroll Panes Configurations ///////////////

		gnrlSummTPane = new JTextPane();
		gnrlSummTPane.setForeground(Color.WHITE);
		gnrlSummTPane.setBackground(null);
		gnrlSummTPane.setEditable(false);
		gnrlSummTPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		gnrlSummTPane.setText("General\nSummary");
		gnrlSummTPane.setFont(new Font("Century Gothic", Font.BOLD, 14));

		JTextArea dinnerArea = new JTextArea();
		dinnerScrlPane.setViewportView(dinnerArea);

		JTextArea lunchArea = new JTextArea();
		lunchfastScrlPane.setViewportView(lunchArea);

		JTextArea breakfastArea = new JTextArea();
		breakfastScrlPane.setViewportView(breakfastArea);

		JTextArea summaryArea = new JTextArea();
		summaryScrlPane.setViewportView(summaryArea);

		////////////////////////////// Buttons Configurations
		////////////////////////////// ////////////////////////////////

		calcBtn.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		calcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Measures temp = new Measures(Math.round(Float.parseFloat(ageTFIeld.getText())),
						Float.parseFloat(weightTField.getText()), Float.parseFloat(heightTField.getText()),
						Float.parseFloat(wristTField.getText()), Float.parseFloat(weistTField.getText()),
						Float.parseFloat(thighTField.getText()), cust.getGender(), getSelectedButtonText(buttonGroup));

				bmiTField.setText(new DecimalFormat("##.##").format((float) temp.getBmi()));
				eerTField.setText(new DecimalFormat("##.##").format((float) temp.getEer()));
				physiqueTField.setText(temp.getPhysique());

				sess.setMeasures(temp);
				cust.getSessions().add(sess);
				calcBtn.setEnabled(false);
				emailSummBtn.setEnabled(true);
			}
		});

		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weightTField.setText("");
				heightTField.setText("");
				weistTField.setText("");
				wristTField.setText("");
				thighTField.setText("");
				bmiTField.setText("");
				eerTField.setText("");
				physiqueTField.setText("");
				if (cust.getSessions().contains(sess)) {
					cust.getSessions().remove(sess);
				}
				calcBtn.setEnabled(true);
				emailSummBtn.setEnabled(false);
			}
		});
		clearBtn.setFont(new Font("Century Gothic", Font.PLAIN, 10));

		emailSummBtn.setEnabled(false);
		emailSummBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean succeed;
				String pathToNut = SaveRestore.getNutPath(nut);
				try {
					try {
						succeed = SessionMeasureController.storeSession(sess, cust, pathToNut, summaryArea.getText(),
								breakfastArea.getText(), snack1TField.getText(), lunchArea.getText(),
								snack2TField.getText(), dinnerArea.getText(),
								nut.getFirstName() + " " + nut.getLastName(), nut.getEmailAddress(),
								nut.getPhoneNumber());
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
				if (succeed) {
					JOptionPane.showMessageDialog(null, "This session was saved and sent successfuly");
					mainFrame.dispose();
				}
			}
		});
		emailSummBtn.setFont(new Font("Century Gothic", Font.PLAIN, 10));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Double> bmiReport = SessionMeasureController.generateBmiProgressReport(cust.getSessions());
				ArrayList<Double> waistReport = SessionMeasureController
						.generateWaistProgressReport(cust.getSessions());
				new ProgressReportWin(bmiReport, waistReport);
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 10));

		openIntroMeetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();
				File file = new File(CustomerController.pathToType(nut,
						cust.getFirstName() + "_" + cust.getLastName() + "_" + cust.getId()) + "/Interview.pdf");
				try {
					desktop.open(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		openIntroMeetBtn.setFont(new Font("Century Gothic", Font.PLAIN, 10));

		prevSessionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<String> sessions = new ArrayList<String>();
				Desktop desktop = Desktop.getDesktop();
				JPanel selectionPanel = new JPanel();
				selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.Y_AXIS));
				String selectedSess;
				selectionPanel.setBackground((new Color(36, 47, 65)));

				File sesses = new File(CustomerController.pathToType(nut,
						cust.getFirstName() + "_" + cust.getLastName() + "_" + cust.getId() + "/Sessions"));

				for (String item : sesses.list()) {
					if (!(item.equalsIgnoreCase(".DS_Store")))
						sessions.add(item);
				}
				Collections.sort(sessions);
				DefaultComboBoxModel<String> sessionComboModel = new DefaultComboBoxModel<String>(
						sessions.toArray(new String[sessions.size()]));

				JComboBox<String> sessionComboBox = new JComboBox<>(sessionComboModel);
				selectionPanel.add(sessionComboBox);

				int selected = JOptionPane.showConfirmDialog(null, selectionPanel, "Session Selection",
						JOptionPane.OK_CANCEL_OPTION);

				if (selected == 0) {
					if (sessionComboBox.getSelectedItem() == null) {
						JOptionPane.showMessageDialog(null, "No Session Selected!");
					} else {
						selectedSess = (String) sessionComboBox.getSelectedItem();
						String[] files = new File(sesses + "/" + selectedSess).list();
						String pdfName = "";
						for (String name : files) {
							if (name.substring(name.length() - 3).equals("pdf")) {
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

			}
		});

		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(36, 47, 65));

		rdbtnNewRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtnNewRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);

		rdbtnNewRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);

		rdbtnNewRadioButton.setForeground(Color.WHITE);

		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(new Color(36, 47, 65));

		rdbtnNewRadioButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtnNewRadioButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.LEFT);

		rdbtnNewRadioButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.LEFT);

		rdbtnNewRadioButton_1.setForeground(Color.WHITE);

		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBackground(new Color(36, 47, 65));

		rdbtnNewRadioButton_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtnNewRadioButton_2.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_2.setForeground(Color.WHITE);

		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBackground(new Color(36, 47, 65));

		rdbtnNewRadioButton_3.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtnNewRadioButton_3.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_3.setForeground(Color.WHITE);

		////////////////////////////// Layout and window design
		////////////////////////////// //////////////////////////////

		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_mainPanel
				.createSequentialGroup()
				.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false).addGroup(gl_mainPanel
						.createSequentialGroup().addGap(24)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING).addComponent(thighLbl)
								.addGroup(gl_mainPanel.createSequentialGroup().addComponent(clearBtn).addGap(18)
										.addComponent(calcBtn))
								.addComponent(measuresLbl)
								.addGroup(gl_mainPanel.createSequentialGroup()
										.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(weistLbl)
												.addComponent(lblActivity, GroupLayout.PREFERRED_SIZE, 109,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(wristLbl, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
												.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(heightLbl, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(weightLbl, GroupLayout.DEFAULT_SIZE, 77,
																Short.MAX_VALUE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_mainPanel.createSequentialGroup()
														.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(rdbtnNewRadioButton).addComponent(
																		rdbtnNewRadioButton_1,
																		GroupLayout.PREFERRED_SIZE, 80,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(18)
														.addGroup(gl_mainPanel
																.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(rdbtnNewRadioButton_3,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(rdbtnNewRadioButton_2,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
												.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(thighTField, Alignment.LEADING, 0, 0,
																Short.MAX_VALUE)
														.addComponent(weistTField, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
														.addComponent(weightTField, GroupLayout.DEFAULT_SIZE, 86,
																Short.MAX_VALUE)
														.addComponent(heightTField, Alignment.LEADING, 0, 0,
																Short.MAX_VALUE))
												.addComponent(wristTField, GroupLayout.PREFERRED_SIZE, 86,
														GroupLayout.PREFERRED_SIZE))
										.addGap(20))
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_mainPanel.createSequentialGroup().addComponent(physiqueLbl)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(physiqueTField, 0, 0, Short.MAX_VALUE))
										.addGroup(gl_mainPanel.createSequentialGroup()
												.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(bmiLbl).addComponent(eerLbl))
												.addGap(18)
												.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(eerTField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(bmiTField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_mainPanel.createSequentialGroup().addComponent(logoLbl).addGap(41)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(customerNameLbl).addComponent(ageLbl))))
				.addGap(18)
				.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_mainPanel
						.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_mainPanel
								.createSequentialGroup()
								.addComponent(ageTFIeld, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE).addComponent(
										openIntroMeetBtn, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_mainPanel.createSequentialGroup()
										.addComponent(customerNameField, GroupLayout.PREFERRED_SIZE, 256,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
										.addComponent(dateLbl).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(todayLbl))))
						.addGroup(gl_mainPanel.createSequentialGroup().addGap(20).addGroup(gl_mainPanel
								.createParallelGroup(Alignment.TRAILING)
								.addComponent(dinnerScrlPane, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
								.addComponent(summaryScrlPane, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
								.addComponent(lunchfastScrlPane, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
								.addComponent(breakfastScrlPane, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
								.addGroup(gl_mainPanel.createSequentialGroup().addComponent(snack1Lbl)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(snack1TField, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
								.addGroup(gl_mainPanel.createSequentialGroup().addComponent(snack2Lbl)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(snack2TField, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
								.addGroup(gl_mainPanel.createSequentialGroup().addGap(25).addComponent(menuLbl)
										.addGap(437))
								.addGroup(gl_mainPanel.createSequentialGroup().addComponent(prevSessionBtn).addGap(18)
										.addComponent(btnNewButton).addGap(26).addComponent(emailSummBtn))
								.addComponent(breakfastLbl, Alignment.LEADING).addComponent(lunchLbl, Alignment.LEADING)
								.addComponent(dinnerLbl, Alignment.LEADING))))
				.addGap(63))
				.addGroup(gl_mainPanel
						.createSequentialGroup().addGap(299).addComponent(gnrlSummTPane, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(675, Short.MAX_VALUE)));
		gl_mainPanel.setVerticalGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_mainPanel
				.createSequentialGroup()
				.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING).addComponent(logoLbl)
						.addGroup(gl_mainPanel.createSequentialGroup().addGroup(gl_mainPanel
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_mainPanel.createSequentialGroup().addGap(13)
										.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(customerNameLbl).addComponent(customerNameField,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(ageLbl).addComponent(ageTFIeld,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_mainPanel.createSequentialGroup().addContainerGap()
										.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(todayLbl).addComponent(dateLbl))
										.addGap(39).addComponent(openIntroMeetBtn, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(summaryScrlPane, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_mainPanel.createSequentialGroup()
												.addComponent(gnrlSummTPane, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(19)))))
				.addGap(16)
				.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_mainPanel.createSequentialGroup().addComponent(menuLbl).addGap(20)
								.addComponent(breakfastLbl))
						.addComponent(measuresLbl))
				.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_mainPanel
						.createSequentialGroup().addGap(18)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(weightLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(weightTField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(heightLbl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(heightTField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE).addComponent(wristLbl)
								.addComponent(wristTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(13)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE).addComponent(weistLbl)
								.addComponent(weistTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE).addComponent(thighLbl)
								.addComponent(thighTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblActivity, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNewRadioButton).addComponent(rdbtnNewRadioButton_2,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnNewRadioButton_1).addComponent(rdbtnNewRadioButton_3))
						.addGap(12))
						.addGroup(gl_mainPanel.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(
										breakfastScrlPane, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE).addComponent(snack1Lbl)
										.addComponent(snack1TField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(24).addComponent(lunchLbl).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lunchfastScrlPane, GroupLayout.PREFERRED_SIZE, 70,
										GroupLayout.PREFERRED_SIZE)
								.addGap(21)))
				.addGap(10)
				.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE).addComponent(snack2Lbl)
						.addComponent(snack2TField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(clearBtn).addComponent(calcBtn))
				.addGap(18)
				.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_mainPanel.createSequentialGroup()
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE).addComponent(bmiLbl)
										.addComponent(bmiTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(12))
						.addGroup(gl_mainPanel.createSequentialGroup().addComponent(dinnerLbl)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE).addGroup(gl_mainPanel
						.createSequentialGroup()
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING).addComponent(eerLbl).addComponent(
								eerTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE).addComponent(physiqueLbl)
								.addComponent(physiqueTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addComponent(dinnerScrlPane, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
				.addGap(61).addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE).addComponent(emailSummBtn)
						.addComponent(btnNewButton).addComponent(prevSessionBtn))
				.addGap(40)));

		////////////////////////////// Final window settings
		////////////////////////////// //////////////////////////////

		mainPanel.setLayout(gl_mainPanel);
		mainFrame.getContentPane().setLayout(groupLayout);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.pack();
	}

	// Helper method to get the selected radio button
	String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = (AbstractButton) buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}
}
