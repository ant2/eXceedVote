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
	 * Remove the user from persistent unit.
	 * 
	 * @param user
	 *            the user needs to be removed
	 */
	public void save(User user);

	/**
	 * Return a user by the name
	 * 
	 * @param user
	 *            a name to search
	 * @return user of this name
	 */
	public User findByUserName(String user);
}
