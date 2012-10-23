package com.github.ant2.exceedvote.model;

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
	private Project project;

	/**
	 * Constructs the Ballot with the specific criteria and for the Voter.
	 * 
	 * @param voter
	 *            the owner of this Ballot
	 * @param project
	 *            the project that this Ballot voted for
	 * @param criteria
	 *            the criteria that this Ballot voted for
	 */
	public Ballot(Voter voter, Project project, Criterion criterion) {
		votedAt = Calendar.getInstance();
		this.voter = voter;
		this.criterion = criterion;
		this.project = project;
	}

	/**
	 * Returns the Voter that owns this Ballot.
	 * 
	 * @return the owner of this Ballot
	 */
	public Voter getVoter() {
		return voter;
	}

	public Criterion getCriterion() {
		return criterion;
	}

	public void setCriterion(Criterion criterion) {
		this.criterion = criterion;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Calendar getVotedAt() {
		return votedAt;
	}

	@Override
	public String toString() {
		return "Ballot [voter=" + voter + ", project=" + project
				+ ", criterion=" + criterion + "]";
	}

	public Ballot makeCopy() {
		return new Ballot(voter, project, criterion);
	}
}
