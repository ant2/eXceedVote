package com.github.ant2.exceedvote.model;

import java.util.Calendar;

public class VotingProcess {

	private VotingSession session;
	private Voter voter;

	public VotingProcess() {

		voter = new Voter(new VoterProfile("マリさん", "5410000000"));
		session = new VotingSession();

		// XXX HARD CODE
		Calendar finishTime = Calendar.getInstance();
		finishTime.add(Calendar.MINUTE, 3);

		Calendar announcementTime = Calendar.getInstance();
		announcementTime.add(Calendar.MINUTE, 4);

		session.setStartTime(Calendar.getInstance());
		session.setFinishTime(finishTime);
		session.setAnnouncementTime(announcementTime);

	}

	public VotingSession getSession() {
		return session;
	}
	
	public Voter getVoter() {
		return voter;
	}

	public Ballot createBallot() {
		return new Ballot(voter, null, null);
	}

}
