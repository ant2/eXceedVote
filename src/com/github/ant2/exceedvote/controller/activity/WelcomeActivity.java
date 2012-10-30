package com.github.ant2.exceedvote.controller.activity;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.github.ant2.exceedvote.view.activity.WelcomeActivityView;
import com.github.ant2.exceedvote.view.animation.SlideAnimation;

public class WelcomeActivity extends AbstractActivity<WelcomeActivityView> {

	public WelcomeActivity(WelcomeActivityView view) {
		super(view);
		view.getButton().setAction(new AbstractAction("Welcome me again!") {

			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				runActivity(new WelcomeActivity(new WelcomeActivityView()),
						SlideAnimation.LEFT);
			}
		});
	}

}
