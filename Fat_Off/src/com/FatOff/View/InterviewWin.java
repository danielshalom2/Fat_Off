/**
 * 
 */
package com.FatOff.View;

import javax.swing.*;

import com.FatOff.Model.Customer;
import com.itextpdf.text.DocumentException;
import com.FatOff.Controller.InterviewContoller;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

/**
 * @author borism
 *
 */
public class InterviewWin {

	public InterviewWin(Customer cust, String pathToCust) {
		JFrame interviewFrame = new JFrame("Introductory Meeting");
		interviewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		interviewFrame.getContentPane().setPreferredSize(new Dimension(10, 0));
		interviewFrame.getContentPane().setMaximumSize(new Dimension(32000, 32000));

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		panel.setBackground(new Color(36, 47, 65));
		panel.setForeground(new Color(255, 255, 255));

		JLabel copyRightLbl = new JLabel("All Rights Reserved© Fat Off Developers 2020");
		copyRightLbl.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		copyRightLbl.setForeground(new Color(255, 255, 255));
		copyRightLbl.setBackground(new Color(36, 47, 65));
		copyRightLbl.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(interviewFrame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addGap(248)
						.addComponent(copyRightLbl, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE).addGap(102)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(copyRightLbl).addGap(9)));

		JLabel logoLbl = new JLabel("");
		logoLbl.setIcon(new ImageIcon(
				InterviewWin.class.getResource("/com/FatOff/View/fat_off_white.png")));

		JLabel introInterviewLbl = new JLabel("Fat-Off Introductory Interview");
		introInterviewLbl.setForeground(new Color(255, 255, 255));
		introInterviewLbl.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));

		JTextPane txtpnWelcomeToThe = new JTextPane();
		txtpnWelcomeToThe.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtpnWelcomeToThe.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.windowBorder, null, null, null));
		txtpnWelcomeToThe.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnWelcomeToThe.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
		txtpnWelcomeToThe.setText(
				"Welcome to the introductory interivew window.\nThe purpose of this stage of the customer creation is the following:\n\n    * To introduce myself.\n    * To introduce my approach to the procedure.\n    * To explain about the procedure.\n    * To talk about payment arrangement.\n    * To get familiar with the customer.");
		txtpnWelcomeToThe.setSelectionColor(SystemColor.textHighlight);
		txtpnWelcomeToThe.setBackground(SystemColor.window);
		txtpnWelcomeToThe.setEditable(false);
		txtpnWelcomeToThe.setDropMode(DropMode.INSERT);

		JScrollPane interviewScrollPane = new JScrollPane();
		interviewScrollPane.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(64, 64, 64)),
				"Interview Questions", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		interviewScrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		interviewScrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		interviewScrollPane.setMaximumSize(new Dimension(32767, 30000));
		interviewScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JPanel interviewPanel = new JPanel();
		interviewPanel.setAutoscrolls(true);
		interviewPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		interviewPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		interviewScrollPane.setViewportView(interviewPanel);

		JLabel decisionQtLbl = new JLabel("Why have you decided to come to a dietician?");
		decisionQtLbl.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		decisionQtLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane decisionAScroll = new JScrollPane();

		JLabel yourGoalQLbl = new JLabel("What is your goal?");
		yourGoalQLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane goalAScroll = new JScrollPane();

		JLabel someonePushedQLbl = new JLabel("Has someone pushed you to go to a dietician? Please elaborate..");
		someonePushedQLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane someonePushedAScroll = new JScrollPane();

		JLabel hadDieticianQLbl = new JLabel("Have you ever started a process with a dietician? Please elaborate..");
		hadDieticianQLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane hadDieticianAScroll = new JScrollPane();

		JLabel concentrationQLbl = new JLabel("Do you have troubles with concentrating recently?");
		concentrationQLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane concentrationAScroll = new JScrollPane();

		JLabel gainedLostQLbl = new JLabel("Have you recently gained or lost weight unexpectedly?");
		gainedLostQLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane gainedLostAScroll = new JScrollPane();

		JLabel digestionQLbl = new JLabel("Where there any digestion problems (diarrhea, vomiting, Lack of appetite)?");
		digestionQLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane digestionAScroll = new JScrollPane();

		JLabel typicalDayQLbl = new JLabel("Typical day (Wakeup time, daily activity, work hours, work type," + "\n"
				+ "sport actvity (How often))...");
		typicalDayQLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane typicalDayAScroll = new JScrollPane();

		JLabel whatAteQLbl = new JLabel("Describe what you ate yesterday (or any other specific day).");
		whatAteQLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane whatAteAScroll = new JScrollPane();

		JLabel alergiesQLbl = new JLabel("Do you have any alergies? Please elaborate..");
		alergiesQLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane alergiesAScroll = new JScrollPane();

		JLabel foodNotLikeQLbl = new JLabel("Are there any food product you don't like? Please elaborate..");
		foodNotLikeQLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane foodNotLikeAScroll = new JScrollPane();

		JLabel deseasMedQLbl = new JLabel("Are there any backgroud deseases? Any medications you take?");
		deseasMedQLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));

		JScrollPane deseasMedAScroll = new JScrollPane();

		GroupLayout gl_interviewPanel = new GroupLayout(interviewPanel);
		gl_interviewPanel.setHorizontalGroup(gl_interviewPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_interviewPanel.createSequentialGroup().addGroup(gl_interviewPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(decisionQtLbl, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
								.addGap(248))
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(yourGoalQLbl, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE).addGap(248))
						.addGroup(gl_interviewPanel.createSequentialGroup().addGap(38).addGroup(gl_interviewPanel
								.createParallelGroup(Alignment.TRAILING)
								.addComponent(goalAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addComponent(decisionAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addComponent(someonePushedAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addComponent(hadDieticianAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addComponent(concentrationAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addComponent(gainedLostAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addComponent(digestionAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addComponent(typicalDayAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addComponent(whatAteAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addComponent(alergiesAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addComponent(foodNotLikeAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addComponent(deseasMedAScroll, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)))
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(hadDieticianQLbl, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
								.addGap(78))
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(concentrationQLbl, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
								.addGap(78))
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(gainedLostQLbl, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
								.addGap(78))
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(alergiesQLbl, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE).addGap(78))
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(foodNotLikeQLbl, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
								.addGap(78))
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(someonePushedQLbl, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
								.addGap(78))
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(whatAteQLbl, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE).addGap(78))
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(digestionQLbl, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE).addGap(78))
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(deseasMedQLbl, GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
						.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap()
								.addComponent(typicalDayQLbl, GroupLayout.PREFERRED_SIZE, 655, Short.MAX_VALUE)))
						.addGap(78)));
		gl_interviewPanel.setVerticalGroup(gl_interviewPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_interviewPanel.createSequentialGroup().addContainerGap().addComponent(decisionQtLbl)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(decisionAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(yourGoalQLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(goalAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(someonePushedQLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(someonePushedAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(hadDieticianQLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(hadDieticianAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(concentrationQLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(concentrationAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(gainedLostQLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(gainedLostAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(digestionQLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(digestionAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(typicalDayQLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(typicalDayAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(whatAteQLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(whatAteAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(alergiesQLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(alergiesAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(deseasMedQLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(deseasMedAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(foodNotLikeQLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(foodNotLikeAScroll, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE)));

		JTextPane gainedLostATPane = new JTextPane();
		gainedLostAScroll.setViewportView(gainedLostATPane);

		JTextPane concentrationATPane = new JTextPane();
		concentrationAScroll.setViewportView(concentrationATPane);

		JTextPane hadDieticianATPane = new JTextPane();
		hadDieticianAScroll.setViewportView(hadDieticianATPane);

		JTextPane someonePushedATPane = new JTextPane();
		someonePushedAScroll.setViewportView(someonePushedATPane);

		JTextPane goalATPane = new JTextPane();
		goalAScroll.setViewportView(goalATPane);

		JTextPane decisionATPane = new JTextPane();
		decisionAScroll.setViewportView(decisionATPane);

		JTextPane digestionATPane = new JTextPane();
		digestionAScroll.setViewportView(digestionATPane);

		JTextPane typicalDayATPane = new JTextPane();
		typicalDayAScroll.setViewportView(typicalDayATPane);

		JTextPane whatAteATPane = new JTextPane();
		whatAteAScroll.setViewportView(whatAteATPane);

		JTextPane alergiesATPane = new JTextPane();
		alergiesAScroll.setViewportView(alergiesATPane);

		JTextPane foodNotLikeATPane = new JTextPane();
		foodNotLikeAScroll.setViewportView(foodNotLikeATPane);

		JTextPane deseasMedATPane = new JTextPane();
		deseasMedAScroll.setViewportView(deseasMedATPane);
		interviewPanel.setLayout(gl_interviewPanel);

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBackground(new Color(97, 212, 195));
		cancelBtn.setBorder(null);
		cancelBtn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				interviewFrame.dispose();
				
			}
		});

		ButtonGroup radios = new ButtonGroup();

		JRadioButton sedentaryRadio = new JRadioButton("Sedentary");
		sedentaryRadio.setBackground(new Color(36, 47, 65));
		sedentaryRadio.setForeground(new Color(255, 255, 255));
		radios.add(sedentaryRadio);

		JRadioButton lowActiveRadio = new JRadioButton("Low Active");
		lowActiveRadio.setBackground(new Color(36, 47, 65));
		lowActiveRadio.setForeground(new Color(255, 255, 255));
		radios.add(lowActiveRadio);

		JRadioButton activeRadio = new JRadioButton("Active");
		activeRadio.setBackground(new Color(36, 47, 65));
		activeRadio.setForeground(new Color(255, 255, 255));
		radios.add(activeRadio);

		JRadioButton veryActiveRadio = new JRadioButton("Very Active");
		veryActiveRadio.setBackground(new Color(36, 47, 65));
		veryActiveRadio.setForeground(new Color(255, 255, 255));
		radios.add(veryActiveRadio);

		JLabel activityLevelLbl = new JLabel("Activity Level:");
		activityLevelLbl.setBackground(new Color(36, 47, 65));
		activityLevelLbl.setForeground(new Color(255, 255, 255));

		JButton saveBtn = new JButton("Save");
		saveBtn.setForeground(new Color(255, 255, 255));
		saveBtn.setBackground(new Color(97, 212, 195));
		saveBtn.setBorder(null);
		saveBtn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InterviewContoller.createIntroMeeting(decisionATPane.getText(), goalATPane.getText(),
							hadDieticianATPane.getText(), someonePushedATPane.getText(), digestionATPane.getText(),
							typicalDayATPane.getText(), whatAteATPane.getText(), alergiesATPane.getText(),
							foodNotLikeATPane.getText(), deseasMedATPane.getText(), concentrationATPane.getText(),
							gainedLostATPane.getText(), cust, pathToCust);
					interviewFrame.dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(activityLevelLbl)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(sedentaryRadio)
								.addComponent(activeRadio))
							.addGap(22)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(veryActiveRadio)
								.addComponent(lowActiveRadio))
							.addGap(215)
							.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(interviewScrollPane, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(logoLbl)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(txtpnWelcomeToThe, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(74)
									.addComponent(introInterviewLbl, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))))
					.addGap(11))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(introInterviewLbl)
							.addGap(18)
							.addComponent(txtpnWelcomeToThe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(logoLbl, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(interviewScrollPane, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lowActiveRadio)
								.addComponent(sedentaryRadio))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(veryActiveRadio)
								.addComponent(activeRadio)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(activityLevelLbl)))
					.addGap(10))
		);
		panel.setLayout(gl_panel);
		interviewFrame.getContentPane().setLayout(groupLayout);
		interviewFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		interviewFrame.setVisible(true);

	}
}
