package com.github.ant2.exceedvote;

import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * 
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class VoterTest {

	private VoterProfile profile = new VoterProfile("TestVoter", "541000000");
	private Voter voter = new Voter(profile);

	@Test
	public void testGetProfile() {
		assertSame(profile, voter.getProfile());
	}

}
