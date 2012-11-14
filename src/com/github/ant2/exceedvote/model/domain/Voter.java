package com.github.ant2.exceedvote.model.domain;

/**
 * The Voter that represents a person that can vote.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class Voter implements VoteEvent.Part {
	
	private String studentId;
	private String name;
	private VoteEvent voteEvent;
	
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
	
}
