package com.github.ant2.exceedvote.model.process;

import java.util.List;

import org.junit.Test;

import com.github.ant2.exceedvote.model.Project;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.mock.MockVoteEvent;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ViewProjectProcessTest {

	@Test
	public void test() {

		MockVoteEvent mockEvent = new MockVoteEvent();
		VoteEvent event = mockEvent;

		ViewProjectProcess process = new ViewProjectProcess(event);

		List<Project> projects = process.getAllAvailableProjects();
		assertTrue(projects.contains(mockEvent.p1));
		assertTrue(projects.contains(mockEvent.p2));
		assertTrue(projects.contains(mockEvent.p3));
		assertTrue(projects.contains(mockEvent.p4));

		assertNotNull(process.getProjectInfo(mockEvent.p1));
		assertNotNull(process.getProjectInfo(mockEvent.p2));

	}

}
