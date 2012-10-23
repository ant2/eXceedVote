package com.github.ant2.exceedvote.model;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.github.ant2.exceedvote.model.Rules.ValidationResult;
import com.github.ant2.exceedvote.model.mock.MockVoteEvent;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class ChangeVoterBallotTest {

	@Test
	public void test() {

		MockVoteEvent event = new MockVoteEvent();
		Voter voter = mock(Voter.class);

		when(voter.getAllowedBallots()).thenReturn(2);

		VotingProcess process = new VotingProcess(event, voter);

		Ballot b1 = process.createBallot();
		b1.setProject(event.p1);
		b1.setCriterion(event.c1);
		process.submitBallot(b1);
		
		Ballot b2 = process.createBallot();
		b2.setProject(event.p1);
		b2.setCriterion(event.c2);
		process.submitBallot(b2);
		
		List<Ballot> ballots = process.getBallots();
		assertEquals(ballots.size(), 2);
		assertTrue(ballots.contains(b1));
		assertTrue(ballots.contains(b2));
		
		Ballot b3 = process.copyBallot(b1);
		assertNotNull(b3);
		assertNotSame(b1, b3);
		b3.setProject(event.p2);
		assertSame(ValidationResult.OK, process.checkBallotReplace(b1, b3));
		assertSame(ValidationResult.OK, process.replaceBallot(b1, b3));
		
		ballots = process.getBallots();
		assertEquals(ballots.size(), 2);
		assertTrue(ballots.contains(b3));
		assertTrue(ballots.contains(b2));
		assertFalse(ballots.contains(b1));
		
	}

}
