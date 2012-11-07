package com.github.ant2.exceedvote.activity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.ant2.exceedvote.activity.view.CriterionSelectionActivityView;
import com.github.ant2.exceedvote.model.process.Context;
import com.github.ant2.ui.activity.Activity;

public class CriterionSelectionActivity extends
		AbstractExceedVoteActivity<CriterionSelectionActivityView> {

	public CriterionSelectionActivity(Activity previous, Context context,
			CriterionSelectionActivityView view) {
		super(previous, view);
		view.getBackButton().addActionListener(GO_BACK);
		view.getContinueButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				goContinue();
			}
		});
	}

	private void goContinue() {

	}

}
