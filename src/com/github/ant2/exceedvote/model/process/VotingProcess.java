package com.github.ant2.exceedvote.model.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * 
 * 
 * @author Artima Mahahemarat
 */
public class VotingProcess {

	private VoteEvent event;
	private Voter voter;
	private Criterion criterion;
	private int count;
	private int[] a;
	private DaoFactory df;
	private List<Project> projects;

	public VotingProcess(Context context, Criterion criterion) {
		this.event = context.getEvent();
		this.voter = context.getVoter();
		this.criterion = criterion;
		df = context.getDaoFactory();
		a = new int[getProjects().size()];
	}

	public void setDaoFactory(DaoFactory df) {
		this.df = df;
	}

	public List<Project> getProjects() {
		if (projects == null) {
			projects = df.getProjectDao().findAllByEvent(event);
		}
		return projects;
	}

	public boolean canIncrease() {
		return count < voter.getAllowedBallots();
	}

	public boolean canDecrease(Project project) {
		int i = getProjects().indexOf(project);
		return a[i] > 0;
	}

	public void increase(Project project) {
		if (!canIncrease()) return;
		int i = getProjects().indexOf(project);
		a[i]++;
		count++;
	}

	public int getCount(Project project) {
		int i = getProjects().indexOf(project);
		return a[i];
	}

	public void decrease(Project project) {
		if (!canDecrease(project)) return;
		int i = getProjects().indexOf(project);
		a[i]--;
		count--;
	}

	public void submit() {
		Map<Project, Integer> map = new HashMap<Project, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				continue;
			}
			for (int j = 0; j < a[i]; j++) {
				Project project = getProjects().get(i);
				map.put(project, a[i]);
			}
		}
		new BallotSubmitter(voter, criterion).submit(map);
	}

	public Criterion getCriterion() {
		return criterion;
	}

	public int getUsedBallots() {
		return count;
	}

	public int getTotalBallots() {
		return voter.getAllowedBallots();
	}

}
