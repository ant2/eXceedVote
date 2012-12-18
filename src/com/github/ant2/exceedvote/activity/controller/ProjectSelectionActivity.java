package com.github.ant2.exceedvote.activity.controller;

import com.github.ant2.exceedvote.activity.view.ProjectSelectionActivityView;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.process.ViewProjectProcess;
import com.github.ant2.ui.activity.Activity;

/**
 * An Activity that lets user select a project.
 * 
 * @author dtinth
 */
public class ProjectSelectionActivity extends
		AbstractExceedVoteActivity<ProjectSelectionActivityView> {

	private ViewProjectProcess process;

	/**
	 * Constructs a new ProjectSelectionActivity.
	 * 
	 * @param previous
	 *            the previous activity
	 * @param process
	 *            the process to control
	 * @param view
	 *            the view to control
	 */
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
