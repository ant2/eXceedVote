package com.github.ant2.exceedvote;

/**
 * The Voter that represents a person that can vote.
 * 
 * @author Thiwat Rongsirigul
 */
public class Voter {
	/** Profile for identify who is this voter */
	private VoterProfile profile;

	/**
	 * Test constructor.
	 */
	public Voter() {
		this(new VoterProfile("Test User", "5410000000"));
	}

	/**
	 * Constructs the voter from the specific profile.
	 * 
	 * @param profile
	 *            the identification detail for this voter
	 */
	public Voter(VoterProfile profile) {
		this.profile = profile;
	}

	/**
	 * Returns the allowed ballot for this user which is the total times that
	 * this user can vote.
	 * 
	 * @return total ballot that commissioner assigned to this voter
	 */
	public int getAllowedBallots() {
		return 5;
	}

	/**
	 * Returns the information of this voter.
	 * 
	 * @return profile object that describe this voter
	 */
	public VoterProfile getProfile() {
		return profile;
	}

}
