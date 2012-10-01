package com.github.ant2.exceedvote;

import org.junit.Test;

import static org.junit.Assert.*;

public class VoterProfileTest {
	private VoterProfile profile = new VoterProfile("TestVoter", "541000000");
	
	@Test
	public void testGetName() {
		assertEquals("TestVoter", profile.getName());
	}
	
	@Test
	public void testGetStudentID() {
		assertEquals("541000000", profile.getStudentId());
	}
	
	@Test
	public void testToString() {
		assertEquals("TestVoter", profile.toString());
	}
}
