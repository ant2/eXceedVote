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

public class BallotCounter {

	private static Logger logger = LogManager.getLogger(BallotCounter.class);
	
	private DaoFactory df;
	private VoteEvent event;

	public BallotCounter(DaoFactory df, VoteEvent event) {
		this.df = df;
		this.event = event;
	}

	public BallotCounterResult count() {
		final Map<Criterion, BallotCount> byCriterion = new HashMap<Criterion, BallotCount>();
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
			byCriterion.put(c, new BallotCount() {
				@Override
				public int get(Project project) {
					int count = byProject.containsKey(project) ? byProject
							.get(project) : 0;
					return count;
				}
			});
		}
		final Calendar then = Calendar.getInstance();
		return new BallotCounterResult() {
			@Override
			public BallotCount forCriterion(Criterion c) {
				return byCriterion.get(c);
			}

			@Override
			public Calendar getCalendar() {
				return then;
			}
		};
	}

}
