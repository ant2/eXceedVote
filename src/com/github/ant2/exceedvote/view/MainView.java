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

/**
 * The main view for Voter.
 * 
 * @author dtinth
 */
public class MainView extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;
	private JPanel topPanel;
	private ActivityPanel mainPanel;
	private InfoBox nameInfoBox;
	private InfoBox remainingTimeInfoBox;
	private JButton logoutButton;

	/**
	 * Constructs a new Main View.
	 */
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

		logoutButton = new JButton("Logout");
		topPanel.add(logoutButton);

		mainPanel = new ActivityPanel();
		add(topPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
	}

	/**
	 * Gets the remaining time info box.
	 * 
	 * @return the remaining time info box
	 */
	public InfoBox getRemainingTimeInfoBox() {
		return remainingTimeInfoBox;
	}

	/**
	 * Gets the name info box.
	 * 
	 * @return the name info box
	 */
	public InfoBox getNameInfoBox() {
		return nameInfoBox;
	}

	/**
	 * Gets the main panel.
	 * 
	 * @return the main activity panel
	 */
	public ActivityPanel getMainPanel() {
		return mainPanel;
	}

	/**
	 * Gets the logout button
	 * 
	 * @return the logout button
	 */
	public JButton getLogoutButton() {
		return logoutButton;
	}
}
