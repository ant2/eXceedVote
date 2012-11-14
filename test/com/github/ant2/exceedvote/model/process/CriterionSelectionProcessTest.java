package com.github.ant2.exceedvote.model.process;

import java.util.List;

import org.junit.Test;

import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.mock.MockVoteEvent;

import static org.junit.Assert.assertTrue;

public class CriterionSelectionProcessTest {

	@Test
	public void test() {

		CriterionSelectionProcess process = new CriterionSelectionProcess(
				new Context(event, null));
		List<Criterion> criteria = process.getAllCriteria();

		assertTrue(criteria.contains(mockEvent.c1));
		assertTrue(criteria.contains(mockEvent.c2));
		assertTrue(criteria.contains(mockEvent.c3));

	}

}
