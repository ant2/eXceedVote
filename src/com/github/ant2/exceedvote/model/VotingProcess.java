package com.github.ant2.exceedvote.model;

import java.util.Calendar;

public class VotingProcess {

	private VoteEvent event;
	private Voter voter;

	public VotingProcess(VoteEvent event, Voter voter) {
		this.event = event;
		this.voter = voter;

		// XXX HARD CODE
		Calendar finishTime = Calendar.getInstance();
		finishTime.add(Calendar.MINUTE, 3);

		Calendar announcementTime = Calendar.getInstance();
		announcementTime.add(Calendar.MINUTE, 4);

		event.setStartTime(Calendar.getInstance());
		event.setFinishTime(finishTime);
		event.setAnnouncementTime(announcementTime);

	}

	public VoteEvent getEvent() {
		return event;
	}
	
	public Voter getVoter() {
		return voter;
	}

	public Ballot createBallot() {
		return new Ballot(voter, null, null);
	}

}
