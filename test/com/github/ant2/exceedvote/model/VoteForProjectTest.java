package com.github.ant2.exceedvote.model;

import org.junit.Test;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;

public class VoteForProjectTest {

	@Test
	public void test() {

		VoteEvent event = mock(ExceedVoteEvent.class);
		Voter voter = mock(Voter.class);
		
		VotingProcess process = new VotingProcess(event, voter);
		
		Ballot ballot = process.createBallot();
		assertNotNull(ballot);
		
		ballot.setProject();
		
	}

}
