package com.github.ant2.exceedvote;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VotingSession {

	private Calendar startTime;
	private Calendar finishTime;
	private Calendar announcementTime;
	
	private Rules rules = new Rules(); // XXX

	private BallotBox ballotBox;

	/**
	 * Constructs a default VotingSession.
	 */
	public VotingSession() {
		// XXX STUB
		ballotBox = new BallotBox();

		// TODO put actual data here!
		startTime = Calendar.getInstance();
		finishTime = Calendar.getInstance();
		finishTime.add(Calendar.HOUR_OF_DAY, 1);
	}

	/**
	 * Returns the BallotBox associated with this VotingSession.
	 * 
	 * @return the BallotBox
	 */
	public BallotBox getBallotBox() {
		return ballotBox;
	}

	/**
	 * Returns the remaining time left until the voting session ends.
	 * 
	 * @return the time remaining, in seconds
	 */
	public int getRemainingTime() {
		return (int) ((finishTime.getTimeInMillis() - Calendar.getInstance()
				.getTimeInMillis()) / 1000);
	}

	/**
	 * Returns the list of all projects inside this VotingSession.
	 * 
	 * @return a list of projects available for voting
	 */
	public List<Project> getProjects() {
		// XXX : this is just a test data
		List<Project> list = new ArrayList<Project>();
		list.add(new Project("Physics Works", "I am the best project!"));
		list.add(new Project("Nyan Cat Extreme",
				"Nyanyanyanyanyanayanyaynany!!"));
		list.add(new Project("TROLOL",
				"Our project sings the trolol song forever"));
		list.add(new Project("DERP", "DERPYDERPY"));
		list.add(new Project("Love Status", "Coding at maximum bug power"));
		return list;
	}

	/**
	 * Returns the list of all criteria inside this VotingSession.
	 * 
	 * @return a list of criteria for selecting
	 */
	public List<Criterion> getCriteria() {
		// XXX : this is just a test data
		List<Criterion> list = new ArrayList<Criterion>();
		list.add(new Criterion("Maximum Bug"));
		list.add(new Criterion("Best OOP"));
		list.add(new Criterion("Creative"));
		list.add(new Criterion("Best Graphic"));
		list.add(new Criterion("User Friendly"));
		return list;
	}

	/**
	 * Submits the vote.
	 * 
	 * @param b
	 *            the ballot to submit
	 */
	public void submit(Ballot b) {
		if (rules.isAcceptable(b, this)) {
			ballotBox.add(b);
		}
	}
	
	/**
	 * Sets the voting rules for this VotingSession.
	 * 
	 * @param rules
	 *            the rules object to set
	 */
	public void setRules(Rules rules) {
		this.rules = rules;
	}

}
