package com.github.ant2.exceedvote.controller.activity;

import com.github.ant2.exceedvote.view.animation.Animation;

public interface ActivityDelegate {

	void runActivity(Activity activity);

	void runActivity(Activity activity, Animation animation);

}
