package com.github.ant2.exceedvote.model.process.admin;

import java.util.List;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * The process for managing voter.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class ManageVoterProcess {
	private DaoFactory df;
	private VoteEvent event;
	private VoterDao voterDao;

	/**
	 * Constructs the new ManageVoterProcess.
	 * 
	 * @param df
	 *            the DAO factory to get all other DAO
	 * @param event
	 *            the editing event
	 */
	public ManageVoterProcess(DaoFactory df, VoteEvent event) {
		this.df = df;
		this.event = event;
		voterDao = df.getVoterDao();
	}

	/**
	 * Returns list of all voters.
	 * 
	 * @return list of all voters
	 */
	public List<Voter> getAllVoters() {
		return voterDao.findAllByEvent(event);
	}

	/**
	 * Create the new EditVoterProcess.
	 * 
	 * @param voter
	 *            the editing voter
	 * @return the EditVoterProcess object
	 */
	public EditVoterProcess editVoter(Voter voter) {
		return new EditVoterProcess(voter, voterDao);
	}

	/**
	 * Create the new ManageVoterProcess.
	 * 
	 * @return the ManageVoterProcess object
	 */
	public ManageVoterProcess manageVoters() {
		return new ManageVoterProcess(df, event);
	}

	/**
	 * Removes a Voter.
	 * 
	 * @param voter
	 *            the Voter to remove
	 */
	public void removeVoter(Voter voter) {
		voterDao.remove(voter);
	}
}
