/**
 * 
 */
package com.FatOff.View;

import javax.swing.*;

import com.FatOff.Model.Customer;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.text.StyledEditorKit.UnderlineAction;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.border.BevelBorder;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

/**
 * @author borism
 *
 */
public class InterviewWin {
	
	public InterviewWin(Customer cust) {
		JFrame interviewFrame = new JFrame("Introductory Meeting");
		
		JPanel panel = new JPanel();
		
		JLabel copyRightLbl = new JLabel("All Rights Reserved© Fat Off Developers 2020");
		
		JScrollPane interviewScrollPane = new JScrollPane();
		interviewScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout groupLayout = new GroupLayout(interviewFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(interviewScrollPane, Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(166)
								.addComponent(copyRightLbl))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(interviewScrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(copyRightLbl))
		);
		
		JPanel interviewPanel = new JPanel();
		interviewPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		interviewScrollPane.setViewportView(interviewPanel);
		
		JLabel decidionQuestLbl = new JLabel("Why have you decided to come to a dietician?");
		decidionQuestLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		decidionQuestLbl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout gl_interviewPanel = new GroupLayout(interviewPanel);
		gl_interviewPanel.setHorizontalGroup(
			gl_interviewPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_interviewPanel.createSequentialGroup()
					.addGroup(gl_interviewPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_interviewPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(decidionQuestLbl))
						.addGroup(gl_interviewPanel.createSequentialGroup()
							.addGap(38)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(313, Short.MAX_VALUE))
		);
		gl_interviewPanel.setVerticalGroup(
			gl_interviewPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_interviewPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(decidionQuestLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(353, Short.MAX_VALUE))
		);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		interviewPanel.setLayout(gl_interviewPanel);
		
		JLabel logoLbl = new JLabel("");
		logoLbl.setIcon(new ImageIcon(InterviewWin.class.getResource("/com/FatOff/View/imgonline-com-ua-resize-5aRADIEx30404X17.png")));
		
		JLabel introInterviewLbl = new JLabel("Fat-Off Introductory Interview");
		introInterviewLbl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		JTextPane txtpnWelcomeToThe = new JTextPane();
		txtpnWelcomeToThe.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.windowBorder, null, null, null));
		txtpnWelcomeToThe.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnWelcomeToThe.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
		txtpnWelcomeToThe.setText("Welcome to the introductory interivew window.\nThe purpose of this stage of the customer creation is the following:\n\n    * To introduce myself.\n    * To introduce my approach to the procedure.\n    * To explain about the procedure.\n    * To talk about payment arrangement.\n    * To get familiar with the customer.");
		txtpnWelcomeToThe.setSelectionColor(SystemColor.textHighlight);
		txtpnWelcomeToThe.setBackground(SystemColor.window);
		txtpnWelcomeToThe.setEditable(false);
		txtpnWelcomeToThe.setDropMode(DropMode.INSERT);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addComponent(logoLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(135)
							.addComponent(introInterviewLbl)
							.addContainerGap(37, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtpnWelcomeToThe, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
							.addGap(33))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(logoLbl, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(introInterviewLbl)
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addComponent(txtpnWelcomeToThe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(464, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		interviewFrame.getContentPane().setLayout(groupLayout);
										
		
	}
}
