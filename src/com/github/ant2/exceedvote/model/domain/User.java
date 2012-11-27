package com.github.ant2.exceedvote.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
// TODO javadoc

@Entity
@Table(name = "user_credentials")
public class User extends Model {
	public enum Role {
		VOTER, COMMISSION
	}

	private String username;
	private String password;

	public User() {
	}

	public User(String username, String pass) {
		this.username = username;
		password = pass;
	}

	public boolean verifyPassword(String pass) {
		if (pass.equals(password)) return true;
		return false;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String pass) {
		password = pass;
	}

	@Id @GeneratedValue protected Integer id;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
