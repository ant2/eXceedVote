package com.github.ant2.exceedvote.domain;

import org.junit.Test;

import com.github.ant2.exceedvote.domain.Project;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Project class.
 * 
 * @author Artima Mahahemarat
 */

public class ProjectTest {
	private Project project = new Project("Test", "This is a test");

	@Test
	public void testGetName() {
		assertEquals("Test", project.getName());
	}

	@Test
	public void testGetDescription() {
		assertEquals("This is a test", project.getDescription());
	}

	@Test
	public void testSetName() {
		project.setName("New test");
		assertEquals("New test", project.getName());
	}

	@Test
	public void testSetDescription() {
		project.setDescription("This is a new test");
		assertEquals("This is a new test", project.getDescription());
	}

	@Test
	public void testToString() {
		assertEquals("Test", project.toString());
	}
}
