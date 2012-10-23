package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.github.ant2.exceedvote.model.VoterProfile;

import static javax.swing.SwingConstants.CENTER;

public class VotingProcessView extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;

	/**
	 * View delegate for VotingProcessView
	 * 
	 * @author dtinth
	 */
	public interface Delegate {

		/**
		 * Invoked when the vote button is clicked.
		 */
		void voteButtonClicked();

		/**
		 * Invoked when the change ballot link is clicked.
		 */
		void changeBallotLinkClicked();

	}

	private Delegate delegate;
	private Calendar finishTime;
	private JLabel countdownLabel;
	private JLabel userLabel;
	private JList projectList;

	public VotingProcessView() {
		super("eXceed Vote");
		initComponents();
	}

	private void initComponents() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		// status bar components
		userLabel = new JLabel();
		userLabel.setHorizontalAlignment(CENTER);

		countdownLabel = new JLabel();
		countdownLabel.setHorizontalAlignment(CENTER);
		countdownLabel.setFont(new Font("Arial", Font.BOLD, 12));
		countdownLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		// project list component
		projectList = new JList();
		projectList.setCellRenderer(new ProjectCellItemRenderer());

		JScrollPane scrollPane = new JScrollPane(projectList);
		scrollPane.setPreferredSize(new Dimension(300, 400));

		// vote button
		JButton voteButton = new JButton(new AbstractAction("Vote!") {
			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				delegate.voteButtonClicked();
			}
		});

		// change ballot link
		JButton changeBallot = new JButton(new AbstractAction(
				"<html><u>>> I want to change my ballot</u></html>") {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				delegate.changeBallotLinkClicked();
			}
		});
		changeBallot.setForeground(Color.BLUE);
		changeBallot.setFocusPainted(false);
		changeBallot.setMargin(new Insets(0, 0, 0, 0));
		changeBallot.setContentAreaFilled(false);
		changeBallot.setBorderPainted(false);
		changeBallot.setOpaque(false);

		voteButton.setFont(new Font("Arial", Font.BOLD, 50));
		voteButton.setDefaultCapable(true);

		JLabel clickVote = new JLabel(
				"When you want to vote, click on the VOTE button.");

		// mainPanel.add(voteButton, BorderLayout.SOUTH);
		/** */
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JPanel projectDisplayArea = new JPanel();
		JPanel projectInfo = new JPanel();
		JPanel teamInfo = new JPanel();
		JPanel statusBar = new JPanel();

		JLabel welcome = new JLabel(
				"<html>Welcome to eXceed vote<br><br>Please pick a project to view its information at the left.</html>");
		JTabbedPane projectInfoTab = new JTabbedPane();

		projectInfoTab.setPreferredSize(new Dimension(300, 400));
		welcome.setPreferredSize(new Dimension(280, 400));
		projectInfo.add(welcome);
		teamInfo.add(new JLabel("~~~"));
		projectInfoTab.addTab("Project Information", projectInfo);
		projectInfoTab.addTab("Team Information", teamInfo);

		projectDisplayArea.add(scrollPane, BorderLayout.WEST);
		projectDisplayArea.add(projectInfoTab, BorderLayout.CENTER);

		statusBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
		statusBar.setLayout(new BorderLayout());
		statusBar.add(userLabel, BorderLayout.WEST);
		statusBar.add(countdownLabel, BorderLayout.EAST);

		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(new JLabel("Select a project to view its information"),
				BorderLayout.NORTH);
		centerPanel.add(projectDisplayArea, BorderLayout.CENTER);

		southPanel.add(clickVote);
		southPanel.add(voteButton);
		southPanel.add(changeBallot);
		southPanel.add(statusBar);
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));

		// add(mainPanel, BorderLayout.CENTER);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

	}

	/**
	 * Sets the view delegate for this VotingProcessView.
	 * 
	 * @param delegate
	 *            the view delegate to set
	 */
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	/**
	 * Updates the remaining time on the user interface.
	 * 
	 * @param timeLeft
	 *            the time remaining, in seconds
	 */
	public void setRemainingTime(int timeLeft) {
		countdownLabel.setText(String.format("Remaining time: %d:%02d:%02d",
				timeLeft / 3600, timeLeft % 3600 / 60, timeLeft % 60));
	}

	/**
	 * Creates a BallotView for letting users fill data into the ballot.
	 * 
	 * @return a new BallotView
	 */
	public BallotView createBallotView() {
		return new BallotView(this);
	}

	/**
	 * Sets the voter profile.
	 * 
	 * @param profile
	 *            the VoterProfile to set
	 */
	public void setVoterProfile(VoterProfile profile) {
		userLabel.setText("Hello, " + profile.getName());
	}

	/**
	 * Returns the project list view.
	 * 
	 * @return the project list view
	 */
	public JList getProjectList() {
		return projectList;
	}

}
