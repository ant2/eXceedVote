package com.github.ant2.exceedvote.stub;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.exceedvote.model.process.Context;

/**
 * A Context backed by a StubDaoFactory.
 *
 * @author dtinth
 */
public class StubContext extends Context {

	private StubDaoFactory sdf;

	/** myself */
	public final Voter SELF;
	
	/** the other one */
	public final Voter OTHER;

	/**
	 * Constructs a new StubContext.
	 */
	public StubContext() {
		sdf = new StubDaoFactory();
		setVoter(sdf.V1);
		setEvent(sdf.EVENT);
		SELF = sdf.V1;
		OTHER = sdf.V2;
	}

	@Override
	public StubDaoFactory getDaoFactory() {
		return sdf;
	}

	@Override
	public void setDaoFactory(DaoFactory daoFactory) {
		throw new UnsupportedOperationException();
	}

}
