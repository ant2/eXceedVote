package com.github.ant2.exceedvote.dao.factory;

import com.github.ant2.exceedvote.dao.BallotDao;
import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.VoterDao;

public class EbeanDaoFactory implements DaoFactory {

	private final class EbeanProjectDao implements ProjectDao {
	}

	private final class EbeanCriterionDao implements CriterionDao {
	}

	private final class EbeanBallotDao implements BallotDao {
	}

	private final class EbeanVoterDao implements VoterDao {
	}

	private final ProjectDao projectDao = new EbeanProjectDao();
	private final CriterionDao criterionDao = new EbeanCriterionDao();
	private final BallotDao ballotDao = new EbeanBallotDao();
	private final VoterDao voterDao = new EbeanVoterDao();

	@Override
	public ProjectDao getProjectDao() {
		return projectDao;
	}

	@Override
	public CriterionDao getCriterionDao() {
		return criterionDao;
	}

	@Override
	public BallotDao getBallotDao() {
		return ballotDao;
	}

	@Override
	public VoterDao getVoterDao() {
		return voterDao;
	}

}
