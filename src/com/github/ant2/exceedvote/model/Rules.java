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
	 * @param session
	 *            the voting session
	 * @return the validation result
	 */
	public ValidationResult validate(Ballot ballot, VotingSession session) {
		if (ballot.getProject() == null) return ValidationResult.NO_PROJECT_SELECTED;
		if (ballot.getCriterion() == null) return ValidationResult.NO_CRITERION_SELECTED;
		if (session.getBallotBox().getVoterBallots(ballot.getVoter()).size() >= ballot
				.getVoter().getAllowedBallots() && session.isVotingPeriod()) return ValidationResult.QUOTA_EXCEEDED;
		return ValidationResult.OK;
	}

}
