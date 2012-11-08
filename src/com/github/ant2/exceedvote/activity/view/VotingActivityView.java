package com.github.ant2.exceedvote.activity.view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.exceedvote.view.Scene;
import com.github.ant2.ui.activity.ActivityView;

public class VotingActivityView extends ActivityView {

	/** */
	private static final long serialVersionUID = 1L;
	private JButton cancelButton;
	private JButton submitButton;
	private Scene scene;
	private JPanel grid;
	private JLabel ballotLeftLabel;

	public VotingActivityView() {
		JPanel panel = new JPanel(new GridBagLayout());
		grid = new JPanel(new GridLayout(0, 3, 5, 5));

		JPanel votePanel = new JPanel(new BorderLayout());
		votePanel.add(grid, BorderLayout.CENTER);
		ballotLeftLabel = new JLabel("You have N ballots blah blah blah");
		votePanel.add(ballotLeftLabel, BorderLayout.NORTH);
		
		panel.add(
				UIUtility
						.createStepPanel(
								"Click the buttons to assign ballots to each project...",
								votePanel), UIUtility
						.createVerticalGridBagConstrints());

		scene = new Scene("Voting Criteria", panel);
		cancelButton = scene.addFooterButton("Cancel");
		submitButton = scene.addFooterButton("Submit");
		add(scene);
	}

	public ProjectVoteView addProjectVoteView() {
		ProjectVoteView view = new ProjectVoteView();
		grid.add(view);
		return view;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getSubmitButton() {
		return submitButton;
	}

	public void setTitle(String title) {
		scene.setTitle(title);
	}
	
	public void setBallotLeftLabelText(String text) {
		ballotLeftLabel.setText(text);
	}

}
