package com.github.ant2.ui.activity;

import com.github.ant2.ui.transition.Transition;

/**
 * A base, abstract implementation of Activity.
 * 
 * @param <View>
 *            type of ActivityView that this Activity controls.
 * @author dtinth
 */
public abstract class AbstractActivity<View extends ActivityView> implements
		Activity {

	protected View view;
	protected ActivityDelegate delegate;

	@Override
	public ActivityView getView() {
		return view;
	}

	/**
	 * Constructs an AbstractActivity with the specified activity view.
	 * 
	 * @param view
	 *            the view to associate with this activity
	 */
	public AbstractActivity(View view) {
		this.view = view;
	}

	@Override
	public void setDelegate(ActivityDelegate delegate) {
		this.delegate = delegate;
	}

	/**
	 * Transitions to another activity. This is a convenient method that
	 * subclasses can use to take user to another activity.
	 * 
	 * @param activity
	 *            the activity to transition to
	 */
	protected void runActivity(Activity activity) {
		delegate.runActivity(activity);
	}

	/**
	 * Transitions to another activity. This is a convenient method that
	 * subclasses can use to take user to another activity.
	 * 
	 * @param activity
	 *            the activity to transition to
	 * @param transition
	 *            the transition effect
	 */
	protected void runActivity(Activity activity, Transition transition) {
		delegate.runActivity(activity, transition);
	}

}
