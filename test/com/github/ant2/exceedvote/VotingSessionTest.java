package com.github.ant2.exceedvote;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

/**
 * TODO WRITE INFO
 * 
 * @author dtinth
 */
public class VotingSessionTest {

	private VotingSession session = new VotingSession();
	private Ballot ballot = mock(Ballot.class);
	private Rules rules = mock(Rules.class);

	{
		session.setRules(rules);
	}

	@Test
	public void testSubmit() {
		int oldCount = session.getBallotBox().countBallot();
		when(rules.isAcceptable(ballot, session)).thenReturn(true);
		session.submit(ballot);
		assertEquals(oldCount + 1, session.getBallotBox().countBallot());
	}

	@Test
	public void testSubmitShouldIgnoreBallotIfNotAccepted() {
		int oldCount = session.getBallotBox().countBallot();
		when(rules.isAcceptable(ballot, session)).thenReturn(false);
		session.submit(ballot);
		assertEquals(oldCount, session.getBallotBox().countBallot());
	}

	// XXX ADD MORE TESTS

}
