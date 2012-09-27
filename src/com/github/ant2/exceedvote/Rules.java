package com.github.ant2.exceedvote;

public class Rules {

	public boolean isAcceptable(Ballot b, VotingSession session) {
		Voter v = b.getVoter();
		if (session.getBallotBox().getVoterBallots(v).size() >= v
				.getAllowedBallots()) return false;
		return true;
	}

}
