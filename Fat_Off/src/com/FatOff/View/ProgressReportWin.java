package com.FatOff.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;
import java.awt.Component;

public class ProgressReportWin {
	
	private ArrayList<Double> bmiProg;
	private ArrayList<Double> waistProg;

	public ProgressReportWin(ArrayList<Double> bmiProgress , ArrayList<Double> weightProgress) {
		int itemCounter=1;
		this.bmiProg = bmiProgress;
		this.waistProg = weightProgress;

		JFrame progressReportFrame = new JFrame();
		progressReportFrame.setResizable(false);
		progressReportFrame.setTitle("Progress Report");
		progressReportFrame.setType(Type.POPUP);
		progressReportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel progressPanel = new JPanel();
		progressPanel.setBackground((new Color(36, 47, 65)));
		GroupLayout groupLayout = new GroupLayout(progressReportFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(progressPanel, GroupLayout.PREFERRED_SIZE, 394, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(progressPanel, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
		);
		
		JLabel logoLbl = new JLabel("");
		logoLbl.setIcon(new ImageIcon(ProgressReportWin.class.getResource("/com/FatOff/View/fat_off_white.png")));
		
		JLabel headerLbl = new JLabel("Customer Progress Report");
		headerLbl.setForeground(Color.WHITE);
		headerLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		JScrollPane reportScrlPane = new JScrollPane();
		
		JButton closeBtn = new JButton("Close");
		
		JLabel totalLbl = new JLabel("Total Progress: ");
		totalLbl.setForeground(Color.WHITE);
		totalLbl.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel bmiLbl = new JLabel("BMI:");
		bmiLbl.setForeground(Color.WHITE);
		bmiLbl.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel waistLbl = new JLabel("Waist:");
		waistLbl.setForeground(Color.WHITE);
		waistLbl.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel bmiPrecentLbl = new JLabel("");
		
		JLabel waistPrecentLbl = new JLabel("");
		
		GroupLayout gl_progressPanel = new GroupLayout(progressPanel);
		gl_progressPanel.setHorizontalGroup(
			gl_progressPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_progressPanel.createSequentialGroup()
					.addComponent(logoLbl)
					.addGap(18)
					.addComponent(headerLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(109))
				.addGroup(gl_progressPanel.createSequentialGroup()
					.addGap(108)
					.addComponent(closeBtn, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(207, Short.MAX_VALUE))
				.addGroup(gl_progressPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(reportScrlPane, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(89, Short.MAX_VALUE))
				.addGroup(gl_progressPanel.createSequentialGroup()
					.addGap(46)
					.addComponent(bmiLbl)
					.addGap(18)
					.addComponent(bmiPrecentLbl)
					.addGap(47)
					.addComponent(waistLbl)
					.addGap(18)
					.addComponent(waistPrecentLbl)
					.addContainerGap(132, Short.MAX_VALUE))
				.addGroup(gl_progressPanel.createSequentialGroup()
					.addGap(134)
					.addComponent(totalLbl)
					.addContainerGap(237, Short.MAX_VALUE))
		);
		gl_progressPanel.setVerticalGroup(
			gl_progressPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_progressPanel.createSequentialGroup()
					.addGroup(gl_progressPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(logoLbl)
						.addGroup(gl_progressPanel.createSequentialGroup()
							.addGap(62)
							.addComponent(headerLbl)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(reportScrlPane, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(totalLbl)
					.addGap(20)
					.addGroup(gl_progressPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(bmiLbl)
						.addComponent(waistLbl)
						.addComponent(bmiPrecentLbl)
						.addComponent(waistPrecentLbl))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(closeBtn)
					.addGap(35))
		);
		
		JPanel reportPanel = new JPanel();
		reportPanel.setBackground((new Color(36, 47, 65)));
		reportPanel.setLayout(new BoxLayout(reportPanel, BoxLayout.Y_AXIS));
		
		JPanel reportHeader = new JPanel();
		reportHeader.setBackground((new Color(36, 47, 65)));
		reportHeader.setLayout(new BoxLayout(reportHeader, BoxLayout.X_AXIS));
		
		JPanel fromToHeaderPanel = new JPanel();
		fromToHeaderPanel.setBackground((new Color(36, 47, 65)));
		fromToHeaderPanel.setLayout(new BoxLayout(fromToHeaderPanel, BoxLayout.Y_AXIS));
		
		reportHeader.add(fromToHeaderPanel);
		
		JPanel bmiHeaderPanel = new JPanel();
		bmiHeaderPanel.setBackground((new Color(36, 47, 65)));
		bmiHeaderPanel.setLayout(new BoxLayout(bmiHeaderPanel, BoxLayout.Y_AXIS));
		
		reportHeader.add(bmiHeaderPanel);
		
		JPanel waistHeaderPanel = new JPanel();
		waistHeaderPanel.setBackground((new Color(36, 47, 65)));
		waistHeaderPanel.setLayout(new BoxLayout(waistHeaderPanel, BoxLayout.Y_AXIS));
		
		reportHeader.add(waistHeaderPanel);
		
		JLabel sessHeader = new JLabel("From --> To    ");
		sessHeader.setForeground(Color.WHITE);
		sessHeader.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel bmiHeader = new JLabel("    BMI    ");
		bmiHeader.setForeground(Color.WHITE);
		bmiHeader.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel waistHeader = new JLabel("    Waist");
		waistHeader.setForeground(Color.WHITE);
		waistHeader.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		fromToHeaderPanel.add(sessHeader);
		bmiHeaderPanel.add(bmiHeader);
		waistHeaderPanel.add(waistHeader);
		
		reportPanel.add(reportHeader);
		
		Double lastBmi = bmiProg.get(bmiProg.size()-1);
		Double lastWaist = waistProg.get(waistProg.size()-1);
		
		if (lastBmi < 0) {
			bmiPrecentLbl.setText(new DecimalFormat("##.##").format((Double)lastBmi) + "%");
			bmiPrecentLbl.setForeground(Color.GREEN);
		}
		else {
			bmiPrecentLbl.setText("+"+new DecimalFormat("##.##").format((Double)lastBmi) + "%      ");
			bmiPrecentLbl.setForeground(Color.RED);
		}
		if (lastWaist < 0) {
			waistPrecentLbl.setText(new DecimalFormat("##.##").format((Double)lastWaist) + "%");
			waistPrecentLbl.setForeground(Color.GREEN);
		}
		else {
			waistPrecentLbl.setText("+"+new DecimalFormat("##.##").format((Double)lastWaist) + "%      ");
			waistPrecentLbl.setForeground(Color.RED);
		}
		
		bmiProg.remove(bmiProg.size()-1);
		waistProg.remove(waistProg.size()-1);
		
		Iterator<Double> bmi = bmiProg.iterator();
	    Iterator<Double> waist = waistProg.iterator();
	    
	    while (bmi.hasNext() && waist.hasNext()) {
	    	
	    	Double bmiEl = bmi.next();
	    	Double waistEl = waist.next();
	    	
			JLabel between = new JLabel("Session "+itemCounter+" - Session "+(itemCounter+1)+"      ");
			between.setForeground(Color.WHITE);
			between.setFont(new Font("Century Gothic", Font.BOLD, 14));
			JLabel bmiPrecent;
			JLabel waistPrecent;
			if (bmiEl < 0) {
				bmiPrecent = new JLabel(new DecimalFormat("##.##").format((Double)bmiEl) + "%      ");
				bmiPrecent.setForeground(Color.GREEN);
			}
			else {
				bmiPrecent = new JLabel("+"+new DecimalFormat("##.##").format((Double)bmiEl) + "%      ");
				bmiPrecent.setForeground(Color.RED);
			}
			if (waistEl < 0) {
				waistPrecent = new JLabel(new DecimalFormat("##.##").format((Double)waistEl) + "%      ");
				waistPrecent.setForeground(Color.GREEN);
			}
			else {
				waistPrecent = new JLabel("+"+new DecimalFormat("##.##").format((Double)waistEl) + "%      ");
				waistPrecent.setForeground(Color.RED);
			}
			bmiPrecent.setFont(new Font("Century Gothic", Font.BOLD, 14));
			waistPrecent.setFont(new Font("Century Gothic", Font.BOLD, 14));
			between.setVisible(true);
			bmiPrecent.setVisible(true);
			waistPrecent.setVisible(true);
			fromToHeaderPanel.add(between);
			bmiHeaderPanel.add(bmiPrecent);
			waistHeaderPanel.add(waistPrecent);
			itemCounter++;
		}
		
		reportScrlPane.setViewportView(reportPanel);
	
		progressPanel.setLayout(gl_progressPanel);
		progressReportFrame.getContentPane().setLayout(groupLayout);
		progressReportFrame.pack();
		progressReportFrame.setVisible(true);
		
	}
}


