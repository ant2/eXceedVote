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
	 * Returns the voting day.
	 * @return votedAt the voting day.
	 */
	public Calendar getVotedAt() {
		return votedAt;
	}

	/**
	 * Sets the date of voting.
	 * @param votedAt the voting day.
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
	 * Returns the student ID.
	 * @return id the student ID.
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets an ID.
	 * @param id the student ID that is set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
