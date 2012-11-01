package com.github.ant2.exceedvote.controller;

import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;
import com.github.ant2.exceedvote.view.MainView;
import com.github.ant2.ui.activity.ActivitiesController;
import com.github.ant2.ui.activity.Activity;
import com.github.ant2.ui.activity.Fx;

public class MainController {

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

	public void run(Activity activity) {
		view.setVisible(true);
		panelController.runActivity(activity, Fx.STARFIELD);
	}

}
