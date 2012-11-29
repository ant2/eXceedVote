package com.github.ant2.exceedvote.model.process;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.UserDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.LoginResult;
import com.github.ant2.exceedvote.model.domain.User;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * 
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
// TODO javadoc
public class LoginProcess {
	private DaoFactory sd;
	private UserDao userDao;
	private VoterDao voterDao;

	public LoginProcess(DaoFactory sd) {
		this.sd = sd;
		userDao = sd.getUserDao();
		voterDao = sd.getVoterDao();
	}

	public LoginResult login(String user, String pass) {
		User u = userDao.findByUserName(user);
		if (u == null) return new LoginResult(LoginResult.Status.FAILURE);
		if (u.verifyPassword(pass)) {
			Voter v = voterDao.findByUser(u);
			LoginResult result = new LoginResult(LoginResult.Status.SUCCESS);
			if (v != null) {
				result.setVoter(v);
				return result;
			}
		}
		return new LoginResult(LoginResult.Status.FAILURE);
	}

	public Context getContext(LoginResult result) {
		Voter voter = result.getVoter();
		if (voter == null) return null;
		return new Context(sd, voter.getVoteEvent(), voter);
	}

}
