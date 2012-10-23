package com.github.ant2.exceedvote.model;

import java.util.Calendar;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.github.ant2.exceedvote.model.Rules.ValidationResult;

public abstract class AbstractVoteEvent implements VoteEvent {

	private static Logger logger = Logger.getLogger(ExceedVoteEvent.class);

	protected Calendar startTime;
	protected Calendar finishTime;
	private Calendar announcementTime;
	protected Rules rules = new Rules();
	protected BallotBox ballotBox = new BallotBox();

	/**
	 * Returns the BallotBox associated with this VoteEvent.
	 * 
	 * @return the BallotBox
	 */
	@Override
	public BallotBox getBallotBox() {
		return ballotBox;
	}

	/**
	 * Returns the remaining time left until the voting session ends.
	 * 
	 * @return the time remaining, in seconds
	 */
	@Override
	public int getRemainingTime() {
		return getRemainingTime(Calendar.getInstance());
	}

	/**
	 * Sets the voting rules for this VoteEvent.
	 * 
	 * @param rules
	 *            the rules object to set
	 */
	@Override
	public void setRules(Rules rules) {
		this.rules = rules;
	}

	/**
	 * Returns the validation rules for this VoteEvent.
	 * 
	 * @return the rules object
	 */
	@Override
	public Rules getRules() {
		return rules;
	}

	/**
	 * Returns the starting time that the user can vote.
	 * 
	 * @return the starting time for voting
	 */
	@Override
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
	@Override
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	/**
	 * Returns the finishing time that the user can vote.
	 * 
	 * @return the finishing time for voting
	 */
	@Override
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
	@Override
	public void setFinishTime(Calendar finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * Returns the time for announcement.
	 * 
	 * @return the announcement time
	 */
	@Override
	public Calendar getAnnouncementTime() {
		return announcementTime;
	}

	/**
	 * Sets the announcement time. After this time, the results will be
	 * announced.
	 * 
	 * @param announcementTime
	 */
	@Override
	public void setAnnouncementTime(Calendar announcementTime) {
		this.announcementTime = announcementTime;
	}

	/**
	 * Returns whether the current local time is in the voting period.
	 * 
	 * @return true if in the voting period, false otherwise
	 */
	@Override
	public boolean isVotingPeriod() {
		return isVotingPeriod(Calendar.getInstance());
	}

	/**
	 * Finds and returns a list of ballots put into the ballot box by voter v.
	 * 
	 * @param voter
	 *            the voter to find
	 * @return a collection of ballots
	 */
	@Override
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
	@Override
	public int countVoterBallots(Voter voter) {
		return findVoterBallots(voter).size();
	}

	/**
	 * Verifies a ballot.
	 * 
	 * @param b
	 *            the ballot to validate
	 * @return the validation result for the ballot
	 */
	@Override
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
	@Override
	public ValidationResult submit(Ballot b) {
		ValidationResult result = validate(b);
		if (result == ValidationResult.OK) {
			logger.info("A ballot was submitted: " + b);
			ballotBox.add(b);
		}
		return result;
	}

	/**
	 * Returns whether the given calendar time is in the voting period.
	 * 
	 * @param calendar
	 *            the calendar to check
	 * @return true if in the voting period, false otherwise
	 */
	@Override
	public boolean isVotingPeriod(Calendar calendar) {
		return !startTime.after(calendar) && calendar.before(finishTime);
	}

	@Override
	public boolean isQuotaReachedForVoter(Voter voter) {
		return countVoterBallots(voter) >= voter.getAllowedBallots();
	}

}