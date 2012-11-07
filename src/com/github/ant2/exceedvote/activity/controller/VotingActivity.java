package com.github.ant2.exceedvote.activity.controller;

import com.github.ant2.exceedvote.activity.view.VotingActivityView;
import com.github.ant2.exceedvote.model.process.VotingProcess;
import com.github.ant2.ui.activity.Activity;

public class VotingActivity extends AbstractExceedVoteActivity<VotingActivityView> {

	private VotingProcess process;

	public VotingActivity(Activity previous, VotingProcess process, VotingActivityView view) {
		super(previous, view);
		this.process = process;
	}

}
