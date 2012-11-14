package com.github.ant2.exceedvote.model;

import java.util.Calendar;

import org.junit.Test;

import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Rules.ValidationResult;

import static org.mockito.Matchers.any;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for VoteEvent class.
 * 
 * @author dtinth
 */
public class VoteEventTest {

	private VoteEvent event = new ExceedVoteEvent();
	private Ballot ballot = mock(Ballot.class);

	@Test
	public void testSubmit() {
		int oldCount = event.getBallotBox().countBallot();
		when(
				rules.validate(any(Ballot.class), any(Ballot.class),
						any(ExceedVoteEvent.class))).thenReturn(
				ValidationResult.OK);
		event.submit(ballot);
		assertEquals(oldCount + 1, event.getBallotBox().countBallot());
	}

	@Test
	public void testSubmitShouldIgnoreBallotIfNotAccepted() {
		int oldCount = event.getBallotBox().countBallot();
		when(
				rules.validate(any(Ballot.class), any(Ballot.class),
						any(ExceedVoteEvent.class))).thenReturn(
				ValidationResult.NO_PROJECT_SELECTED);
		event.submit(ballot);
		assertEquals(oldCount, event.getBallotBox().countBallot());
	}

	@Test
	public void testVotingPeriod() {
		event.setStartTime(calendar(1000));
		event.setFinishTime(calendar(10000));
		assertFalse(event.isVotingPeriod(calendar(500)));
		assertTrue(event.isVotingPeriod(calendar(1000)));
		assertTrue(event.isVotingPeriod(calendar(2000)));
		assertTrue(event.isVotingPeriod(calendar(5000)));
		assertFalse(event.isVotingPeriod(calendar(10000)));
		assertFalse(event.isVotingPeriod(calendar(10000)));
	}

	private Calendar calendar(long time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return calendar;
	}

	@Test
	public void testGetProjectsShouldReturnSameList() {
		assertSame(event.getProjects(), event.getProjects());
	}

	@Test
	public void testGetCriteriaShouldReturnSameList() {
		assertSame(event.getCriteria(), event.getCriteria());
	}

}
