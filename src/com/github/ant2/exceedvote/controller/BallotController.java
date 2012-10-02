package com.github.ant2.exceedvote.controller;

import org.apache.log4j.Logger;

import com.github.ant2.exceedvote.model.Ballot;
import com.github.ant2.exceedvote.model.VotingProcess;
import com.github.ant2.exceedvote.view.BallotView;
import com.github.ant2.exceedvote.view.BallotView.Delegate;

public class BallotController implements Delegate {

	private Logger logger = Logger.getLogger(BallotController.class);
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

	@Override
	public void submitted() {
		logger.info("submit button was clicked");
		view.setVisible(false);
		view.dispose();
	}

}
