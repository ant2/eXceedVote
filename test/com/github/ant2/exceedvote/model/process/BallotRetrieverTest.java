package com.github.ant2.exceedvote.model.process;

import java.util.Map;

import org.junit.Test;

import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.stub.StubContext;
import com.github.ant2.exceedvote.stub.StubDaoFactory;

import static org.junit.Assert.assertEquals;

public class BallotRetrieverTest {

	@Test
	public void test() {

		StubContext context = new StubContext();
		StubDaoFactory sdf = context.getDaoFactory();

		// create several ballots to test
		Ballot b1 = new Ballot(sdf.P1, sdf.C1, context.SELF, 3);
		Ballot b2 = new Ballot(sdf.P2, sdf.C2, context.SELF, 2);
		Ballot b3 = new Ballot(sdf.P4, sdf.C2, context.SELF, 1);
		Ballot b4 = new Ballot(sdf.P1, sdf.C2, context.OTHER, 3);
		Ballot b5 = new Ballot(sdf.P3, sdf.C1, context.OTHER, 3);

		// save the ballot
		Ballot[] ballots = { b1, b2, b3, b4, b5 };
		for (Ballot ballot : ballots) {
			sdf.getBallotDao().save(ballot);
		}

		// retrieve them back
		BallotRetriever retriever = new BallotRetriever(context, sdf.C2);

		// test retrieve
		Map<Project, Ballot> map = retriever.retrieve();
		assertEquals(null, map.get(sdf.P1));
		assertEquals(b2, map.get(sdf.P2));
		assertEquals(null, map.get(sdf.P3));
		assertEquals(b3, map.get(sdf.P4));

		// test count
		Map<Project, Integer> count = retriever.count();
		assertEquals(null, count.get(sdf.P1));
		assertEquals((Integer) 2, count.get(sdf.P2));
		assertEquals(null, count.get(sdf.P3));
		assertEquals((Integer) 1, count.get(sdf.P4));

	}

}
