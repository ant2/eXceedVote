package com.github.ant2.exceedvote.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Voter that represents a person that can vote.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
@Entity
public class Voter implements VoteEvent.Part {
	
	@Id @GeneratedValue private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	private String studentId;
	private String name;
	
	@ManyToOne
	private VoteEvent voteEvent;
	
	public Voter() {
		
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public VoteEvent getVoteEvent() {
		return voteEvent;
	}
	public void setVoteEvent(VoteEvent voteEvent) {
		this.voteEvent = voteEvent;
	}
	
	public int getAllowedBallots() {
		return 3;
	}
	
}
