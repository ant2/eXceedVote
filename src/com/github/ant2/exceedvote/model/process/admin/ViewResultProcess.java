package com.github.ant2.exceedvote.model.process.admin;

import java.util.Calendar;
import java.util.List;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

/**
 * The view result process.
 * 
 * @author dttvb
 */
public class ViewResultProcess {

	private DaoFactory df;
	private VoteCounterResult result;
	private VoteEvent event;
	private List<Criterion> criteria;
	private List<Project> projects;

	/**
	 * Constructs a new ViewResultProcess
	 * 
	 * @param df
	 *            the dao factory
	 * @param event
	 *            the event
	 */
	public ViewResultProcess(DaoFactory df, VoteEvent event) {
		this.df = df;
		this.event = event;
		result = new VoteCounter(df, event).count();
	}

	/**
	 * Gets the vote result.
	 * 
	 * @return the result
	 */
	public VoteCounterResult getResult() {
		return result;
	}

	/**
	 * Gets the event.
	 * 
	 * @return the event
	 */
	public VoteEvent getEvent() {
		return event;
	}

	/**
	 * Gets the time where the votes are counted.
	 * 
	 * @return the calendar
	 */
	public Calendar getCalendar() {
		return result.getCalendar();
	}

	/**
	 * Gets the criteria list.
	 * 
	 * @return the list of criteria
	 */
	public List<Criterion> getCriteria() {
		if (criteria == null) {
			criteria = df.getCriterionDao().findAllByEvent(event);
		}
		return criteria;
	}

	/**
	 * Gets the list of projects.
	 * 
	 * @return the project list
	 */
	public List<Project> getProjects() {
		if (projects == null) {
			projects = df.getProjectDao().findAllByEvent(event);
		}
		return projects;
	}

}
