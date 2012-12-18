package com.github.ant2.exceedvote.model.process;

import org.junit.Test;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.process.admin.VoteCount;
import com.github.ant2.exceedvote.model.process.admin.VoteCounter;
import com.github.ant2.exceedvote.model.process.admin.VoteCounterResult;
import com.github.ant2.exceedvote.stub.StubContext;
import com.github.ant2.exceedvote.stub.StubDaoFactory;

import static org.junit.Assert.assertEquals;

public class BallotCounterTest {

	@Test
	public void testBallotCounter() {

		StubContext context = new StubContext();
		StubDaoFactory sdf = context.getDaoFactory();

		// create several ballots to test
		Ballot b1 = new Ballot(sdf.P1, sdf.C1, context.SELF, 3);
		Ballot b5 = new Ballot(sdf.P3, sdf.C1, context.OTHER, 2);
		Ballot b6 = new Ballot(sdf.P3, sdf.C1, context.SELF, 3);

		Ballot b2 = new Ballot(sdf.P2, sdf.C2, context.SELF, 2);
		Ballot b3 = new Ballot(sdf.P4, sdf.C2, context.SELF, 1);
		Ballot b4 = new Ballot(sdf.P1, sdf.C2, context.OTHER, 3);

		// save the ballot
		Ballot[] ballots = { b1, b2, b3, b4, b5, b6 };
		for (Ballot ballot : ballots) {
			sdf.getBallotDao().save(ballot);
		}

		// retrieve them back
		DaoFactory df = sdf;
		VoteCounter counter = new VoteCounter(df, sdf.EVENT);
		VoteCounterResult result = counter.count();
		VoteCount count = result.forCriterion(sdf.C1);
		assertEquals(3, count.get(sdf.P1));
		assertEquals(0, count.get(sdf.P2));
		assertEquals(5, count.get(sdf.P3));
		assertEquals(0, count.get(sdf.P4));
		count = result.forCriterion(sdf.C2);
		assertEquals(3, count.get(sdf.P1));
		assertEquals(2, count.get(sdf.P2));
		assertEquals(0, count.get(sdf.P3));
		assertEquals(1, count.get(sdf.P4));

	}

}
