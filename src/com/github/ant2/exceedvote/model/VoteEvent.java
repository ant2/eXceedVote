package com.github.ant2.exceedvote.model;

import java.util.Calendar;
import java.util.List;

import com.github.ant2.exceedvote.model.Rules.ValidationResult;

public interface VoteEvent {

	/**
	 * Returns the BallotBox associated with this VoteEvent.
	 * 
	 * @return the BallotBox
	 */
	public abstract BallotBox getBallotBox();

	/**
	 * Returns the remaining time left until the voting session ends.
	 * 
	 * @return the time remaining, in seconds
	 */
	public abstract int getRemainingTime();

	/**
	 * Returns the remaining time left until the voting session ends.
	 * 
	 * @param calendar
	 *            the calendar to check
	 * @return the time remaining, in seconds
	 */
	public abstract int getRemainingTime(Calendar calendar);

	/**
	 * Returns the list of all projects inside this VoteEvent.
	 * 
	 * @return a list of projects available for voting
	 */
	public abstract List<Project> getProjects();

	/**
	 * Returns the list of all criteria inside this VoteEvent.
	 * 
	 * @return a list of criteria for selecting
	 */
	public abstract List<Criterion> getCriteria();

	/**
	 * Verifies a ballot.
	 * 
	 * @param b
	 *            the ballot to validate
	 * @return the validation result for the ballot
	 */
	public abstract ValidationResult validate(Ballot b);

	/**
	 * Submits the vote.
	 * 
	 * @param b
	 *            the ballot to submit
	 * @return the validation result for the ballot
	 */
	public abstract ValidationResult submit(Ballot b);

	/**
	 * Sets the voting rules for this VoteEvent.
	 * 
	 * @param rules
	 *            the rules object to set
	 */
	public abstract void setRules(Rules rules);

	/**
	 * Returns the validation rules for this VoteEvent.
	 * 
	 * @return the rules object
	 */
	public abstract Rules getRules();

	/**
	 * Returns the starting time that the user can vote.
	 * 
	 * @return the starting time for voting
	 */
	public abstract Calendar getStartTime();

	/**
	 * Sets the starting time that the user will be allowed to vote. Before this
	 * time, voters are not allowed to vote.
	 * 
	 * @param startTime
	 *            the starting time for voting
	 */
	public abstract void setStartTime(Calendar startTime);

	/**
	 * Returns the finishing time that the user can vote.
	 * 
	 * @return the finishing time for voting
	 */
	public abstract Calendar getFinishTime();

	/**
	 * Sets the finishing time that the user can vote. After this time, voters
	 * will no longer be allowed to vote on any project.
	 * 
	 * @param finishTime
	 *            the finishing time for voting
	 */
	public abstract void setFinishTime(Calendar finishTime);

	/**
	 * Returns the time for announcement.
	 * 
	 * @return the announcement time
	 */
	public abstract Calendar getAnnouncementTime();

	/**
	 * Sets the announcement time. After this time, the results will be
	 * announced.
	 * 
	 * @param announcementTime
	 */
	public abstract void setAnnouncementTime(Calendar announcementTime);

	/**
	 * Returns whether the current local time is in the voting period.
	 * 
	 * @return true if in the voting period, false otherwise
	 */
	public abstract boolean isVotingPeriod();

	/**
	 * Returns whether the given calendar time is in the voting period.
	 * 
	 * @param calendar
	 *            the calendar to check
	 * @return true if in the voting period, false otherwise
	 */
	public abstract boolean isVotingPeriod(Calendar calendar);

	/**
	 * Finds and returns a list of ballots put into the ballot box by voter v.
	 * 
	 * @param voter
	 *            the voter to find
	 * @return a collection of ballots
	 */
	public abstract List<Ballot> findVoterBallots(Voter voter);

	/**
	 * Counts the number of ballots put into the ballot box by voter v.
	 * 
	 * @param voter
	 *            the voter to count
	 * @return number of ballots by that voter.
	 */
	public abstract int countVoterBallots(Voter voter);

	public abstract boolean isQuotaReachedForVoter(Voter voter, Ballot oldBallot);

	public abstract ValidationResult validateReplace(Ballot from, Ballot to);

	public abstract ValidationResult replace(Ballot from, Ballot to);

}