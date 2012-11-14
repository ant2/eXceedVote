package com.github.ant2.exceedvote.model.process;

import java.util.List;

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

	/**
	 * Constructs the ViewProjectProcess. Initializes the projects.
	 */
	public ViewProjectProcess(VoteEvent event) {
		this.event = event;
	}

	/**
	 * Gets the list of available projects.
	 * 
	 * @return a list of available projects.
	 */
	public List<Project> getAllAvailableProjects() {
		if (projects == null) {
			projects = event.getProjects();
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
