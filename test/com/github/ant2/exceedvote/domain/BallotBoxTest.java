package com.github.ant2.exceedvote.domain;

import org.junit.Test;

import com.github.ant2.exceedvote.domain.Ballot;
import com.github.ant2.exceedvote.domain.BallotBox;
import com.github.ant2.exceedvote.domain.Voter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

/**
 * 
 * 
 * @author Nutnicha Charoenporn
 */
public class BallotBoxTest {

	private BallotBox ballotBox = new BallotBox();
	private Ballot testBallot = createMockBallot();

	private Ballot createMockBallot() {
		return mock(Ballot.class);
	}

	private Ballot createMockBallot(Voter voter) {
		Ballot ballot = createMockBallot();
		when(ballot.getVoter()).thenReturn(voter);
		return ballot;
	}

	@Test
	public void testEmptyCount() {
		assertEquals(0, ballotBox.countBallot());
	}

	@Test
	public void testAdd() {
		ballotBox.add(testBallot);
		assertEquals(1, ballotBox.countBallot());
	}

	@Test
	public void testGetVoterBallots() {
		Voter v1 = mock(Voter.class);
		Voter v2 = mock(Voter.class);
		Voter v3 = mock(Voter.class);
		for (int i = 0; i < 10; i++) {
			ballotBox.add(createMockBallot(v1));
		}
		for (int i = 0; i < 15; i++) {
			ballotBox.add(createMockBallot(v3));
		}
		for (int i = 0; i < 20; i++) {
			ballotBox.add(createMockBallot(v2));
		}
		assertEquals(10, ballotBox.getVoterBallots(v1).size());
		assertEquals(20, ballotBox.getVoterBallots(v2).size());
		assertEquals(15, ballotBox.getVoterBallots(v3).size());
	}

}
