package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.ant2.ui.activity.ActivityPanel;

public class MainView extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;
	private JPanel topPanel;
	private ActivityPanel mainPanel;

	public MainView() {
		super("eXceed Vote");
		setLayout(new BorderLayout());
		setSize(720, 512);
		initComponents();
	}

	private void initComponents() {
		topPanel = new JPanel();
		topPanel.add(new JLabel("KI"));
		mainPanel = new ActivityPanel();
		add(topPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
	}

	public ActivityPanel getMainPanel() {
		return mainPanel;
	}

}
