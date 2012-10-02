package com.github.ant2.exceedvote.controller;

import com.github.ant2.exceedvote.model.Ballot;
import com.github.ant2.exceedvote.model.VotingProcess;
import com.github.ant2.exceedvote.view.BallotView;

public class BallotController {

	private VotingProcess process;
	private Ballot model;
	private BallotView view;

	public BallotController(VotingProcess process, Ballot model, BallotView view) {
		this.process = process;
		this.model = model;
		this.view = view;
	}

	public void show() {
		view.pack();
		view.setVisible(true);
	}

}
