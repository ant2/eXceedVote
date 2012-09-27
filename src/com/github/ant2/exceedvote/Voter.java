package com.github.ant2.exceedvote;

/**
 * The Voter that represents a person that can vote.
 * 
 * @author Thiwat Rongsirigul
 */
public class Voter {
	/** Profile for identity who is this voter */
	private VoterProfile profile;

	/*
	 * Test constructor. XXX remove
	 */
	public Voter() {
		this(new VoterProfile("Test User", "5410000000"));
	}

	/**
	 * Constructs the Voter from the specific VoterProfile.
	 * 
	 * @param profile
	 *            the profile details for this Voter
	 */
	public Voter(VoterProfile profile) {
		this.profile = profile;
	}

	/**
	 * Returns the number of allowed ballots for this Voter which is the maximum
	 * number of times that this Voter can vote.
	 * 
	 * @return maximum number of ballots that the commissioners has assigned to
	 *         this Voter
	 */
	public int getAllowedBallots() {
		return 5;
	}

	/**
	 * Returns the profile information associated with this Voter.
	 * 
	 * @return profile object that describes this voter
	 */
	public VoterProfile getProfile() {
		return profile;
	}

}
