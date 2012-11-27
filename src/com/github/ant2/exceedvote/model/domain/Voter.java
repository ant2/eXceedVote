package com.github.ant2.exceedvote.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.eclipse.persistence.annotations.CascadeOnDelete;


/**
 * The Voter that represents a person that can vote.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
@Entity
public class Voter extends Model implements VoteEvent.Part {

	private String studentId;
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL) private User user;

	@ManyToOne private VoteEvent voteEvent;

	public Voter() {

	}

	/**
	 * Returns the voter's student ID.
	 * @return studentID the voter's student ID.
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * Sets the voter's student ID.
	 * @param studentId the voter's student ID that is going to be set.
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * Returns the voter's name
	 * @return name the voter's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name to this Voter.
	 * @param name the name that is going to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the VoteEvent for this voter.
	 * @return voteEvent the VoteEvent for this voter.
	 */
	@Override
	public VoteEvent getVoteEvent() {
		return voteEvent;
	}

	/**
	 * Sets the VoteEvent for this voter.
	 * @param voteEvent the VoteEvent that is going to be set.
	 */
	public void setVoteEvent(VoteEvent voteEvent) {
		this.voteEvent = voteEvent;
	}

	/**
	 * Returns the number of allowed ballots.
	 * @return 3 the number of allowed ballots.
	 */
	public int getAllowedBallots() {
		return 3;
	}

	@Id @GeneratedValue protected Integer id;

	/**
	 * Returns the voter entity ID.
	 * @return id the voter entity ID.
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the entity ID for this voter.
	 * @param id the voter entity ID that is going to be set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Returns the message shows the voter's studentID, name, and entity ID.
	 */
	@Override
	public String toString() {
		return "Voter [studentId=" + studentId + ", name=" + name + ", id="
				+ id + "]";
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}
}
