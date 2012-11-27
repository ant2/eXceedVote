package com.github.ant2.exceedvote.dao;

import com.github.ant2.exceedvote.model.domain.User;

/**
 * 
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public interface UserDao {
	//TODO javadoc
	public void save(User user) ;

	public User findByUserName(String user);
}
