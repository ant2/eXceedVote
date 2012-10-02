package com.github.ant2.exceedvote.controller;

import javax.swing.AbstractListModel;

import org.apache.log4j.Logger;

import com.github.ant2.exceedvote.model.Ballot;
import com.github.ant2.exceedvote.model.VotingProcess;
import com.github.ant2.exceedvote.view.BallotView;
import com.github.ant2.exceedvote.view.VotingProcessView;

public class VotingProcessController implements VotingProcessView.Delegate {

	private Logger logger = Logger.getLogger(VotingProcessController.class);

	private VotingProcess model;
	private VotingProcessView view;

	public VotingProcessController(VotingProcess model, VotingProcessView view) {
		this.model = model;
		this.view = view;
		view.setFinishTime(model.getSession().getFinishTime());
		view.setTeamListModel(new TeamListModel());
		view.setDelegate(this);
	}

	public void show() {
		view.pack();
		view.setVisible(true);
	}

	class TeamListModel extends AbstractListModel {

		/** */
		private static final long serialVersionUID = 1L;

		@Override
		public int getSize() {
			return model.getSession().getProjects().size();
		}

		@Override
		public Object getElementAt(int index) {
			return model.getSession().getProjects().get(index);
		}

	}

	@Override
	public void voteButtonClicked() {

		Ballot ballot = model.createBallot();
		BallotView ballotView = view.createBallotView();
		BallotController ballotController = new BallotController(model, ballot,
				ballotView);

		ballotController.show();

	}

}
