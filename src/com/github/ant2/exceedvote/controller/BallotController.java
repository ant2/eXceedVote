package com.github.ant2.exceedvote.controller;

import org.apache.log4j.Logger;

import com.github.ant2.exceedvote.model.Ballot;
import com.github.ant2.exceedvote.model.Criterion;
import com.github.ant2.exceedvote.model.Project;
import com.github.ant2.exceedvote.model.Rules;
import com.github.ant2.exceedvote.model.VotingProcess;
import com.github.ant2.exceedvote.model.Rules.ValidationResult;
import com.github.ant2.exceedvote.view.BallotView;
import com.github.ant2.exceedvote.view.BallotView.Delegate;

public class BallotController implements Delegate {

	private static Logger logger = Logger.getLogger(BallotController.class);
	private VotingProcess process;
	private Ballot model;
	private BallotView view;

	public BallotController(VotingProcess process, Ballot model, BallotView view) {
		this.process = process;
		this.model = model;
		this.view = view;
		view.setDelegate(this);
		view.addProjectOptions(process.getSession().getProjects());
		view.addCriterionOptions(process.getSession().getCriteria());
	}

	public void show() {
		view.pack();
		view.setVisible(true);
	}

	public String errorMessage(ValidationResult result) {
		switch (result) {
		case NO_CRITERION_SELECTED:
			return "Please select a criterion";
		case NO_PROJECT_SELECTED:
			return "Please select a project.";
		case QUOTA_EXCEEDED:
			return "You already used all ballots.";
		default:
			throw new RuntimeException("This code shouldn't be reached!");
		}
	}

	@Override
	public void submitted() {
		ValidationResult result = process.getSession().getRules()
				.validate(model, process.getSession());
		if (result == ValidationResult.OK) {
			if (view.confirmVoting()) {
				result = process.getSession().submit(model);
				if (result == ValidationResult.OK) {
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

	@Override
	public void projectSelected(Object option) {
		model.setProject((Project) option);
	}

	@Override
	public void criterionSelected(Object option) {
		model.setCriterion((Criterion) option);
	}

}
