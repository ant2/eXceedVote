package com.github.ant2.exceedvote.controller.activity;

import com.github.ant2.exceedvote.view.activity.ActivityView;
import com.github.ant2.exceedvote.view.animation.Animation;

public abstract class AbstractActivity<View extends ActivityView> implements
		Activity {

	protected View view;
	protected ActivityDelegate delegate;

	@Override
	public ActivityView getView() {
		return view;
	}

	public AbstractActivity(View view) {
		this.view = view;
	}

	@Override
	public void setDelegate(ActivityDelegate delegate) {
		this.delegate = delegate;
	}

	protected void runActivity(Activity activity) {
		delegate.runActivity(activity);
	}

	protected void runActivity(Activity activity, Animation animation) {
		delegate.runActivity(activity, animation);
	}

}
