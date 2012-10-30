package com.github.ant2.ui.activity;

import com.github.ant2.ui.animation.Animation;

public interface ActivityDelegate {

	void runActivity(Activity activity);

	void runActivity(Activity activity, Animation animation);

}
