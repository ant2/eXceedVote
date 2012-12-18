package com.github.ant2.exceedvote.model.process.admin;

import java.util.Calendar;

import com.github.ant2.exceedvote.model.domain.Criterion;

/**
 * The result of counting all votes inside an event.
 * 
 * @author dtinth
 */
public interface VoteCounterResult {

	/**
	 * Gets the vote count for a criterion.
	 * 
	 * @param c
	 *            the criterion to test
	 * @return the vote count mapping object
	 */
	VoteCount forCriterion(Criterion c);

	/**
	 * Returns the time in which the votes are counted.
	 * 
	 * @return the calendar
	 */
	Calendar getCalendar();

}
