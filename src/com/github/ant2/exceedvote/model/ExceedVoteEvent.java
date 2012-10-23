package com.github.ant2.exceedvote.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.github.ant2.exceedvote.model.Rules.ValidationResult;

/**
 * This class represents a voting session.
 * 
 * @author dtinth
 */
public class ExceedVoteEvent extends AbstractVoteEvent implements VoteEvent {

	private List<Project> projects = new ArrayList<Project>();
	private List<Criterion> criteria = new ArrayList<Criterion>();

	/**
	 * Constructs a default VoteEvent.
	 */
	public ExceedVoteEvent() {

	}

	@Override
	public int getRemainingTime(Calendar calendar) {
		return (int) ((finishTime.getTimeInMillis() - calendar
				.getTimeInMillis()) / 1000);
	}

	// XXX TEST DATA
	{
		projects.add(new Project("Physics Works", "I am the best project!"));
		projects.add(new Project("Nyan Cat Extreme",
				"Nyanyanyanyanyanayanyaynany!!"));
		projects.add(new Project("TROLOL",
				"Our project sings the trolol song forever"));
		projects.add(new Project("DERP", "DERPYDERPY"));
		projects.add(new Project("Love Status", "Coding at maximum bug power"));
		criteria.add(new Criterion("Maximum Bug"));
		criteria.add(new Criterion("Best OOP"));
		criteria.add(new Criterion("Creative"));
		criteria.add(new Criterion("Best Graphic"));
		criteria.add(new Criterion("User Friendly"));
	}

	@Override
	public List<Project> getProjects() {
		return projects;
	}

	@Override
	public List<Criterion> getCriteria() {
		return criteria;
	}

}
