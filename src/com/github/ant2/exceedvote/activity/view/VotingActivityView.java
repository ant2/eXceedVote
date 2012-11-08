package com.github.ant2.exceedvote.activity.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		JPanel panel = new JPanel(new BorderLayout());
		grid = new JPanel(new GridLayout(0, 3, 7, 7));

		JPanel votePanel = new JPanel(new BorderLayout());
		votePanel.add(grid, BorderLayout.CENTER);

		ballotLeftLabel = new JLabel("You have N ballots blah blah blah");
		ballotLeftLabel.setFont(new Font("sans-serif", Font.PLAIN, 16));
		//ballotLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UIUtility.addPadding(ballotLeftLabel, 8, 3, 12, 0);

		votePanel.add(ballotLeftLabel, BorderLayout.NORTH);

		panel.add(UIUtility.createPaddedStepPanel(">",
				"Click the buttons to assign ballots to each project...",
				votePanel), BorderLayout.NORTH);
		panel.add(new JPanel());

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
