package com.github.ant2.exceedvote.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.Timer;

import org.apache.log4j.Logger;

import com.github.ant2.exceedvote.model.Ballot;
import com.github.ant2.exceedvote.model.VotingProcess;
import com.github.ant2.exceedvote.view.BallotView;
import com.github.ant2.exceedvote.view.VotingProcessView;

public class VotingProcessController implements VotingProcessView.Delegate {

	private static Logger logger = Logger.getLogger(VotingProcessController.class);

	private VotingProcess model;
	private VotingProcessView view;
	
	private ProjectListModel projectListModel;
	private JList projectListView;

	private Timer timer;
	
	public VotingProcessController(VotingProcess model, VotingProcessView view) {
		
		this.model = model;
		this.view = view;
		//view.setFinishTime(model.getEvent().getFinishTime());
		
		timer = new Timer(1000, new RemainingTimeUpdater());
		timer.start();
		
		updateRemainingTime();
		
		view.setVoterProfile(model.getVoter().getProfile());
		
		projectListModel = new ProjectListModel();
		projectListView = view.getProjectList();
		projectListView.setModel(new ProjectListModel());
		
		view.setDelegate(this);
		
	}
	
	class RemainingTimeUpdater implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			updateRemainingTime();
		}
		
	}
	
	private void updateRemainingTime() {
		view.setRemainingTime(model.getEvent().getRemainingTime());
	}

	public void show() {
		view.pack();
		view.setVisible(true);
	}

	class ProjectListModel extends AbstractListModel {

		/** */
		private static final long serialVersionUID = 1L;

		@Override
		public int getSize() {
			return model.getEvent().getProjects().size();
		}

		@Override
		public Object getElementAt(int index) {
			return model.getEvent().getProjects().get(index);
		}

	}

	@Override
	public void voteButtonClicked() {

		Ballot ballot = model.createBallot();
		int index = projectListView.getSelectedIndex();
		
		if (index >= 0) {
			ballot.setProject(model.getEvent().getProjects().get(index));
		}
		
		BallotView ballotView = view.createBallotView();
		BallotController ballotController = new BallotController(model, ballot,
				ballotView);

		ballotController.show();

	}

}
