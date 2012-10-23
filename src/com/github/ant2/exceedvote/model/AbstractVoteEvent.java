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

	@Override
	public BallotBox getBallotBox() {
		return ballotBox;
	}

	@Override
	public int getRemainingTime() {
		return getRemainingTime(Calendar.getInstance());
	}

	@Override
	public void setRules(Rules rules) {
		this.rules = rules;
	}

	@Override
	public Rules getRules() {
		return rules;
	}

	@Override
	public Calendar getStartTime() {
		return startTime;
	}

	@Override
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	@Override
	public Calendar getFinishTime() {
		return finishTime;
	}

	@Override
	public void setFinishTime(Calendar finishTime) {
		this.finishTime = finishTime;
	}

	@Override
	public Calendar getAnnouncementTime() {
		return announcementTime;
	}

	@Override
	public void setAnnouncementTime(Calendar announcementTime) {
		this.announcementTime = announcementTime;
	}

	@Override
	public boolean isVotingPeriod() {
		return isVotingPeriod(Calendar.getInstance());
	}

	@Override
	public Collection<Ballot> findVoterBallots(Voter voter) {
		return ballotBox.findVoterBallots(voter);
	}

	@Override
	public int countVoterBallots(Voter voter) {
		return findVoterBallots(voter).size();
	}

	@Override
	public ValidationResult validate(Ballot b) {
		return rules.validate(b, this);
	}

	@Override
	public ValidationResult submit(Ballot b) {
		ValidationResult result = validate(b);
		if (result == ValidationResult.OK) {
			logger.info("A ballot was submitted: " + b);
			ballotBox.add(b);
		}
		return result;
	}

	@Override
	public boolean isVotingPeriod(Calendar calendar) {
		return !startTime.after(calendar) && calendar.before(finishTime);
	}

	@Override
	public boolean isQuotaReachedForVoter(Voter voter) {
		return countVoterBallots(voter) >= voter.getAllowedBallots();
	}

}