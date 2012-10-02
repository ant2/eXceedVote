package com.github.ant2.exceedvote;

import org.junit.Test;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;


/**
 * 
 *
 * @author Nutnicha Charoenporn
 */
public class BallotBoxTest {

	private BallotBox ballotBox = new BallotBox();
	private Ballot testBallot = mock(Ballot.class);
	
	@Test
	public void testEmptyCount() {
		assertEquals(0, ballotBox.countBallot());
	}
	
	@Test
	public void testAdd() {
		ballotBox.add(testBallot);
		assertEquals(1, ballotBox.countBallot());
	}
}
