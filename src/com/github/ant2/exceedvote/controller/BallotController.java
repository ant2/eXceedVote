package com.github.ant2.exceedvote.controller;

import java.util.List;

import com.github.ant2.exceedvote.model.Ballot;
import com.github.ant2.exceedvote.model.Criterion;
import com.github.ant2.exceedvote.model.Project;
import com.github.ant2.exceedvote.model.Rules.ValidationResult;
import com.github.ant2.exceedvote.model.VotingProcess;
import com.github.ant2.exceedvote.view.BallotView;
import com.github.ant2.exceedvote.view.BallotView.Delegate;

public class BallotController implements Delegate {

	private VotingProcess process;
	private Ballot model;
	private Ballot oldBallot;
	private BallotView view;

	private RadioSelectionController<Project> projectSelectionController;
	private RadioSelectionController<Criterion> criterionSelectionController;
	private List<Project> availableProjects;
	private List<Criterion> availableCriteria;

	public BallotController(VotingProcess process, Ballot model, BallotView view) {

		this.process = process;
		this.model = model;
		this.view = view;

		availableProjects = process.getAvailableProjects();
		availableCriteria = process.getAvailableCriteria();

		projectSelectionController = new RadioSelectionController<Project>(
				view.getProjectSelectView(), availableProjects);
		criterionSelectionController = new RadioSelectionController<Criterion>(
				view.getCriterionSelectView(), availableCriteria);

		projectSelectionController.setSelection(model.getProject());
		criterionSelectionController.setSelection(model.getCriterion());

		view.setDelegate(this);

	}

	public void show() {
		view.pack();
		view.setVisible(true);
	}

	/**
	 * Returns the human-readable error message for the validation result.
	 * 
	 * @param result
	 *            the validation result
	 * @return the human readable message
	 */
	public String errorMessage(ValidationResult result) {
		switch (result) {
		case NO_CRITERION_SELECTED:
			return "Please select a criterion";
		case NO_PROJECT_SELECTED:
			return "Please select a project.";
		case QUOTA_EXCEEDED:
			return "You already used all ballots.";
		case NOT_IN_VOTING_PERIOD:
			return "The voting period has ended.";
		default:
			return result.toString();
		}
	}

	@Override
	public void submitButtonClicked() {

		model.setProject(projectSelectionController.getSelected());
		model.setCriterion(criterionSelectionController.getSelected());

		ValidationResult result = checkBallot();

		if (result == ValidationResult.OK) {
			if (view.confirmVoting()) {
				result = submitBallot();
				if (result == ValidationResult.OK) {
					view.displaySuccess(process.getRemainingBallots());
					view.setVisible(false);
					view.dispose();
				} else {
					view.displayError(errorMessage(result));
				}
			}
		} else {
			view.displayError(errorMessage(result));
		}
	}

	/**
	 * Submits the ballot that this controller is handling.
	 * 
	 * @return the result
	 */
	private ValidationResult submitBallot() {
		return oldBallot == null ? process.submitBallot(model) : process
				.replaceBallot(oldBallot, model);
	}

	/**
	 * Determines if the ballot that is this controller is going to submit is
	 * valid.
	 * 
	 * @return the result
	 */
	private ValidationResult checkBallot() {
		return oldBallot == null ? process.checkBallot(model) : process
				.checkBallotReplace(oldBallot, model);
	}

	/**
	 * Sets the old ballot that will be taken out when the new ballot is going
	 * to be submitted.
	 * 
	 * @param ballot
	 *            the ballot to set
	 */
	public void setOldBallot(Ballot ballot) {
		this.oldBallot = ballot;
	}

}
