package com.github.ant2.exceedvote.model;

import org.junit.Test;

import com.github.ant2.exceedvote.model.domain.Criterion;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Criterion class.
 * 
 * @author Artima Mahahemarat
 */
public class CriterionTest {
	private Criterion criterion = new Criterion("Test");

	@Test
	public void testGetName() {
		assertEquals("Test", criterion.getName());
	}

	@Test
	public void testSetName() {
		criterion.setName("New Test");
		assertEquals("New Test", criterion.getName());
	}

	@Test
	public void testToString() {
		assertEquals("Test", criterion.toString());
	}

}
