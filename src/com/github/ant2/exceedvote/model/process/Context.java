package com.github.ant2.exceedvote.model.process;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

public class Context {

	private VoteEvent event;
	private Voter voter;
	private DaoFactory daoFactory;

	public Context() {
	}

	public Context(DaoFactory daoFactory, VoteEvent event, Voter voter) {
		this.daoFactory = daoFactory;
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

	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	public ViewProjectProcess createViewProjectProcess() {
		return new ViewProjectProcess(this);
	}

	public CriterionSelectionProcess createCriterionSelectionProcess() {
		return new CriterionSelectionProcess(this);
	}

}
