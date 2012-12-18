package com.github.ant2.exceedvote.model.process.admin;

import java.util.List;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * 
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class ManageVoterProcess {
	private DaoFactory df;
	private VoteEvent event;
	private VoterDao voterDao;

	public ManageVoterProcess(DaoFactory df, VoteEvent event) {
		this.df = df;
		this.event = event;
		voterDao = df.getVoterDao();
	}

	public List<Voter> getAllVoters() {
		return voterDao.findAllByEvent(event);
	}

	public EditVoterProcess editVoter(Voter voter) {
		return new EditVoterProcess(voter, voterDao);
	}

}
