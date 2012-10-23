package com.github.ant2.exceedvote.model;

import org.junit.Test;

import com.github.ant2.exceedvote.model.Rules.ValidationResult;
import com.github.ant2.exceedvote.model.mock.MockVoteEvent;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class VoteForProjectTest {

	@Test
	public void test() {

		MockVoteEvent event = new MockVoteEvent();
		Voter voter = mock(Voter.class);

		when(voter.getAllowedBallots()).thenReturn(2);

		VotingProcess process = new VotingProcess(event, voter);

		Ballot ballot = process.createBallot();
		assertNotNull(ballot);

		assertNotSame(ValidationResult.OK, process.checkBallot(ballot));
		assertNotSame(ValidationResult.OK, process.submitBallot(ballot));

		ballot.setProject(event.p1);
		assertNotSame(ValidationResult.OK, process.checkBallot(ballot));
		assertNotSame(ValidationResult.OK, process.submitBallot(ballot));

		ballot.setProject(event.p2);
		assertNotSame(ValidationResult.OK, process.checkBallot(ballot));
		assertNotSame(ValidationResult.OK, process.submitBallot(ballot));

		ballot.setProject(null);
		ballot.setCriterion(event.c1);
		assertNotSame(ValidationResult.OK, process.checkBallot(ballot));
		assertNotSame(ValidationResult.OK, process.submitBallot(ballot));

		ballot.setProject(event.p1);
		ballot.setCriterion(event.c1);
		assertSame(ValidationResult.OK, process.checkBallot(ballot));
		assertSame(ValidationResult.OK, process.submitBallot(ballot));

		ballot.setProject(event.p2);
		ballot.setCriterion(event.c3);
		assertSame(ValidationResult.OK, process.checkBallot(ballot));
		assertSame(ValidationResult.OK, process.submitBallot(ballot));

		ballot = process.createBallot();
		ballot.setProject(event.p2);
		ballot.setCriterion(event.c1);
		assertNotSame(ValidationResult.OK, process.checkBallot(ballot));
		assertNotSame(ValidationResult.OK, process.submitBallot(ballot));

	}

}
