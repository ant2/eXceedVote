package com.github.ant2.ui.activity;

import com.github.ant2.ui.transition.SlideTransition;
import com.github.ant2.ui.transition.Transition;

/**
 * An ActivitiesController controls the ActivityPanel and keeps it in sync with
 * the current Activity.
 * 
 * @author dtinth
 */
public class ActivitiesController implements ActivityDelegate {

	private ActivityPanel view;
	private Activity currentActivity;

	/**
	 * Constructs an ActivitiesController that is associated with a specified
	 * ActivityPanel.
	 * 
	 * @param panel
	 *            the ActivityPanel to associate to
	 */
	public ActivitiesController(ActivityPanel panel) {
		view = panel;
	}

	@Override
	public void runActivity(Activity activity) {
		runActivity(activity, SlideTransition.RIGHT);
	}

	@Override
	public void runActivity(Activity activity, Transition transition) {
		if (currentActivity != null) {
			currentActivity.setDelegate(null);
		}
		view.display(activity.getView(), transition);
		currentActivity = activity;
		activity.setDelegate(this);
	}

}
