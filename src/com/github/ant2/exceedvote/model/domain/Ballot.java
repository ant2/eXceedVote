package com.github.ant2.exceedvote.model.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Ballot vote for the specific project on a specific criterion.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
@Entity
public class Ballot extends Model {

	private Calendar votedAt;

	@ManyToOne private Voter voter;

	@ManyToOne private Criterion criterion;

	@ManyToOne private Project project;
	private int votes;

	/**
	 * Constructs a Ballot.
	 */
	public Ballot() {
		votedAt = Calendar.getInstance();
	}

	/**
	 * Constructs a ballot.
	 * @param project a project of this Ballot.
	 * @param criterion a criterion of this Ballot.
	 * @param voter an owner of this Ballot.
	 * @param votes the number of votes.
	 */
	public Ballot(Project project, Criterion criterion, Voter voter, int votes) {
		this();
		this.project = project;
		this.criterion = criterion;
		this.voter = voter;
		this.votes = votes;
	}

	/**
	 * Returns the Voter that owns this Ballot.
	 * @return voter the owner of this Ballot
	 */
	public Voter getVoter() {
		return voter;
	}

	/**
	 * Sets a voter to Ballot.
	 * @param voter the owner of this Ballot.
	 */
	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	/**
	 * Returns the criterion of this Ballot.
	 * @return criterion the criterion of this Ballot.
	 */
	public Criterion getCriterion() {
		return criterion;
	}

	/**
	 * Sets a criterion to Ballot.
	 * @param criterion the criterion of this Ballot.
	 */
	public void setCriterion(Criterion criterion) {
		this.criterion = criterion;
	}

	/**
	 * Returns a project that Ballot voted for.
	 * @return project the project that has been voted.
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * Sets a project to Ballot.
	 * @param project the project of this Ballot.
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * Returns date and time of the submitted vote.
	 * @return votedAt date and time of voting.
	 */
	public Calendar getVotedAt() {
		return votedAt;
	}

	/**
	 * Sets the date and time of the submitted vote.
	 * @param votedAt date and time of voting.
	 */
	public void setVotedAt(Calendar votedAt) {
		this.votedAt = votedAt;
	}

	/**
	 * Returns the message shows the voter, project, and criterion.
	 */
	@Override
	public String toString() {
		return "Ballot [voter=" + voter + ", project=" + project
				+ ", criterion=" + criterion + "]";
	}

	/**
	 * Returns the number of votes.
	 * @return votes the number of votes.
	 */
	public int getVotes() {
		return votes;
	}

	/**
	 * Sets a number of votes.
	 * @param votes the number of votes.
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	@Id @GeneratedValue protected Integer id;

	/**
	 * Returns the Ballot entity ID.
	 * @return id the Ballot entity ID.
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets a Ballot entity ID.
	 * @param id the Ballot entity ID that is set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Ballot other = (Ballot) obj;
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		return true;
	}

}
