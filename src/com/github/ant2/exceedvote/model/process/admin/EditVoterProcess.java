package com.github.ant2.exceedvote.model.process.admin;

import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * 
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class EditVoterProcess {

	private Voter voter;
	private VoterDao voterDao;

	public EditVoterProcess(Voter voter, VoterDao voterDao) {
		this.voter = voter;
		this.voterDao = voterDao;
	}

	public void setName(String name) {
		voter.setName(name);
	}

	public void setUsername(String username) {
		voter.getUser().setUsername(username);
	}

	public void setPassword(String password) {
		voter.getUser().setPass(password);
	}

	public void save() {
		voterDao.save(voter);
	}

}
