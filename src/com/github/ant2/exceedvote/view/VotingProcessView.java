package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

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

	}

	private Delegate delegate;
	private Calendar finishTime;
	private JLabel countdownLabel;
	private JList projectList;
	private JLabel userLabel;

	public VotingProcessView() {
		super("eXceed Vote");
		initComponents();
	}

	private void initComponents() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		userLabel = new JLabel();
		userLabel.setHorizontalAlignment(CENTER);
		add(userLabel, BorderLayout.NORTH);

		JPanel mainPanel = new JPanel(new BorderLayout());

		countdownLabel = new JLabel();
		countdownLabel.setHorizontalAlignment(CENTER);
		countdownLabel.setFont(new Font("Arial", Font.BOLD, 18));
		countdownLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		mainPanel.add(countdownLabel, BorderLayout.NORTH);

		new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateRemainingTime();
			}
		}).start();

		projectList = new JList();
		projectList.setCellRenderer(new ProjectCellItemRenderer());

		JScrollPane scrollPane = new JScrollPane(projectList);
		scrollPane.setPreferredSize(new Dimension(300, 400));

		mainPanel.add(scrollPane, BorderLayout.CENTER);

		JButton voteButton = new JButton(new AbstractAction("Vote!") {
			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				delegate.voteButtonClicked();
			}
		});

		voteButton.setFont(new Font("Arial", Font.BOLD, 50));
		voteButton.setDefaultCapable(true);

		mainPanel.add(voteButton, BorderLayout.SOUTH);

		add(mainPanel, BorderLayout.CENTER);

	}

	/**
	 * Sets the view delegate for this VotingProcessView.
	 * 
	 * @param delegate the view delegate to set
	 */
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	/**
	 * Sets the finish time of this view.
	 * 
	 * @param finishTime the finishing time
	 */
	public void setFinishTime(Calendar finishTime) {
		this.finishTime = finishTime;
		updateRemainingTime();
	}

	/**
	 * Updates the remaining time on the user interface.
	 */
	private void updateRemainingTime() {
		long timeLeft = finishTime.getTimeInMillis()
				- Calendar.getInstance().getTimeInMillis();
		countdownLabel.setText(String.format("Remaining time: %d:%02d:%02d",
				timeLeft / (3600 * 1000), (timeLeft % (3600 * 1000))
						/ (60 * 1000), (timeLeft % (60 * 1000)) / 1000));
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
	 * @param profile the VoterProfile to set
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
