package com.github.ant2.exceedvote.model.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.exceedvote.stub.StubContext;
import com.github.ant2.exceedvote.stub.StubDaoFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VotingProcessTest {

	@Test
	public void test() {

		StubContext context = new StubContext();
		StubDaoFactory sdf = context.getDaoFactory();
		
		Voter voter = mock(Voter.class);
		when(voter.getAllowedBallots()).thenReturn(3);

		VoteEvent event = sdf.EVENT;
		Criterion criterion = sdf.C1;

		{
			// submit few ballots first...
			BallotSubmitter submitter = new BallotSubmitter(context, criterion);
			Map<Project, Integer> command = new HashMap<Project, Integer>();
			command.put(sdf.P4, 3);
			submitter.submit(command);
		}
		
		VotingProcess process = new VotingProcess(context, criterion);
		
		List<Project> projects = process.getProjects();
		assertTrue(projects.contains(sdf.P1));
		assertTrue(projects.contains(sdf.P2));
		assertTrue(projects.contains(sdf.P3));
		assertTrue(projects.contains(sdf.P4));

		assertEquals(3, process.getCount(sdf.P4));
		assertFalse(process.canIncrease());
		process.decrease(sdf.P4);
		process.decrease(sdf.P4);
		process.decrease(sdf.P4);
		process.decrease(sdf.P4);
		assertEquals(0, process.getCount(sdf.P4));
		assertTrue(process.canIncrease());

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
