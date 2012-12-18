package com.github.ant2.exceedvote.dao;

import com.github.ant2.exceedvote.model.domain.User;

/**
 * The UserDao class is responsible for saving a user and find a user by a
 * username
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public interface UserDao {

	/**
	 * Saves the user into persistent unit
	 * 
	 * @param user
	 *            the user that is going to be saved
	 */
	public void save(User user);

	/**
	 * Finds the user by username
	 * 
	 * @param user
	 *            the user that is chosen
	 * @return the user
	 */
	public User findByUserName(String user);
}
