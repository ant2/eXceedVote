package com.github.ant2.exceedvote.model;

import java.util.Calendar;
import java.util.List;

/**
 * Represents the process of the voter voting a project inside a certain voting
 * event.
 * 
 * @author dtinth
 */
public class VotingProcess {

	/** the voter who is going to vote */
	private Voter voter;

	/** the event the the voter will vote in */
	private VoteEvent event;

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
	 * Returns the projects that are available for voting.
	 * 
	 * @return the list of projects
	 */
	public List<Project> getAvailableProjects() {
		return event.getProjects();
	}

	/**
	 * Returns the information for that project.
	 * 
	 * @return the project information
	 */
	public ProjectInformation getProjectInfo(Project project) {
		return null;
	}

	/**
	 * Creates a new Ballot for the voter.
	 * 
	 * @return a new ballot
	 */
	public Ballot createBallot() {
		return new Ballot(voter, null, null);
	}

	/**
	 * Returns the remaining time.
	 * 
	 * @return the remaining time, in seconds
	 */
	public int getRemainingTime() {
		return event.getRemainingTime();
	}

}
