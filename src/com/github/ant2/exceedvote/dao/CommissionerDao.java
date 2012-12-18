package com.github.ant2.exceedvote.dao;

import com.github.ant2.exceedvote.model.domain.Commissioner;
import com.github.ant2.exceedvote.model.domain.User;

/**
 * The CommissionerDao class is responsible for saving a commissioner and find a
 * commissioner
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
	 * Finds the commissioner by user
	 * 
	 * @param u
	 *            the user
	 * @return the commissioner
	 */
	Commissioner findByUser(User u);

}
