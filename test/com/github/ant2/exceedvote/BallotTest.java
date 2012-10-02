package com.github.ant2.exceedvote;

import org.junit.Test;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.assertSame;

/**
 * Unit test for Ballot class.
 * 
 * @author dtinth
 */
public class BallotTest {

	private Voter voter = mock(Voter.class);
	private Project project = mock(Project.class);
	private Criterion criterion = mock(Criterion.class);

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

	@Test
	public void testSetProject() {
		Project testProject = mock(Project.class);
		ballot.setProject(testProject);
		assertSame(ballot.getProject(), testProject);
	}

	@Test
	public void testSetCriterion() {
		Criterion testCriterion = mock(Criterion.class);
		ballot.setCriterion(testCriterion);
		assertSame(ballot.getCriterion(), testCriterion);
	}

}
