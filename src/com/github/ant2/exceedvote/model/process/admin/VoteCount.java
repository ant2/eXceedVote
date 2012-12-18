package com.github.ant2.exceedvote.model.process.admin;

import com.github.ant2.exceedvote.model.domain.Project;

/**
 * A vote count mapping for a criterion.
 * 
 * @author dtinth
 */
public interface VoteCount {

	/**
	 * Gets the vote count by project.
	 * 
	 * @param project
	 *            the project to get the count
	 * @return the total number of votes
	 */
	public int get(Project project);

}
