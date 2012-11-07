package com.github.ant2.exceedvote.activity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

import com.github.ant2.exceedvote.activity.view.CriterionSelectionActivityView;
import com.github.ant2.exceedvote.activity.view.VotingActivityView;
import com.github.ant2.exceedvote.model.Criterion;
import com.github.ant2.exceedvote.model.process.Context;
import com.github.ant2.exceedvote.model.process.CriterionSelectionProcess;
import com.github.ant2.exceedvote.model.process.VotingProcess;
import com.github.ant2.ui.activity.Activity;

public class CriterionSelectionActivity extends
		AbstractExceedVoteActivity<CriterionSelectionActivityView> {

	public class CriteriaListModel extends AbstractListModel implements
			ListModel {

		/** */
		private static final long serialVersionUID = 1L;

		@Override
		public Object getElementAt(int row) {
			return criteria.get(row);
		}

		@Override
		public int getSize() {
			return criteria.size();
		}

	}

	private Context context;
	private CriterionSelectionProcess process;
	private List<Criterion> criteria;

	public CriterionSelectionActivity(Activity previous, Context context,
			CriterionSelectionActivityView view) {
		super(previous, view);
		this.context = context;
		process = context.createCriterionSelectionProcess();
		criteria = process.getAllCriteria();
		view.getBackButton().addActionListener(GO_BACK);
		view.getContinueButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				goContinue();
			}
		});
		view.getList().setModel(new CriteriaListModel());
	}

	private void goContinue() {
		int selectedIndex = view.getList().getSelectedIndex();
		if (selectedIndex < 0) return;
		Criterion criterion = criteria.get(selectedIndex);
		VotingProcess process = context.createVotingProcess(criterion);
		VotingActivityView view = new VotingActivityView();
		VotingActivity activity = new VotingActivity(this, process, view);
		runActivity(activity);
	}

}
