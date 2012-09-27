package com.github.ant2.exceedvote;

import java.util.Calendar;

/**
 * The Ballot vote for the specific project on a specific criterion.
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class Ballot {
	private Calendar votedAt;
	private Voter voter;
	private Criterion criterion;

	/**
	 * Constructs the Ballot with the specific criteria and for the Voter.
	 * 
	 * @param v
	 *            the owner of this Ballot
	 * @param selectedProject
	 *            the project that this Ballot voted for
	 * @param selectedCriteria
	 *            the criteria that this Ballot voted for
	 */
	public Ballot(Voter v, Project selectedProject, Criterion selectedCriteria) {
		votedAt = Calendar.getInstance();
		this.voter = v;
		this.criterion = selectedCriteria;
	}

	/**
	 * Returns the Voter that owns this Ballot.
	 * 
	 * @return the owner of this Ballot
	 */
	public Voter getVoter() {
		return voter;
	}
}
