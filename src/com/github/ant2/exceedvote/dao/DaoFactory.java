package com.github.ant2.exceedvote.dao;

public interface DaoFactory {

	EventDao getEventDao();

	VoterDao getVoterDao();

	CriterionDao getCriterionDao();

	ProjectDao getProjectDao();

	BallotDao getBallotDao();

}
