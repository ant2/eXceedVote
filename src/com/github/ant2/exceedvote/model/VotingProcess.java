package com.github.ant2.exceedvote.model;

import java.util.Calendar;
import java.util.List;

public class VotingProcess {

	private VoteEvent event;
	private Voter voter;

	/**
	 * Constructs a VotingProcess which represents the process of voting.
	 * 
	 * @param event
	 *            the voting event
	 * @param voter
	 *            the voter
	 */
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

	/**
	 * Returns the event that is being handled.
	 * 
	 * @return the event
	 */
	public VoteEvent getEvent() {
		return event;
	}

	/**
	 * Returns the voter who completes the process.
	 * 
	 * @return the voter
	 */
	public Voter getVoter() {
		return voter;
	}
	
	/**
	 * Creates a new Ballot for the voter.
	 * 
	 * @return a new ballot
	 */
	public Ballot createBallot() {
		return new Ballot(voter, null, null);
	}

}
