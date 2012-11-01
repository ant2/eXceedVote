package com.github.ant2.exceedvote.activity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.ant2.exceedvote.activity.view.WelcomeActivityView;
import com.github.ant2.ui.activity.AbstractActivity;
import com.github.ant2.ui.activity.Fx;

public class WelcomeActivity extends AbstractActivity<WelcomeActivityView> {

	public WelcomeActivity(WelcomeActivityView view) {
		super(view);
		view.getViewProjectInformationButton().addActionListener(new ActionListener() {
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
		runActivity(this, Fx.SLIDE_LEFT);
	}
	
	private void goVote() {
		runActivity(this, Fx.SLIDE_RIGHT);
	}

}
