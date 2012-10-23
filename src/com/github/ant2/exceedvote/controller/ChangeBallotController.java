package com.github.ant2.exceedvote.controller;

import com.github.ant2.exceedvote.model.VotingProcess;
import com.github.ant2.exceedvote.view.ChangeBallotView;

public class ChangeBallotController implements ChangeBallotView.Delegate {
	private VotingProcess model;
	private ChangeBallotView view;

	public ChangeBallotController(VotingProcess model,
			ChangeBallotView changeBallotView) {
		this.model = model;
		view = changeBallotView;
		view.setDelegate(this);
	}

	@Override
	public void changeButtonClicked() {
		System.out.println("Change ballot button is clicked");
	}

	public void show() {
		view.setVisible(true);
	}
}
