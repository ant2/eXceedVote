package com.github.ant2.exceedvote.model.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class VoteEvent extends Model {

	public interface Part {
		VoteEvent getVoteEvent();
	}

	private String name;

	@Temporal(value = TemporalType.TIMESTAMP) private Calendar startTime;

	@Temporal(value = TemporalType.TIMESTAMP) private Calendar finishTime;

	@Temporal(value = TemporalType.TIMESTAMP) private Calendar announcementTime;

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

	public Voter createVoter(String name, String studentId) {
		Voter voter = createVoter();
		voter.setName(name);
		voter.setStudentId(studentId);
		return voter;
	}

	//TODO test code
	public Commissioner createCommissioner(String name) {
		return new Commissioner(name);
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

	public Project createProject(String name) {
		Project project = new Project(name);
		project.setVoteEvent(this);
		return project;
	}

	@Id @GeneratedValue protected Integer id;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
