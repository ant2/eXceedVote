package com.github.ant2.ui.activity;

/**
 * An Activity is a "controller" of an ActivityView.
 * 
 * @author dtinth
 */
public interface Activity {

	/**
	 * Returns the view associated with this Activity.
	 * 
	 * @return the view that is associated with this Activity
	 */
	ActivityView getView();

	/**
	 * Sets the activity delegate.
	 * 
	 * @param delegate
	 *            the activity delegate to set
	 */
	void setDelegate(ActivityDelegate delegate);

}
