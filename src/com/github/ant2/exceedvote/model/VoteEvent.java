package com.github.ant2.exceedvote.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.github.ant2.exceedvote.model.Rules.ValidationResult;

/**
 * This class represents a voting session.
 * 
 * @author dtinth
 */
public class VoteEvent {

	private static Logger logger = Logger.getLogger(VoteEvent.class);

	private Calendar startTime;
	private Calendar finishTime;
	private Calendar announcementTime;

	private Rules rules = new Rules();

	private List<Project> projects = new ArrayList<Project>();
	private List<Criterion> criteria = new ArrayList<Criterion>();

	private BallotBox ballotBox;

	/**
	 * Constructs a default VoteEvent.
	 */
	public VoteEvent() {
		ballotBox = new BallotBox();
	}

	/**
	 * Returns the BallotBox associated with this VoteEvent.
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
		return getRemainingTime(Calendar.getInstance());
	}

	/**
	 * Returns the remaining time left until the voting session ends.
	 * 
	 * @param calendar
	 *            the calendar to check
	 * @return the time remaining, in seconds
	 */
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

	/**
	 * Returns the list of all projects inside this VoteEvent.
	 * 
	 * @return a list of projects available for voting
	 */
	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * Returns the list of all criteria inside this VoteEvent.
	 * 
	 * @return a list of criteria for selecting
	 */
	public List<Criterion> getCriteria() {
		return criteria;
	}

	/**
	 * Verifies a ballot.
	 * 
	 * @param b
	 *            the ballot to validate
	 * @return the validation result for the ballot
	 */
	public ValidationResult validate(Ballot b) {
		return rules.validate(b, this);
	}

	/**
	 * Submits the vote.
	 * 
	 * @param b
	 *            the ballot to submit
	 * @return the validation result for the ballot
	 */
	public ValidationResult submit(Ballot b) {
		ValidationResult result = validate(b);
		if (result == ValidationResult.OK) {
			logger.info("A ballot was submitted: " + b);
			ballotBox.add(b);
		}
		return result;
	}

	/**
	 * Sets the voting rules for this VoteEvent.
	 * 
	 * @param rules
	 *            the rules object to set
	 */
	public void setRules(Rules rules) {
		this.rules = rules;
	}

	/**
	 * Returns the validation rules for this VoteEvent.
	 * 
	 * @return the rules object
	 */
	public Rules getRules() {
		return rules;
	}

	/**
	 * Returns the starting time that the user can vote.
	 * 
	 * @return the starting time for voting
	 */
	public Calendar getStartTime() {
		return startTime;
	}

	/**
	 * Sets the starting time that the user will be allowed to vote. Before this
	 * time, voters are not allowed to vote.
	 * 
	 * @param startTime
	 *            the starting time for voting
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	/**
	 * Returns the finishing time that the user can vote.
	 * 
	 * @return the finishing time for voting
	 */
	public Calendar getFinishTime() {
		return finishTime;
	}

	/**
	 * Sets the finishing time that the user can vote. After this time, voters
	 * will no longer be allowed to vote on any project.
	 * 
	 * @param finishTime
	 *            the finishing time for voting
	 */
	public void setFinishTime(Calendar finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * Returns the time for announcement.
	 * 
	 * @return the announcement time
	 */
	public Calendar getAnnouncementTime() {
		return announcementTime;
	}

	/**
	 * Sets the announcement time. After this time, the results will be
	 * announced.
	 * 
	 * @param announcementTime
	 */
	public void setAnnouncementTime(Calendar announcementTime) {
		this.announcementTime = announcementTime;
	}

	/**
	 * Returns whether the current local time is in the voting period.
	 * 
	 * @return true if in the voting period, false otherwise
	 */
	public boolean isVotingPeriod() {
		return isVotingPeriod(Calendar.getInstance());
	}

	/**
	 * Returns whether the given calendar time is in the voting period.
	 * 
	 * @param calendar
	 *            the calendar to check
	 * @return true if in the voting period, false otherwise
	 */
	public boolean isVotingPeriod(Calendar calendar) {
		return !startTime.after(calendar) && calendar.before(finishTime);
	}

	/**
	 * Finds and returns a list of ballots put into the ballot box by voter v.
	 * 
	 * @param voter
	 *            the voter to find
	 * @return a collection of ballots
	 */
	public Collection<Ballot> findVoterBallots(Voter voter) {
		return ballotBox.findVoterBallots(voter);
	}

	/**
	 * Counts the number of ballots put into the ballot box by voter v.
	 * 
	 * @param voter
	 *            the voter to count
	 * @return number of ballots by that voter.
	 */
	public int countVoterBallots(Voter voter) {
		return findVoterBallots(voter).size();
	}

}