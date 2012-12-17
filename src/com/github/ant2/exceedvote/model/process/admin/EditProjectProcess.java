package com.github.ant2.exceedvote.model.process.admin;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.util.ChangeObservable;

/**
 * 
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class EditProjectProcess extends ChangeObservable {
	private DaoFactory df;
	private Project project;
	private ProjectDao dao;
	private String error;

	public EditProjectProcess(DaoFactory df, Project criterion) {
		this.df = df;
		this.project = criterion;
		dao = df.getProjectDao();
	}

	public void setName(String name) {
		project.setName(name);
	}

	public String getName() {
		return project.getName();
	}

	public boolean save() {
		if (project.getName().isEmpty()) {
			error = "Project name must not be empty!";
			return false;
		}
		dao.save(project);
		notifyObservers();
		return true;
	}

	public boolean delete() {
		dao.remove(project);
		notifyObservers();
		return true;
	}

	public String getError() {
		return error;
	}
}
