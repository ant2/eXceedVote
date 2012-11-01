package com.github.ant2.exceedvote.model.process;

import java.util.List;

import com.github.ant2.exceedvote.model.Ballot;
import com.github.ant2.exceedvote.model.Criterion;
import com.github.ant2.exceedvote.model.Project;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;

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

	public VotingProcess(VoteEvent event, Voter voter, Criterion criterion) {
		this.event = event;
		this.voter = voter;
		this.criterion = criterion;
		a = new int[getProjects().size()];
	}

	public List<Project> getProjects() {
		return event.getProjects();
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
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				continue;
			}
			for (int j = 0; j < a[i]; j++) {
				Project project = getProjects().get(i);
				Ballot b = new Ballot(voter, project, criterion);
				event.submit(b);
			}
		}
	}
}
