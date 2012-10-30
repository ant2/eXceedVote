package com.github.ant2.exceedvote.controller.activity;

import com.github.ant2.exceedvote.view.activity.ActivityView;

public interface Activity {

	ActivityView getView();

	void setDelegate(ActivityDelegate delegate);

}
