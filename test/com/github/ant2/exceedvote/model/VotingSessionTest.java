package com.github.ant2.exceedvote.model;

import java.util.Calendar;

import org.junit.Test;

import com.github.ant2.exceedvote.model.Rules.ValidationResult;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for VotingSession class.
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
		when(rules.validate(ballot, session)).thenReturn(ValidationResult.OK);
		session.submit(ballot);
		assertEquals(oldCount + 1, session.getBallotBox().countBallot());
	}

	@Test
	public void testSubmitShouldIgnoreBallotIfNotAccepted() {
		int oldCount = session.getBallotBox().countBallot();
		when(rules.validate(ballot, session)).thenReturn(ValidationResult.NO_PROJECT_SELECTED);
		session.submit(ballot);
		assertEquals(oldCount, session.getBallotBox().countBallot());
	}

	@Test
	public void testVotingPeriod() {
		session.setStartTime(calendar(1000));
		session.setFinishTime(calendar(10000));
		assertFalse(session.isVotingPeriod(calendar(500)));
		assertTrue(session.isVotingPeriod(calendar(1000)));
		assertTrue(session.isVotingPeriod(calendar(2000)));
		assertTrue(session.isVotingPeriod(calendar(5000)));
		assertFalse(session.isVotingPeriod(calendar(10000)));
		assertFalse(session.isVotingPeriod(calendar(10000)));
	}

	private Calendar calendar(long time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return calendar;
	}

}
