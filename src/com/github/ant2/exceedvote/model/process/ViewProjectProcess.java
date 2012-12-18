package com.github.ant2.exceedvote.model.process;

import java.util.List;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

/**
 * A view of the project's process.
 * 
 * @author Nutnicha Charoenporn
 */
public class ViewProjectProcess {

	/** A list of projects */
	private List<Project> projects;

	/** A vote event */
	private VoteEvent event;

	/** The DAO factory */
	private DaoFactory df;

	/**
	 * Constructs the ViewProjectProcess. Initializes the projects.
	 * 
	 * @param context
	 *            the context
	 */
	public ViewProjectProcess(Context context) {
		event = context.getEvent();
		df = context.getDaoFactory();
	}

	/**
	 * Gets the list of available projects.
	 * 
	 * @return a list of available projects.
	 */
	public List<Project> getAllAvailableProjects() {
		if (projects == null) {
			projects = df.getProjectDao().findAllByEvent(event);
		}
		return projects;
	}

	/**
	 * Gets the project description
	 * 
	 * @param project
	 *            the project
	 * @return the project description
	 */
	public Object getProjectInfo(Project project) {
		return project.getDescription();
	}

}
