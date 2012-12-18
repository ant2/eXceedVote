package com.github.ant2.exceedvote.activity.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import com.github.ant2.ui.activity.AbstractActivity;
import com.github.ant2.ui.activity.Activity;
import com.github.ant2.ui.activity.ActivityView;
import com.github.ant2.ui.activity.Fx;

/**
 * A base class for activity view in voting UI. Supports going back to previous
 * activity. An activity is like a "Controller" which mediates the communication
 * between the "ActivityView" and the "Process".
 * 
 * @param <View>
 *            the view that this activity manages
 * @author dtinth
 */
public abstract class AbstractExceedVoteActivity<View extends ActivityView>
		extends AbstractActivity<View> {

	/**
	 * The previous activity.
	 */
	protected final Activity previous;

	/**
	 * A convenience action that can be added as an ActionListener to any
	 * component which when performed, will direct the user back to the previous
	 * activity.
	 */
	protected final Action GO_BACK;

	/**
	 * Constructs a new AbstractExceedVoteActivity.
	 * @param previous the previous activity
	 * @param view the view to control
	 */
	public AbstractExceedVoteActivity(Activity previous, View view) {
		super(view);
		this.previous = previous;
		this.GO_BACK = new AbstractAction() {
			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		};
	}

	/**
	 * Convenience method that directs the user to the previous activity.
	 */
	protected void goBack() {
		runActivity(previous, Fx.SLIDE_LEFT);
	}

}
