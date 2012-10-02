package com.github.ant2.exceedvote.model;

/**
 * This rules class checks if a ballot will be accepted or not.
 * 
 * @author dtinth
 */
public class Rules {

	/**
	 * Checks if a ballot is going to be accepted or not.
	 * 
	 * @param ballot
	 *            the ballot to check
	 * @param session
	 *            the voting session
	 * @return true if the ballot should be accepted, false otherwise
	 */
	public boolean isAcceptable(Ballot ballot, VotingSession session) {
		Voter v = ballot.getVoter();
		if (session.getBallotBox().getVoterBallots(v).size() >= v
				.getAllowedBallots() && session.isVotingPeriod()) return false;
		return true;
	}

}
