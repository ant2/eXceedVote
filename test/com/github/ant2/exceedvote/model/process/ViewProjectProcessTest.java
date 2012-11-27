package com.github.ant2.exceedvote.model.process;

import java.util.List;

import org.junit.Test;

import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.stub.StubContext;
import com.github.ant2.exceedvote.stub.StubDaoFactory;

import static org.junit.Assert.assertTrue;

public class ViewProjectProcessTest {

	@Test
	public void test() {

		StubContext context = new StubContext();
		StubDaoFactory sdf = context.getDaoFactory();

		ViewProjectProcess process = new ViewProjectProcess(context);

		List<Project> projects = process.getAllAvailableProjects();
		assertTrue(projects.contains(sdf.P1));
		assertTrue(projects.contains(sdf.P2));
		assertTrue(projects.contains(sdf.P3));
		assertTrue(projects.contains(sdf.P4));

	}

}
