package com.github.ant2.exceedvote.model.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.stub.StubContext;
import com.github.ant2.exceedvote.stub.StubDaoFactory;

import static org.junit.Assert.assertEquals;

public class BallotSubmitterTest {

	@Test
	public void test() {
		
		StubContext context = new StubContext();
		StubDaoFactory sdf = context.getDaoFactory();

		Map<Project, Integer> command, count;

		BallotSubmitter submitter = new BallotSubmitter(context, sdf.C1);
		BallotRetriever retriever = new BallotRetriever(context, sdf.C1);
		
		// ---
		command = new HashMap<Project, Integer>();
		command.put(sdf.P1, 2);
		command.put(sdf.P2, 1);
		command.put(sdf.P4, 3);
		submitter.submit(command);
		
		count = retriever.count();
		assertEquals((Integer)2, count.get(sdf.P1));
		assertEquals((Integer)1, count.get(sdf.P2));
		assertEquals(null, count.get(sdf.P3));
		assertEquals((Integer)3, count.get(sdf.P4));
		
		// ---
		command = new HashMap<Project, Integer>(count);
		command.put(sdf.P1, 3);
		command.put(sdf.P2, 0);
		command.put(sdf.P3, 0);
		command.put(sdf.P4, 0);
		submitter.submit(command);
		
		count = retriever.count();
		assertEquals((Integer)3, count.get(sdf.P1));
		assertEquals(null, count.get(sdf.P2));
		assertEquals(null, count.get(sdf.P3));
		assertEquals(null, count.get(sdf.P4));
		
	}

}
