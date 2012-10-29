package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;
	private JPanel topPanel;
	private MainPanel mainPanel;

	public MainView() {
		super("eXceed Vote");
		setLayout(new BorderLayout());
		setSize(720, 512);
		initComponents();
	}

	private void initComponents() {
		topPanel = new JPanel();
		topPanel.add(new JLabel("KI"));
		mainPanel = new MainPanel();
		add(topPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}
	
}
