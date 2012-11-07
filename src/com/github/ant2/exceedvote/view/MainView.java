package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.ant2.exceedvote.ui.theme.ThemeColor;
import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.ui.activity.ActivityPanel;

public class MainView extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;
	private JPanel topPanel;
	private ActivityPanel mainPanel;
	private InfoBox nameInfoBox;
	private InfoBox remainingTimeInfoBox;
	private JButton logout;

	public MainView() {
		super("eXceed Vote");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(720, 680);
		initComponents();
	}

	private void initComponents() {
		topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		topPanel.setBackground(ThemeColor.TOP_BACKGROUND);
		UIUtility.addPadding(topPanel, 10, 10, 10, 10);

		nameInfoBox = new InfoBox("Name", "Aiolia");
		topPanel.add(nameInfoBox);

		remainingTimeInfoBox = new InfoBox("Remaining Time", "88:88:88");
		topPanel.add(remainingTimeInfoBox);
		UIUtility.addPadding(remainingTimeInfoBox, 0, 12, 0, 0);
		topPanel.add(Box.createHorizontalGlue());

		logout = new JButton("Logout");
		topPanel.add(logout);

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
