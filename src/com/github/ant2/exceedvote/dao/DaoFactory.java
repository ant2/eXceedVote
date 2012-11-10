package com.github.ant2.exceedvote.dao;

public interface DaoFactory {
	
	ProjectDao getProjectDao();
	
	CriterionDao getCriterionDao();
	
	BallotDao getBallotDao();
	
	VoterDao getVoterDao();
	
}
