package com.github.ant2.exceedvote.model.process;

import java.util.List;

import org.junit.Test;

import com.github.ant2.exceedvote.model.Criterion;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.mock.MockVoteEvent;

import static org.junit.Assert.assertTrue;

public class CriterionSelectionProcessTest {

	@Test
	public void test() {

		MockVoteEvent mockEvent = new MockVoteEvent();
		VoteEvent event = mockEvent;

		CriterionSelectionProcess process = new CriterionSelectionProcess(event);
		List<Criterion> criteria = process.getAllCriteria();

		assertTrue(criteria.contains(mockEvent.c1));
		assertTrue(criteria.contains(mockEvent.c2));
		assertTrue(criteria.contains(mockEvent.c3));

	}

}
