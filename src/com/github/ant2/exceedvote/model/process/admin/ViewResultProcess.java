package com.github.ant2.exceedvote.model.process.admin;

import java.awt.Component;
import java.util.Calendar;
import java.util.List;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.process.BallotCounter;
import com.github.ant2.exceedvote.model.process.BallotCounterResult;

public class ViewResultProcess {
	
	private DaoFactory df;
	private BallotCounterResult result;
	private VoteEvent event;
	private List<Criterion> criteria;
	private List<Project> projects;

	public ViewResultProcess(DaoFactory df, VoteEvent event) {
		this.df = df;
		this.event = event;
		result = new BallotCounter(df, event).count();
	}
	
	public BallotCounterResult getResult() {
		return result;
	}

	public VoteEvent getEvent() {
		return event;
	}

	public Calendar getCalendar() {
		return result.getCalendar();
	}

	public List<Criterion> getCriteria() {
		if (criteria == null) {
			criteria = df.getCriterionDao().findAllByEvent(event);
		}
		return criteria;
	}

	public List<Project> getProjects() {
		if (projects == null) {
			projects = df.getProjectDao().findAllByEvent(event);
		}
		return projects;
	}

}
