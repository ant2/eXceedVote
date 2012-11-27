package com.github.ant2.exceedvote.model.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoteEventTest {

	@Test
	public void testCreateProject() {
		VoteEvent event = new VoteEvent();
		Project project = event.createProject("Hello!");
		assertEquals("Hello!", project.getName());
	}

}
