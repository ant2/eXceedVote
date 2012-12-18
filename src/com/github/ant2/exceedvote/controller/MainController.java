package com.github.ant2.exceedvote.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.exceedvote.model.process.Context;
import com.github.ant2.exceedvote.view.MainView;
import com.github.ant2.ui.activity.ActivitiesController;
import com.github.ant2.ui.activity.Activity;
import com.github.ant2.ui.activity.Fx;

/**
 * The main controller for a Voter.
 * 
 * @author dtinth
 */
public class MainController {

	private Context context;
	private MainView view;
	private ActivitiesController panelController;
	private Voter voter;
	private VoteEvent event;
	private Runnable logoutAction;

	/**
	 * Constructs a new MainController
	 * 
	 * @param context
	 *            the context
	 * @param mainView
	 *            the main view to control
	 */
	public MainController(Context context, MainView mainView) {
		this.context = context;
		voter = this.context.getVoter();
		event = this.context.getEvent();
		view = mainView;
		panelController = new ActivitiesController(mainView.getMainPanel());
		addListener();
	}

	private void addListener() {
		view.getLogoutButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				logout();
			}
		});
	}

	private void logout() {
		view.dispose();
		if (logoutAction != null) logoutAction.run();
	}

	/**
	 * Runs an activity.
	 * 
	 * @param activity
	 *            the activity to run
	 */
	public void run(Activity activity) {
		view.setVisible(true);
		view.getNameInfoBox().setText(voter.getName());

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
		int remainingTime = (int) ((event.getFinishTime().getTimeInMillis() - System
				.currentTimeMillis()) / 1000);
		view.getRemainingTimeInfoBox().setText(formatTime(remainingTime));
	}

	private String formatTime(int timeLeft) {
		return String.format("%d:%02d:%02d", timeLeft / 3600,
				timeLeft % 3600 / 60, timeLeft % 60);
	}

	/**
	 * Sets the action to run on logging out.
	 * 
	 * @param logoutAction
	 *            the action to run
	 */
	public void setOnLogoutAction(Runnable logoutAction) {
		this.logoutAction = logoutAction;
	}

}
