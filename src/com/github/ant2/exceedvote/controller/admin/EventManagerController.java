package com.github.ant2.exceedvote.controller.admin;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.view.admin.ManageEventWindow;
import com.github.exceedvote.process.admin.EventManagerProcess;

public class EventManagerController {
	private EventManagerProcess process;
	private ManageEventWindow view;
	private List<Project> projects;
	private List<Criterion> criteria;

	public EventManagerController(EventManagerProcess process,
			ManageEventWindow view) {
		this.process = process;
		this.view = view;
		projects = process.getAllProject();
		criteria = process.getAllCriterion();
		addListener();
		setListModel();
	}

	private void setListModel() {
		view.getProjectList().setModel(new ProjectListModel());
		view.getCriteriaList().setModel(new CriterionListModel());
	}

	private void addListener() {
		// TODO still can't find the better way that duplicated code
	}

	public void run() {
		view.setVisible(true);
		view.pack();
	}

	private class ProjectListModel extends AbstractListModel<String> implements
			ListModel<String> {
		/** */
		private static final long serialVersionUID = 1L;

		@Override
		public String getElementAt(int index) {
			return projects.get(index).toString();
		}

		@Override
		public int getSize() {
			return projects.size();
		}

	}

	private class CriterionListModel extends AbstractListModel<String>
			implements ListModel<String> {
		/** */
		private static final long serialVersionUID = 1L;

		@Override
		public String getElementAt(int index) {
			return criteria.get(index).toString();
		}

		@Override
		public int getSize() {
			return criteria.size();
		}

	}
}
