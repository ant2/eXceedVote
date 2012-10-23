package com.github.ant2.exceedvote.model;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.github.ant2.exceedvote.model.Rules.ValidationResult;

/**
 * Abstract class for VoteEvent (which is now an interface)
 * 
 * @author dtinth
 */
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
	public List<Ballot> findVoterBallots(Voter voter) {
		return ballotBox.findVoterBallots(voter);
	}

	@Override
	public int countVoterBallots(Voter voter) {
		return findVoterBallots(voter).size();
	}

	@Override
	public ValidationResult validate(Ballot b) {
		return rules.validate(b, null, this);
	}

	@Override
	public ValidationResult validateReplace(Ballot from, Ballot to) {
		return rules.validate(to, from, this);
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
	public ValidationResult replace(Ballot from, Ballot to) {
		ValidationResult result = validateReplace(from, to);
		if (result == ValidationResult.OK) {
			logger.info("A ballot " + from + " was replaced with: " + to);
			ballotBox.replace(from, to);
		}
		return result;
	}

	@Override
	public boolean isVotingPeriod(Calendar calendar) {
		return !startTime.after(calendar) && calendar.before(finishTime);
	}

	@Override
	public boolean isQuotaReachedForVoter(Voter voter, Ballot oldBallot) {
		List<Ballot> ballots = findVoterBallots(voter);
		int count = ballots.size();
		if (ballots.contains(oldBallot)) {
			count -= 1;
		}
		return count >= voter.getAllowedBallots();
	}

}