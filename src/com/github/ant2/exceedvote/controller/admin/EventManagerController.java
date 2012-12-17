package com.github.ant2.exceedvote.controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.process.admin.EditCriterionProcess;
import com.github.ant2.exceedvote.model.process.admin.EditProjectProcess;
import com.github.ant2.exceedvote.model.process.admin.EventManagerProcess;
import com.github.ant2.exceedvote.model.process.admin.ViewResultProcess;
import com.github.ant2.exceedvote.util.ChangeObserver;
import com.github.ant2.exceedvote.view.admin.EditCriteriaWindow;
import com.github.ant2.exceedvote.view.admin.EditProjectWindow;
import com.github.ant2.exceedvote.view.admin.ManageEventWindow;
import com.github.ant2.exceedvote.view.admin.ViewResultWindow;

/**
 * 
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class EventManagerController implements ChangeObserver {
	private EventManagerProcess process;
	private ManageEventWindow view;
	private List<Project> projects;
	private List<Criterion> criteria;
	private VoteEvent event;

	public EventManagerController(EventManagerProcess process,
			ManageEventWindow view) {
		this.process = process;
		this.view = view;
		process.addObserver(this);
		event = process.getEvent();
		addListener();
		reload();
	}

	@Override
	public void changed() {
		reload();
	}

	private void reload() {
		projects = process.getAllProjects();
		criteria = process.getAllCriteria();
		setListModel();
	}

	private void setListModel() {
		view.getProjectList().setModel(new ProjectListModel());
		view.getCriterionList().setModel(new CriterionListModel());
	}

	private void addListener() {
		view.getAddCriterionButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editCriterion(event.createCriterion(""));
			}
		});
		view.getEditCriterionButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editCriterion(criteria.get(view.getCriterionList()
						.getSelectedIndex()));
			}
		});
		view.getViewResultButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				viewResult();
			}
		});
		view.getAddProjectButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editProject(event.createProject(""));
			}
		});
		view.getEditProjectButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editProject(projects.get(view.getProjectList().getSelectedIndex()));
			}
		});
	}

	private void viewResult() {
		ViewResultProcess viewResultProcess = process.viewResult();
		ViewResultWindow vrw = new ViewResultWindow();
		ViewResultController vrc = new ViewResultController(viewResultProcess,
				vrw);
		vrc.run();
	}

	private void editCriterion(Criterion criterion) {
		EditCriterionProcess subprocess = process.editCriterion(criterion);
		EditCriteriaWindow window = new EditCriteriaWindow();
		EditCriterionController controller = new EditCriterionController(
				subprocess, window);
		controller.run();
	}
	
	private void editProject(Project project) {
		EditProjectProcess subprocess = process.editProject(project);
		EditProjectWindow window = new EditProjectWindow();
		EditProjectController controller = new EditProjectController(subprocess, window);
		controller.run();
	}

	public void run() {
		view.setVisible(true);
		view.pack();
	}

	private class ProjectListModel extends AbstractListModel implements
			ListModel {
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

	private class CriterionListModel extends AbstractListModel implements
			ListModel {
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
