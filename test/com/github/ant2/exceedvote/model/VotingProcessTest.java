package com.github.ant2.exceedvote.model;

import org.junit.Test;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;

public class VotingProcessTest {

	private VoteEvent event = mock(VoteEvent.class);
	private Voter voter = mock(Voter.class);
	
	private VotingProcess process = new VotingProcess(event, voter);

	@Test
	public void testGetEvent() {
		assertEquals(event, process.getEvent());
	}
	
	@Test
	public void testGetVoter() {
		assertEquals(voter, process.getVoter());
	}

}
