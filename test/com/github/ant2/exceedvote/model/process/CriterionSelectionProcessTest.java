package com.github.ant2.exceedvote.model.process;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.stub.StubDaoFactory;
import com.github.ant2.exceedvote.view.CriterionListCellRenderer;

import static org.junit.Assert.assertTrue;

public class CriterionSelectionProcessTest {

	@Test
	public void test() {

		StubDaoFactory sdf = new StubDaoFactory();

		CriterionSelectionProcess process = new CriterionSelectionProcess(
				new Context(sdf, sdf.EVENT, null));

		List<CriterionInfo> criteria = process.getAllCriteria();
		List<Criterion> criterionList = new ArrayList<Criterion>();
		for (CriterionInfo info : criteria) {
			criterionList.add(info.getCriterion());
		}

		assertTrue(criterionList.contains(sdf.C1));
		assertTrue(criterionList.contains(sdf.C2));
		assertTrue(criterionList.contains(sdf.C3));

	}

}
