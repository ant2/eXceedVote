package com.github.ant2.exceedvote.activity.controller;

import com.github.ant2.exceedvote.activity.view.ProjectSelectionActivityView;
import com.github.ant2.exceedvote.model.Project;
import com.github.ant2.exceedvote.model.process.ViewProjectProcess;
import com.github.ant2.ui.activity.Activity;

public class ProjectSelectionActivity extends
		AbstractExceedVoteActivity<ProjectSelectionActivityView> {

	private ViewProjectProcess process;

	public ProjectSelectionActivity(Activity previous,
			ViewProjectProcess process, ProjectSelectionActivityView view) {
		super(previous, view);
		this.process = process;
		addProjectButtons();
		view.getBackButton().addActionListener(GO_BACK);
	}

	private void addProjectButtons() {
		for (Project project : process.getAllAvailableProjects()) {
			view.addButton(project.getName());
		}
	}

}
