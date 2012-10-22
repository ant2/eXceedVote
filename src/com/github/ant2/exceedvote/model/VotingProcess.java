package com.github.ant2.exceedvote.model;

import java.util.Calendar;
import java.util.List;

import com.github.ant2.exceedvote.model.Rules.ValidationResult;

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

	/**
	 * Returns all the available criteria.
	 * 
	 * @return the list of available criteria
	 */
	public List<Criterion> getAvailableCriteria() {
		return event.getCriteria();
	}

	/**
	 * Checks the ballot before it is going to be submitted.
	 * 
	 * @param ballot
	 *            the ballot to check
	 * @return the validation result
	 */
	public ValidationResult checkBallot(Ballot ballot) {
		return event.validate(ballot);
	}

	/**
	 * Submits a ballot.
	 * 
	 * @param ballot
	 *            the ballot to submit
	 * @return the validation result
	 */
	public ValidationResult submitBallot(Ballot ballot) {
		return event.submit(ballot);
	}

	/**
	 * Returns the remaining ballots for that voter.
	 * 
	 * @return the number of remaining ballots that can be submitted
	 */
	public int getRemainingBallots() {
		return voter.getAllowedBallots() - event.countVoterBallots(voter);
	}

}
