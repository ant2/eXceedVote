package com.github.ant2.exceedvote.activity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import com.github.ant2.exceedvote.activity.view.ProjectVoteView;
import com.github.ant2.exceedvote.activity.view.VotingActivityView;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.process.VotingProcess;
import com.github.ant2.ui.activity.Activity;

public class VotingActivity extends
		AbstractExceedVoteActivity<VotingActivityView> {

	public class ProjectVoteViewController {

		private ProjectVoteView view;
		private Project project;

		public ProjectVoteViewController(Project project, ProjectVoteView view) {
			this.project = project;
			this.view = view;
			view.setNameLabelText(project.getName());
			view.getAddButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					increase();
				}
			});
			view.getSubtractButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					decrease();
				}
			});
		}

		private void increase() {
			process.increase(project);
			updateAllCount();
		}

		private void decrease() {
			process.decrease(project);
			updateAllCount();
		}

		public void updateCount() {
			int count = process.getCount(project);
			view.setCountLabelText(count + "");
			view.getSubtractButton().setVisible(process.canDecrease(project));
			view.getAddButton().setEnabled(process.canIncrease());
		}

	}

	private VotingProcess process;

	private List<ProjectVoteViewController> voteViewControllers = new LinkedList<ProjectVoteViewController>();

	public VotingActivity(Activity previous, VotingProcess process,
			VotingActivityView view) {
		super(previous, view);
		this.process = process;
		view.setTitle(process.getCriterion().getName());
		view.getCancelButton().addActionListener(GO_BACK);

		for (Project project : process.getProjects()) {
			ProjectVoteView voteView = view.addProjectVoteView();
			voteViewControllers.add(new ProjectVoteViewController(project,
					voteView));
		}

		updateAllCount();
	}

	private void updateAllCount() {

		String text = String.format(
				"<html>You have used <b>%d</b> out of <b>%d</b> ballots.",
				process.getUsedBallots(), process.getTotalBallots());
		view.setBallotLeftLabelText(text);

		for (ProjectVoteViewController controller : voteViewControllers) {
			controller.updateCount();
		}

	}

}
