package com.github.ant2.exceedvote.model;

/**
 * This rules class checks if a ballot will be accepted or not.
 * 
 * @author dtinth
 */
public class Rules {

	public enum ValidationResult {
		OK, NO_PROJECT_SELECTED, NO_CRITERION_SELECTED, QUOTA_EXCEEDED;
	}

	/**
	 * Validates a ballot.
	 * 
	 * @param ballot
	 *            the ballot to validate
	 * @param event
	 *            the voting session
	 * @return the validation result
	 */
	public ValidationResult validate(Ballot ballot, VoteEvent event) {
		if (ballot.getProject() == null) return ValidationResult.NO_PROJECT_SELECTED;
		if (ballot.getCriterion() == null) return ValidationResult.NO_CRITERION_SELECTED;
		if (event.getBallotBox().findVoterBallots(ballot.getVoter()).size() >= ballot
				.getVoter().getAllowedBallots() && event.isVotingPeriod()) return ValidationResult.QUOTA_EXCEEDED;
		return ValidationResult.OK;
	}

}
