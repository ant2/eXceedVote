package com.github.ant2.exceedvote.model.process;

import java.util.List;

import com.github.ant2.exceedvote.model.Ballot;
import com.github.ant2.exceedvote.model.Criterion;
import com.github.ant2.exceedvote.model.Project;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;

/**
 * A voting Process.
 * 
 * @author Nutnicha Charoenporn
 */
public class VotingProcess {

	/** A list of projects */
	private List<Project> projects;
	
	/** A vote event */
	private VoteEvent event;
	
	/** A voter */
	private Voter voter;
	
	/** A criterion */
	private Criterion criterion;
	
	/** A Ballot */
	private Ballot ballot;
	
	/**
	 * Constructs the ViewProjectProcess. Initializes the event, voter, and criterion.
	 */
	public VotingProcess(VoteEvent event, Voter voter, Criterion criterion) {
		this.event = event;
		this.voter = voter;
		this.criterion = criterion;
	}

	public List<Project> getProjects() {
		if(projects == null){
			projects = event.getProjects();
		}
		return projects;
	}

	public boolean canIncrease() {
		if(event.isQuotaReachedForVoter(voter, ballot)) {
			return false;
		}
		return true;
	}

	public boolean canDecrease(Project project) {
		if(event.isQuotaReachedForVoter(voter, ballot)) {
			return true;
		}
		return false;
	}

	public void increase(Project project) {
		if(canIncrease()){
			
		}
	}

	public Object getCount(Project project) {
		
		return null;
	}

	public void decrease(Project project) {
		if(canDecrease(project)){
			
		}

	}

	public void submit() {
		event.submit(ballot);
	}

}
