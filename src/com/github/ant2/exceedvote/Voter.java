package com.github.ant2.exceedvote;

public class Voter {
	private VoterProfile profile;
	
	public Voter() {
		this(new VoterProfile("Test User", "5410000000"));
	}
	
	public Voter(VoterProfile profile) {
		this.profile = profile;
	}
	
	public int getAllowedBallots() {
		return 5;
	}

	public VoterProfile getProfile() {
		return profile;
	}

}
