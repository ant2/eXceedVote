package com.github.ant2.exceedvote.model.process.admin;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

/**
 * A VoteCounter counts all the votes in the system for an event.
 * 
 * @author dtinth
 */
public class VoteCounter {

	private static Logger logger = LogManager.getLogger(VoteCounter.class);

	private DaoFactory df;
	private VoteEvent event;

	/**
	 * Creates a VoteCounter
	 * 
	 * @param df
	 *            the dao factory
	 * @param event
	 *            the event
	 */
	public VoteCounter(DaoFactory df, VoteEvent event) {
		this.df = df;
		this.event = event;
	}

	/**
	 * Counts all the votes.
	 * 
	 * @return the result
	 */
	public VoteCounterResult count() {
		final Map<Criterion, VoteCount> byCriterion = new HashMap<Criterion, VoteCount>();
		List<Ballot> ballots = df.getBallotDao().findAllByEvent(event);
		List<Project> projects = df.getProjectDao().findAllByEvent(event);
		logger.info("Counting ballots for event: " + event);
		for (Criterion c : df.getCriterionDao().findAllByEvent(event)) {
			final Map<Project, Integer> byProject = new HashMap<Project, Integer>();
			for (Project p : projects) {
				for (Ballot b : ballots) {
					if (b.getProject().equals(p) && b.getCriterion().equals(c)) {
						int count = byProject.containsKey(p) ? byProject.get(p)
								: 0;
						count += b.getVotes();
						byProject.put(p, count);
					}
				}
			}
			byCriterion.put(c, new VoteCount() {
				@Override
				public int get(Project project) {
					int count = byProject.containsKey(project) ? byProject
							.get(project) : 0;
					return count;
				}
			});
		}
		final Calendar then = Calendar.getInstance();
		return new VoteCounterResult() {
			@Override
			public VoteCount forCriterion(Criterion c) {
				return byCriterion.get(c);
			}

			@Override
			public Calendar getCalendar() {
				return then;
			}
		};
	}

}
