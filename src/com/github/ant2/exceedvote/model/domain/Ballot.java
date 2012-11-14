package com.github.ant2.exceedvote.model.domain;

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
	private int votes;

	public Ballot() {
	}

	public Ballot(Project project, Criterion criterion, Voter voter, int votes) {
		this.project = project;
		this.criterion = criterion;
		this.voter = voter;
		this.votes = votes;
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

	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
}
