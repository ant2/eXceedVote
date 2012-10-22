package com.github.ant2.exceedvote.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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

		/**
		 * Invoked when voter selected the project from one of the project list.
		 * 
		 * @param option
		 *            current selected project
		 */
		void projectSelected(Object option);

		/**
		 * Invoked when voter selected one of the available criteria.
		 * 
		 * @param option
		 *            current selected criterion
		 */
		void criterionSelected(Object option);
	}

	/** */
	private static final long serialVersionUID = 1L;

	private Delegate delegate;
	private RadioSelectView projectSelectView;
	private RadioSelectView criterionSelectView;

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
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JPanel projectsPanel = new JPanel();
		JPanel criteriaPanel = new JPanel();

		projectsPanel.setBorder(BorderFactory
				.createTitledBorder(" Select Project "));
		criteriaPanel.setBorder(BorderFactory
				.createTitledBorder(" Pick a Criterion "));

		projectSelectView = new RadioSelectView();
		criterionSelectView = new RadioSelectView();

		projectSelectView.setDelegate(new RadioSelectView.Delegate() {
			@Override
			public void optionSelected(Object option) {
				delegate.projectSelected(option);
			}
		});

		criterionSelectView.setDelegate(new RadioSelectView.Delegate() {
			@Override
			public void optionSelected(Object option) {
				delegate.criterionSelected(option);
			}
		});

		projectsPanel.add(projectSelectView);
		criteriaPanel.add(criterionSelectView);

		JButton submitButton = new JButton(new AbstractAction("Submit") {
			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				delegate.submitButtonClicked();
			}
		});

		add(projectsPanel);
		add(criteriaPanel);
		add(submitButton);

	}

	@SuppressWarnings("rawtypes")
	public void addProjectOptions(Iterable projectOptions) {
		projectSelectView.addOptions(projectOptions);
	}

	@SuppressWarnings("rawtypes")
	public void addCriterionOptions(Iterable criterionOptions) {
		criterionSelectView.addOptions(criterionOptions);
	}

	public void setSelectedProject(Object item) {
		projectSelectView.selectOption(item);
	}

	public void setSelectedCriterion(Object item) {
		criterionSelectView.selectOption(item);
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
