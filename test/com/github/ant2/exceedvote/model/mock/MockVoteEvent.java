package com.github.ant2.exceedvote.model.mock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.github.ant2.exceedvote.model.AbstractVoteEvent;
import com.github.ant2.exceedvote.model.Criterion;
import com.github.ant2.exceedvote.model.ExceedVoteEvent;
import com.github.ant2.exceedvote.model.Project;

public class MockVoteEvent extends AbstractVoteEvent {

	private List<Project> projects = new ArrayList<Project>();
	private List<Criterion> criteria = new ArrayList<Criterion>();

	public final Project p1 = new Project("Project 1", "P1");
	public final Project p2 = new Project("Project 2", "P2");
	public final Project p3 = new Project("Project 3", "P3");
	public final Project p4 = new Project("Project 4", "P4");

	public final Criterion c1 = new Criterion("Criterion 1");
	public final Criterion c2 = new Criterion("Criterion 2");
	public final Criterion c3 = new Criterion("Criterion 3");
	
	@Override
	public int getRemainingTime(Calendar calendar) {
		return 10000;
	}

	@Override
	public List<Project> getProjects() {
		return projects;
	}

	@Override
	public List<Criterion> getCriteria() {
		return criteria;
	}

	@Override
	public boolean isVotingPeriod() {
		return true;
	}
	
	@Override
	public boolean isVotingPeriod(Calendar calendar) {
		return true;
	}
	
}
