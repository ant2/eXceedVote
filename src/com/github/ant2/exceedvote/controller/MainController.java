package com.github.ant2.exceedvote.controller;

import com.github.ant2.exceedvote.activity.controller.WelcomeActivity;
import com.github.ant2.exceedvote.activity.view.WelcomeActivityView;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;
import com.github.ant2.exceedvote.view.MainView;
import com.github.ant2.ui.activity.ActivitiesController;

public class MainController implements Runnable {

	private Voter voter;
	private VoteEvent event;
	private MainView view;
	private ActivitiesController panelController;

	public MainController(Voter voter, VoteEvent event, MainView mainView) {
		this.voter = voter;
		this.event = event;
		view = mainView;
		panelController = new ActivitiesController(mainView.getMainPanel());
	}

	@Override
	public void run() {
		view.setVisible(true);
		panelController.runActivity(new WelcomeActivity(
				new WelcomeActivityView()));
	}

}
