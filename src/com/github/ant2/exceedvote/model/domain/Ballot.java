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
public class Ballot {

	@Id @GeneratedValue private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	private Calendar votedAt;

	@ManyToOne
	private Voter voter;

	@ManyToOne
	private Criterion criterion;

	@ManyToOne
	private Project project;
	private int votes;

	public Ballot() {
		votedAt = Calendar.getInstance();
	}

	public Ballot(Project project, Criterion criterion, Voter voter, int votes) {
		this();
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
	public void setVoter(Voter voter) {
		this.voter = voter;
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
	public void setVotedAt(Calendar votedAt) {
		this.votedAt = votedAt;
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
