package com.github.ant2.exceedvote.model.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class User extends Model {
	public enum Role {
		VOTER, COMMISSION
	}
	
	private String username;
	private String pass;

	public User(String username, String pass) {
		this.username = username;
		this.pass = pass;
	}

	public boolean verifyPassword(String pass) {
		if (pass.equals(this.pass)) return true;
		return false;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Id @GeneratedValue protected Integer id;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
