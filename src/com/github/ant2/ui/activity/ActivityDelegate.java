package com.github.ant2.ui.activity;

import com.github.ant2.ui.transition.Transition;

/**
 * An ActivityDelegate interface is an interface that Activities use to tell or
 * notify some other objects (the delegate) about its intent. For example, the
 * Activity may notify the delegate that it wants to transition to another
 * activity.
 * 
 * @author dtinth
 */
public interface ActivityDelegate {

	/**
	 * Transitions to another activity.
	 * 
	 * @param activity
	 *            the activity to transition to
	 */
	void runActivity(Activity activity);

	/**
	 * Transitions to another activity with a specified transition effect.
	 * 
	 * @param activity
	 *            the activity to transition to
	 * @param transition
	 *            the transition effect to use
	 */
	void runActivity(Activity activity, Transition transition);

}
