package com.github.ant2.exceedvote.model.process.admin;

import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * The process for editing voter.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class EditVoterProcess {

	private Voter voter;
	private VoterDao voterDao;

	/**
	 * Constructs a new EditVoterProcess.
	 * 
	 * @param voter
	 *            the voter to be edit
	 * @param voterDao
	 *            the DAO object of voter
	 */
	public EditVoterProcess(Voter voter, VoterDao voterDao) {
		this.voter = voter;
		this.voterDao = voterDao;
	}

	/**
	 * Set the name of the voter.
	 * 
	 * @param name
	 *            name of the voter
	 */
	public void setName(String name) {
		voter.setName(name);
	}

	/**
	 * Set the username of the voter.
	 * 
	 * @param username
	 *            username of the voter
	 */
	public void setUsername(String username) {
		voter.getUser().setUsername(username);
	}

	/**
	 * Set the password of the voter.
	 * 
	 * @param password
	 *            password of the voter
	 */
	public void setPassword(String password) {
		voter.getUser().setPass(password);
	}

	/**
	 * Save the voter to the database
	 */
	public void save() {
		voterDao.save(voter);
	}

}
