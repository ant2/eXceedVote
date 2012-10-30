package com.github.ant2.exceedvote.controller;

import com.github.ant2.exceedvote.controller.activity.Activity;
import com.github.ant2.exceedvote.controller.activity.ActivityDelegate;
import com.github.ant2.exceedvote.view.ActivityPanel;
import com.github.ant2.exceedvote.view.animation.Animation;
import com.github.ant2.exceedvote.view.animation.SlideAnimation;

public class ActivitiesController implements ActivityDelegate {

	private ActivityPanel view;
	private Activity currentActivity;

	public ActivitiesController(ActivityPanel panel) {
		view = panel;
	}

	@Override
	public void runActivity(Activity activity) {
		runActivity(activity, SlideAnimation.RIGHT);
	}

	@Override
	public void runActivity(Activity activity, Animation animation) {
		if (currentActivity != null) {
			currentActivity.setDelegate(null);
		}
		view.display(activity.getView(), animation);
		currentActivity = activity;
		activity.setDelegate(this);
	}

}
