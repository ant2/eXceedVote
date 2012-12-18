package com.github.ant2.exceedvote.model.process;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * A context represents a Voter's state: the DAO factory being used, the vote
 * event the current voter is voting, and the voter itself.
 * 
 * @author dtinth
 */
public class Context {

	private VoteEvent event;
	private Voter voter;
	private DaoFactory daoFactory;

	/**
	 * Constructs a new Context.
	 */
	public Context() {
	}

	/**
	 * Constructs a new Context with specified Dao Factory, Event and Voter.
	 * 
	 * @param daoFactory
	 *            the dao factory
	 * @param event
	 *            the event
	 * @param voter
	 *            the voter
	 */
	public Context(DaoFactory daoFactory, VoteEvent event, Voter voter) {
		this.daoFactory = daoFactory;
		setEvent(event);
		setVoter(voter);
	}

	/**
	 * Returns the voter
	 * 
	 * @return the voter
	 */
	public Voter getVoter() {
		return voter;
	}

	/**
	 * Sets the voter.
	 * 
	 * @param voter
	 *            the voter to set
	 */
	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	/**
	 * Returns the event.
	 * 
	 * @return the event
	 */
	public VoteEvent getEvent() {
		return event;
	}

	/**
	 * Sets the event.
	 * 
	 * @param event
	 *            the event to set
	 */
	public void setEvent(VoteEvent event) {
		this.event = event;
	}

	/**
	 * Returns the Dao Factory.
	 * 
	 * @return the dao factory
	 */
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	/**
	 * Sets the Dao Factory.
	 * 
	 * @param daoFactory
	 *            the dao factory to set
	 */
	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/**
	 * Creates a view project process.
	 * 
	 * @return the new view project process
	 */
	public ViewProjectProcess createViewProjectProcess() {
		return new ViewProjectProcess(this);
	}

	/**
	 * Creates a criterion selection process.
	 * 
	 * @return the new criterion selection process
	 */
	public CriterionSelectionProcess createCriterionSelectionProcess() {
		return new CriterionSelectionProcess(this);
	}

}
