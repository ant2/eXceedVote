package com.github.ant2.exceedvote.activity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.ant2.exceedvote.activity.view.CriterionSelectionActivityView;
import com.github.ant2.exceedvote.activity.view.ProjectSelectionActivityView;
import com.github.ant2.exceedvote.activity.view.WelcomeActivityView;
import com.github.ant2.exceedvote.model.process.Context;
import com.github.ant2.ui.activity.Fx;

public class WelcomeActivity extends
		AbstractExceedVoteActivity<WelcomeActivityView> {

	private Context context;

	public WelcomeActivity(Context context, WelcomeActivityView view) {
		super(null, view);
		this.context = context;
		view.getViewProjectInformationButton().addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						goViewProjectInformation();
					}
				});
		view.getVoteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goVote();
			}
		});
	}

	private void goViewProjectInformation() {
		ProjectSelectionActivityView view = new ProjectSelectionActivityView(
				"View Project Information");
		ProjectSelectionActivity activity = new ProjectSelectionActivity(this,
				context.createViewProjectProcess(), view);
		runActivity(activity, Fx.SLIDE_RIGHT);
	}

	private void goVote() {
		CriterionSelectionActivityView view = new CriterionSelectionActivityView();
		CriterionSelectionActivity activity = new CriterionSelectionActivity(
				this, context.createCriterionSelectionProcess(), view);
		runActivity(activity, Fx.SLIDE_RIGHT);
	}

}
