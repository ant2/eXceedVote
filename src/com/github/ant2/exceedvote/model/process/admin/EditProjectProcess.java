package com.github.ant2.exceedvote.model.process.admin;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.util.ChangeObservable;

/**
 * The process for editing project.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class EditProjectProcess extends ChangeObservable {
	private DaoFactory df;
	private Project project;
	private ProjectDao dao;
	private String error;

	/**
	 * Constructs a new EditProjectProcess.
	 * 
	 * @param df
	 *            the DAO factory to get all other DAO
	 * @param project
	 *            the editing project
	 */
	public EditProjectProcess(DaoFactory df, Project project) {
		this.df = df;
		this.project = project;
		dao = this.df.getProjectDao();
	}

	/**
	 * Set the name of the project.
	 * 
	 * @param name
	 *            new name of the project
	 */
	public void setName(String name) {
		project.setName(name);
	}

	/**
	 * Returns the name of the project.
	 * 
	 * @return name of the project
	 */
	public String getName() {
		return project.getName();
	}

	/**
	 * Save the project to the database.
	 * 
	 * @return true if successfully save, otherwise false
	 */
	public boolean save() {
		if (project.getName().isEmpty()) {
			error = "Project name must not be empty!";
			return false;
		}
		dao.save(project);
		notifyObservers();
		return true;
	}

	/**
	 * Delete the project from the database.
	 * 
	 * @return true if can delete
	 */
	public boolean delete() {
		dao.remove(project);
		notifyObservers();
		return true;
	}

	/**
	 * Returns the error message.
	 * 
	 * @return the error message
	 */
	public String getError() {
		return error;
	}
}
