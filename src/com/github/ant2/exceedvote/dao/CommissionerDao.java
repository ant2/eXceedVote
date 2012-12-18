package com.github.ant2.exceedvote.dao;

import com.github.ant2.exceedvote.model.domain.Commissioner;
import com.github.ant2.exceedvote.model.domain.User;

/**
 * 
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public interface CommissionerDao {

	/**
	 * Save a commissioner to persistent unit.
	 * 
	 * @param c
	 *            the commissioner needs to be saved
	 */
	void save(Commissioner c);

	/**
	 * Find a commissioner by user.
	 * 
	 * @param u
	 * 			the user to search
	 * @return commissioner of u
	 */
	Commissioner findByUser(User u);

}
