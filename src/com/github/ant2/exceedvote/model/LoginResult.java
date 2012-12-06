package com.github.ant2.exceedvote.model;

import com.github.ant2.exceedvote.model.domain.Commissioner;
import com.github.ant2.exceedvote.model.domain.User;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * 
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
// TODO javadoc
public class LoginResult {
	private Status status;
	private Voter voter;
	private Commissioner commissioner;
	private User.Role role;

	public enum Status {
		SUCCESS, FAILURE;
	}

	public LoginResult(Status status) {
		this.status = status;
	}

	public void setVoter(Voter voter) {
		role = User.Role.VOTER;
		this.voter = voter;
	}
	
	public void setCommissioner(Commissioner commissioner) {
		role = User.Role.COMMISSION;
		this.commissioner = commissioner;
	}

	public Status getStatus() {
		return status;
	}

	public User.Role getRole() {
		return role;
	}

	public Voter getVoter() {
		return voter;
	}
	
	public Commissioner getCommissioner() {
		return commissioner;
	}

	@Override
	public String toString() {
		return status.toString();
	}

}
