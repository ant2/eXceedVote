package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

/**
 * The ProjectDao responsible for save and retrieve project to persistent unit.
 * 
 * @author Thai Pangsakulyanont (dtinth)
 */
public interface ProjectDao {

	/**
	 * Saves the project to the persistent unit.
	 * 
	 * @param project
	 *            the project need to be saved
	 */
	void save(Project project);

	/**
	 * Returns all project available in the specific event
	 * 
	 * @param event
	 *            the event that projects are belonging
	 * @return list of all projects available in this event
	 */
	List<Project> findAllByEvent(VoteEvent event);

	/**
	 * Removes the project
	 * 
	 * @param project
	 *            the project that is going to be removed
	 */
	void remove(Project project);

}
