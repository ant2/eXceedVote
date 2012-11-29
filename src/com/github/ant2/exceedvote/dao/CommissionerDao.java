package com.github.ant2.exceedvote.dao;

import com.github.ant2.exceedvote.model.domain.Commissioner;
import com.github.ant2.exceedvote.model.domain.User;

/**
 * 
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public interface CommissionerDao {

	void save(Commissioner c);

	Commissioner findByUser(User u);

}
