package com.github.ant2.exceedvote.model.process;

import java.util.List;

import org.junit.Test;

import com.github.ant2.exceedvote.model.Criterion;
import com.github.ant2.exceedvote.model.Project;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;
import com.github.ant2.exceedvote.model.mock.MockVoteEvent;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VotingProcessTest {

	@Test
	public void test() {

		MockVoteEvent mockEvent = new MockVoteEvent();
		Voter voter = mock(Voter.class);
		when(voter.getAllowedBallots()).thenReturn(3);

		VoteEvent event = mockEvent;
		Criterion criterion = mockEvent.c1;

		VotingProcess process = new VotingProcess(event, voter, criterion);

		List<Project> projects = process.getProjects();
		assertTrue(projects.contains(mockEvent.p1));
		assertTrue(projects.contains(mockEvent.p2));
		assertTrue(projects.contains(mockEvent.p3));
		assertTrue(projects.contains(mockEvent.p4));

		assertFalse(process.canDecrease(projects.get(0)));
		assertTrue(process.canIncrease());
		process.increase(projects.get(0));
		assertTrue(process.canDecrease(projects.get(0)));

		assertTrue(process.canIncrease());
		process.increase(projects.get(1));

		assertTrue(process.canIncrease());
		process.increase(projects.get(1));

		assertFalse(process.canDecrease(projects.get(2)));
		assertFalse(process.canIncrease());
		process.increase(projects.get(2));
		assertFalse(process.canDecrease(projects.get(2)));

		assertEquals(1, process.getCount(projects.get(0)));
		assertEquals(2, process.getCount(projects.get(1)));
		assertEquals(0, process.getCount(projects.get(2)));
		assertEquals(0, process.getCount(projects.get(3)));

		process.decrease(projects.get(1));
		assertTrue(process.canIncrease());
		assertEquals(1, process.getCount(projects.get(1)));

		process.increase(projects.get(2));
		assertEquals(1, process.getCount(projects.get(1)));
		assertEquals(1, process.getCount(projects.get(2)));

		process.submit();

	}

}
