package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.github.ant2.exceedvote.model.VoterProfile;
import com.github.ant2.exceedvote.util.UIUtility;

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

		initProjectListAndInformationArea();
		initBottomArea();

	}

	private void initProjectListAndInformationArea() {

		JPanel centerPanel = new JPanel(new BorderLayout());
		UIUtility.addPadding(centerPanel, UIUtility.SMALL_PADDING);

		// NORTH: hint label
		centerPanel
				.add(new HintView("1",
						"Select a project to view its information"),
						BorderLayout.NORTH);

		// WEST: list component
		projectList = new JList();
		projectList.setCellRenderer(new ProjectCellItemRenderer());
		JScrollPane scrollPane = new JScrollPane(projectList);

		scrollPane.setPreferredSize(new Dimension(300, 400));
		centerPanel.add(scrollPane, BorderLayout.WEST);

		// CENTER: project information
		JTabbedPane projectInfoTab = new JTabbedPane();
		JLabel welcome = new JLabel(
				"<html><h1>Welcome to eXceed vote</h1><br><br>Please pick a project to view its information at the left.</html>");
		projectInfoTab.addTab("Project Information", welcome);
		projectInfoTab.addTab("Team Information",
				new JLabel("team information"));
		centerPanel.add(projectInfoTab, BorderLayout.CENTER);

		// FINALLY: add
		add(centerPanel, BorderLayout.CENTER);

	}

	private void initBottomArea() {

		JPanel southPanel = new JPanel(new GridBagLayout());
		UIUtility.addPadding(southPanel, UIUtility.SMALL_PADDING);

		// Hint label
		southPanel.add(new HintView("2",
				"When you want to vote, click on the VOTE button."), UIUtility
				.createVerticalGridBagConstrints());

		// Vote button
		BigButton voteButton = new BigButton(new AbstractAction("Vote!") {

			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				delegate.voteButtonClicked();
			}
		});
		southPanel.add(voteButton, UIUtility.createVerticalGridBagConstrints());

		// I want to change my ballot
		LinkButton changeBallot = new LinkButton(new AbstractAction(
				">> I want to change my ballot") {

			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				delegate.changeBallotLinkClicked();
			}
		});

		southPanel.add(changeBallot, createLinkGridBagConstraints(2));

		// Status bar
		southPanel.add(initStatusBar(southPanel),
				UIUtility.createVerticalGridBagConstrints());

		// ADD
		add(southPanel, BorderLayout.SOUTH);

	}

	private GridBagConstraints createLinkGridBagConstraints(int i) {
		GridBagConstraints gridBagConstraints = UIUtility
				.createVerticalGridBagConstrints();
		gridBagConstraints.fill = GridBagConstraints.NONE;
		gridBagConstraints.anchor = GridBagConstraints.LINE_END;
		return gridBagConstraints;
	}

	private JPanel initStatusBar(JPanel southPanel) {

		JPanel statusBar = new JPanel(new BorderLayout());
		statusBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
		UIUtility.addPadding(statusBar, 30, 0, 0, 0);

		// User
		userLabel = new JLabel();
		statusBar.add(userLabel, BorderLayout.CENTER);

		// Count down
		countdownLabel = new JLabel();
		countdownLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		countdownLabel.setFont(new Font("Arial", Font.BOLD, 12));
		countdownLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		statusBar.add(countdownLabel, BorderLayout.EAST);

		return statusBar;

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

	public ChangeBallotView createChangeBallotView() {
		return new ChangeBallotView(this);
	}

}
