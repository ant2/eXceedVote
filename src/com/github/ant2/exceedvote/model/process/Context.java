package com.github.ant2.exceedvote.model.process;

import com.github.ant2.exceedvote.model.Criterion;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;

public class Context {

	private VoteEvent event;
	private Voter voter;

	public Context() {
	}

	public Context(VoteEvent event, Voter voter) {
		setEvent(event);
		setVoter(voter);
	}

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	public VoteEvent getEvent() {
		return event;
	}

	public void setEvent(VoteEvent event) {
		this.event = event;
	}

	public ViewProjectProcess createViewProjectProcess() {
		return new ViewProjectProcess(event);
	}

	public CriterionSelectionProcess createCriterionSelectionProcess() {
		return new CriterionSelectionProcess(event);
	}
	
	public VotingProcess createVotingProcess(Criterion criterion) {
		return new VotingProcess(event, voter, criterion);
	}

}
