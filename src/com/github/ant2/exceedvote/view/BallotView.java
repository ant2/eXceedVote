package com.github.ant2.exceedvote.view;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.ui.view.BigButton;
import com.github.ant2.ui.view.RadioSelectionPanel;

/**
 * The user-interface that ask the voter to select the projects to vote on by
 * the available criteria. Display after the Vote button was clicked from the
 * main UI.
 * 
 * @author dtinth
 */
public class BallotView extends JDialog {

	/**
	 * View delegate for BallotView.
	 * 
	 * @author dtinth
	 */
	public interface Delegate {

		/**
		 * Invoked when the submit button is clicked.
		 */
		void submitButtonClicked();

	}

	/** */
	private static final long serialVersionUID = 1L;

	private Delegate delegate;
	private RadioSelectionPanel projectSelectView;
	private RadioSelectionPanel criterionSelectView;

	/**
	 * Construct a window that ask the voter to select project and criterion to
	 * vote on and submit the voter's desired option.
	 * 
	 * @param parent
	 */
	public BallotView(Frame parent) {
		super(parent, true);
		setTitle("Vote for Project");
		initComponents();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	/**
	 * Set the view delegate for this BallotView.
	 * 
	 * @param delegate
	 */
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	private void initComponents() {
		setLayout(new GridBagLayout());

		projectSelectView = new RadioSelectionPanel();
		criterionSelectView = new RadioSelectionPanel();

		JButton submitButton = new BigButton(new AbstractAction("Submit") {
			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				delegate.submitButtonClicked();
			}
		});

		GridBagConstraints c = UIUtility.createVerticalGridBagConstrints();

		add(UIUtility.createPaddedStepPanel("1", "Select a project",
				projectSelectView), c);
		add(UIUtility.createPaddedStepPanel("2", "Select a criterion",
				criterionSelectView), c);
		add(UIUtility.createPaddedStepPanel("3", "Click submit", submitButton),
				c);

	}

	public RadioSelectionPanel getProjectSelectView() {
		return projectSelectView;
	}

	public RadioSelectionPanel getCriterionSelectView() {
		return criterionSelectView;
	}

	/**
	 * Display dialog to ask the voter to confirm their decision.
	 * 
	 * @return the voter's confirmation, true if the voter clicked Yes,
	 *         otherwise false
	 */
	public boolean confirmVoting() {
		int result = JOptionPane.showConfirmDialog(this, "Are you sure?",
				"eXceed Vote Confirmation", JOptionPane.YES_NO_OPTION);
		return result == JOptionPane.YES_OPTION;
	}

	/**
	 * Display the error message to notify voter that something when wrong.
	 * Describe the problem that occurring and make the voting process doesn't
	 * success.
	 * 
	 * @param errorMessage
	 *            message to display describing the problem
	 */
	public void displayError(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage, "Error!",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Display the confirmation that the ballot which have voter's selected
	 * project and criterion has been successfully submit and display the
	 * available ballots left for the voter.
	 * 
	 * @param ballots
	 *            voter's available ballots left
	 */
	public void displaySuccess(int ballots) {
		JOptionPane.showMessageDialog(this,
				"Thank you for your vote! You have " + ballots
						+ " ballots left.", "Success!",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
