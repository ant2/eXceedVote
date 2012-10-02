package com.github.ant2.exceedvote.controller;

import com.github.ant2.exceedvote.model.VotingProcess;
import com.github.ant2.exceedvote.view.VotingProcessView;

public class VotingProcessController implements VotingProcessView.Delegate {

	private VotingProcess model;
	private VotingProcessView view;
	
	public VotingProcessController(VotingProcess model, VotingProcessView view) {
		this.model = model;
		this.view = view;
		view.setFinishTime(model.getSession().getFinishTime());
	}

	public void run() {
		view.pack();
		view.setVisible(true);
	}

}
