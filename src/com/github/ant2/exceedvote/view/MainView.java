package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.ui.activity.ActivityPanel;

public class MainView extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;
	private JPanel topPanel;
	private ActivityPanel mainPanel;

	public MainView() {
		super("eXceed Vote");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(720, 512);
		initComponents();
	}

	private void initComponents() {
		topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		UIUtility.addPadding(topPanel, 10, 10, 5, 10);
		
		//name label
		JPanel namePanel = new JPanel(new BorderLayout());
		JLabel panelName = new JLabel("Name");
		JLabel name = new JLabel("KIKI");
		namePanel.add(panelName, BorderLayout.NORTH);
		namePanel.add(name, BorderLayout.CENTER);
		namePanel.setMaximumSize(new Dimension(192, 50));
		topPanel.add(namePanel);
		
		//countdown label
		JPanel countdownPanel = new JPanel(new BorderLayout());
		JLabel panelName2 = new JLabel("Remaining Time");
		JLabel time = new JLabel("88:88:88");
		countdownPanel.add(panelName2, BorderLayout.NORTH);
		countdownPanel.add(time, BorderLayout.SOUTH);
		countdownPanel.setMaximumSize(new Dimension(192, 50));
		UIUtility.addPadding(countdownPanel, 0, 50, 0, 0);
		topPanel.add(countdownPanel);
		topPanel.add(Box.createHorizontalGlue());
		topPanel.add(new JLabel("FuCK"));
		
		
		
		mainPanel = new ActivityPanel();
		add(topPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
	}

	public ActivityPanel getMainPanel() {
		return mainPanel;
	}

}
