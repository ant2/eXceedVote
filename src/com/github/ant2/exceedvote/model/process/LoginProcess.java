
package com.github.ant2.exceedvote.model.process;

import com.github.ant2.exceedvote.dao.CommissionerDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.UserDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Commissioner;
import com.github.ant2.exceedvote.model.domain.User;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * A login process
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class LoginProcess {
	private DaoFactory sd;
	private UserDao userDao;
	private VoterDao voterDao;
	private CommissionerDao commissionerDao;

	/**
	 * @param sd
	 *            the DAOFactory
	 */
	public LoginProcess(DaoFactory sd) {
		this.sd = sd;
		userDao = sd.getUserDao();
		voterDao = sd.getVoterDao();
		commissionerDao = sd.getCommissionerDao();
	}

	/**
	 * Logins the system
	 * 
	 * @param user
	 *            the login user
	 * @param pass
	 *            the user's password
	 * @return the login result
	 */
	public LoginResult login(String user, String pass) {
		User u = userDao.findByUserName(user);
		if (u == null) return new LoginResult(LoginResult.Status.FAILURE);
		if (u.verifyPassword(pass)) {
			Voter v = voterDao.findByUser(u);
			Commissioner c = commissionerDao.findByUser(u);
			LoginResult result = new LoginResult(LoginResult.Status.SUCCESS);
			if (v != null) {
				result.setVoter(v);
				return result;
			} else if (c != null) {
				result.setCommissioner(c);
				return result;
			}
		}
		return new LoginResult(LoginResult.Status.FAILURE);
	}

	/**
	 * Gets the context
	 * 
	 * @param result
	 *            the result of login
	 * @return the context contains the result
	 */
	public Context getContext(LoginResult result) {
		Voter voter = result.getVoter();
		if (voter == null) return null;
		return new Context(sd, voter.getVoteEvent(), voter);
	}

	/**
	 * Gets the DAOFactory
	 * 
	 * @return the DAOFactory
	 */
	public DaoFactory getDaoFactory() {
		return sd;
	}
}
