package com.github.ant2.exceedvote;

import static org.junit.Assert.*;

import org.junit.Test;

public class BallotTest {

	private Voter voter = new Voter();
	private Project project = new Project("Test Project", "This is a test project.");
	private Criterion criterion = new Criterion("Exceed");
	private Ballot ballot = new Ballot(voter, project, criterion);

	@Test
	public void testGetVoter() {
		assertSame(ballot.getVoter(), voter);
	}
	
	@Test
	public void testGetProject() {
		assertSame(ballot.getProject(), project);
	}

	@Test
	public void testGetCriterion() {
		assertSame(ballot.getCriterion(), criterion);
	}
	
}
