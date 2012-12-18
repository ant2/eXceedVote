package com.github.ant2.exceedvote.model.process;

import com.github.ant2.exceedvote.model.domain.Commissioner;
import com.github.ant2.exceedvote.model.domain.User;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * A login result process
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class LoginResult {
	private Status status;
	private Voter voter;
	private Commissioner commissioner;
	private User.Role role;

	/**
	 * The status of the login
	 * 
	 * @author Thiwat Rongsirigul (Leo Aiolia)
	 */
	public enum Status {
		/** Login success */
		SUCCESS,

		/** Login failure */
		FAILURE;
	}

	/**
	 * Sets the status to the LoginResult
	 * 
	 * @param status
	 *            the status that is set
	 */
	public LoginResult(Status status) {
		this.status = status;
	}

	/**
	 * Sets the voter
	 * 
	 * @param voter
	 *            the voter that is set
	 */
	public void setVoter(Voter voter) {
		role = User.Role.VOTER;
		this.voter = voter;
	}

	/**
	 * Sets the commissioner
	 * 
	 * @param commissioner
	 *            the commissioner that is set
	 */
	public void setCommissioner(Commissioner commissioner) {
		role = User.Role.COMMISSION;
		this.commissioner = commissioner;
	}

	/**
	 * Gets the status
	 * 
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Gets the user's role
	 * 
	 * @return the user's role
	 */
	public User.Role getRole() {
		return role;
	}

	/**
	 * Gets the voter
	 * 
	 * @return the voter
	 */
	public Voter getVoter() {
		return voter;
	}

	/**
	 * Gets the commissioner
	 * 
	 * @return the commissioner
	 */
	public Commissioner getCommissioner() {
		return commissioner;
	}

	@Override
	public String toString() {
		return status.toString();
	}

}
