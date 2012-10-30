package com.github.ant2.ui.activity;

import com.github.ant2.ui.animation.Animation;
import com.github.ant2.ui.animation.SlideAnimation;

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
