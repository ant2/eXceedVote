package com.github.ant2.exceedvote.model.process;

import java.util.List;

import org.junit.Test;

import com.github.ant2.exceedvote.dao.memory.StubDaoFactory;
import com.github.ant2.exceedvote.model.domain.Project;

import static org.junit.Assert.assertTrue;

public class ViewProjectProcessTest {

	@Test
	public void test() {

		StubDaoFactory sdf = new StubDaoFactory();

		ViewProjectProcess process = new ViewProjectProcess(sdf.CONTEXT);

		List<Project> projects = process.getAllAvailableProjects();
		assertTrue(projects.contains(sdf.P1));
		assertTrue(projects.contains(sdf.P2));
		assertTrue(projects.contains(sdf.P3));
		assertTrue(projects.contains(sdf.P4));


	}

}
