package com.github.ant2.exceedvote.model.process;

import java.util.List;

import org.junit.Test;

import com.github.ant2.exceedvote.dao.memory.StubDaoFactory;
import com.github.ant2.exceedvote.model.domain.Criterion;

import static org.junit.Assert.assertTrue;

public class CriterionSelectionProcessTest {

	@Test
	public void test() {

		StubDaoFactory sdf = new StubDaoFactory();
		
		CriterionSelectionProcess process = new CriterionSelectionProcess(
				new Context(sdf, sdf.EVENT, null));
		
		List<Criterion> criteria = process.getAllCriteria();

		assertTrue(criteria.contains(sdf.C1));
		assertTrue(criteria.contains(sdf.C2));
		assertTrue(criteria.contains(sdf.C3));

	}

}
