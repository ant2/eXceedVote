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
	 * Saves the commissioner into persistent unit
	 * 
	 * @param c
	 *            the commissioner
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
