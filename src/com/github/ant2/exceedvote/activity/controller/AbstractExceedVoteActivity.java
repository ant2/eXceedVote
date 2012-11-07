package com.github.ant2.exceedvote.activity.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import com.github.ant2.ui.activity.AbstractActivity;
import com.github.ant2.ui.activity.Activity;
import com.github.ant2.ui.activity.ActivityView;
import com.github.ant2.ui.activity.Fx;

public abstract class AbstractExceedVoteActivity<View extends ActivityView> extends AbstractActivity<View> {

	protected final Activity previous;
	protected final Action GO_BACK;

	public AbstractExceedVoteActivity(Activity previous, View view) {
		super(view);
		this.previous = previous;
		this.GO_BACK = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		};
	}
	
	protected void goBack() {
		runActivity(previous, Fx.SLIDE_LEFT);
	}

}
