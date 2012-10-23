package com.github.ant2.exceedvote.model;

/**
 * This rules class checks if a ballot will be accepted or not.
 * 
 * @author dtinth
 */
public class Rules {

	public enum ValidationResult {
		OK, NO_PROJECT_SELECTED, NO_CRITERION_SELECTED, QUOTA_EXCEEDED, NOT_IN_VOTING_PERIOD;
	}

	/**
	 * Validates a ballot.
	 * 
	 * @param newBallot
	 *            the ballot to validate
	 * @param oldBallot
	 *            the ballot to be replaced
	 * @param event
	 *            the voting session
	 * @return the validation result
	 */
	public ValidationResult validate(Ballot newBallot, Ballot oldBallot,
			VoteEvent event) {
		if (newBallot.getProject() == null) return ValidationResult.NO_PROJECT_SELECTED;
		if (newBallot.getCriterion() == null) return ValidationResult.NO_CRITERION_SELECTED;
		if (!event.isVotingPeriod()) return ValidationResult.NOT_IN_VOTING_PERIOD;
		if (event.isQuotaReachedForVoter(newBallot.getVoter(), oldBallot)) return ValidationResult.QUOTA_EXCEEDED;
		return ValidationResult.OK;
	}

}
