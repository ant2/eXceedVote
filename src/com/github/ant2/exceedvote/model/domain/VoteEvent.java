package com.github.ant2.exceedvote.model.domain;

import java.util.Calendar;
import java.util.List;

public class VoteEvent {

	public interface Part {
		VoteEvent getVoteEvent();
	}
	
	private String name;
	private Calendar startTime;
	private Calendar finishTime;
	private Calendar announcementTime;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Calendar getStartTime() {
		return startTime;
	}
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	public Calendar getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Calendar finishTime) {
		this.finishTime = finishTime;
	}
	public Calendar getAnnouncementTime() {
		return announcementTime;
	}
	public void setAnnouncementTime(Calendar announcementTime) {
		this.announcementTime = announcementTime;
	}
	public Voter createVoter() {
		Voter voter = new Voter();
		voter.setVoteEvent(this);
		return voter;
	}
	public Criterion createCriterion(String string) {
		Criterion criterion = createCriterion();
		criterion.setName(string);
		return criterion;
	}
	private Criterion createCriterion() {
		Criterion criterion = new Criterion();
		criterion.setVoteEvent(this);
		return criterion;
	}
	public Project createProject(String string) {
		Project project = new Project(name);
		project.setVoteEvent(this);
		return project;
	}

}
