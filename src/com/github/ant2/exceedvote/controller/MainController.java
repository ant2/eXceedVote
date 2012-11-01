package com.github.ant2.exceedvote.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

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
		view.getNameInfoBox().setText(voter.getProfile().getName());

		Timer timer = new Timer(1000, new RemainingTimeUpdater());
		timer.start();

		updateRemainingTime();

		panelController.runActivity(activity, Fx.STARFIELD);
	}

	class RemainingTimeUpdater implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			updateRemainingTime();
		}

	}

	private void updateRemainingTime() {
		view.getRemainingTimeInfoBox().setText(
				formatTime(event.getRemainingTime()));
	}

	private String formatTime(int timeLeft) {
		return String.format("%d:%02d:%02d", timeLeft / 3600,
				timeLeft % 3600 / 60, timeLeft % 60);
	}

}
