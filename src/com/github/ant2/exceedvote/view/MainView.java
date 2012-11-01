package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.ui.activity.ActivityPanel;
import com.github.ant2.ui.view.InfoBox;

public class MainView extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;
	private JPanel topPanel;
	private ActivityPanel mainPanel;
	private InfoBox nameInfoBox;
	private InfoBox remainingTimeInfoBox;

	public MainView() {
		super("eXceed Vote");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(720, 512);
		initComponents();
	}

	private void initComponents() {
		topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		UIUtility.addPadding(topPanel, 10, 10, 5, 10);
		
		//name label

		nameInfoBox = new InfoBox("Name", "Aiolia");
		topPanel.add(nameInfoBox);
		
		remainingTimeInfoBox = new InfoBox("Remaining Time", "88:88:88");
		topPanel.add(remainingTimeInfoBox);
		UIUtility.addPadding(remainingTimeInfoBox, 0, 50, 0, 0);
		topPanel.add(Box.createHorizontalGlue());
		topPanel.add(new JLabel("FuCK"));

		mainPanel = new ActivityPanel();
		add(topPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
	}

	public InfoBox getRemainingTimeInfoBox() {
		return remainingTimeInfoBox;
	}
	
	public InfoBox getNameInfoBox() {
		return nameInfoBox;
	}
	
	public ActivityPanel getMainPanel() {
		return mainPanel;
	}

}
