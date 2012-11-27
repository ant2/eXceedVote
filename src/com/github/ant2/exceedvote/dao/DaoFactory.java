package com.github.ant2.exceedvote.dao;

/**
 * Factory class for get all other Dao class.
 * 
 * @author Thai Pangsakulyanont (dtinth)
 */
public interface DaoFactory {

	/**
	 * Return the EventDao object.
	 * 
	 * @return EventDao object
	 */
	EventDao getEventDao();

	/**
	 * Return the VoterDao object.
	 * 
	 * @return VoterDao object
	 */
	VoterDao getVoterDao();

	/**
	 * Return the CriterionDao object.
	 * 
	 * @return CriterionDao object
	 */
	CriterionDao getCriterionDao();

	/**
	 * Return the ProjectDao object.
	 * 
	 * @return ProjectDao object
	 */
	ProjectDao getProjectDao();

	/**
	 * Return the BallotDao object.
	 * 
	 * @return BallotDao object
	 */
	BallotDao getBallotDao();

	/**
	 * Return the UserDao object
	 * 
	 * @return BallotDao object
	 */
	UserDao getUserDao();

}
