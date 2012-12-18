package com.github.ant2.exceedvote.dao;

/**
 * Factory class for get all other Dao class.
 * 
 * @author Thai Pangsakulyanont (dtinth)
 */
public interface DaoFactory {

	/**
	 * Returns the EventDao object.
	 * 
	 * @return EventDao object
	 */
	EventDao getEventDao();

	/**
	 * Returns the VoterDao object.
	 * 
	 * @return VoterDao object
	 */
	VoterDao getVoterDao();

	/**
	 * Returns the CriterionDao object.
	 * 
	 * @return CriterionDao object
	 */
	CriterionDao getCriterionDao();

	/**
	 * Returns the ProjectDao object.
	 * 
	 * @return ProjectDao object
	 */
	ProjectDao getProjectDao();

	/**
	 * Returns the BallotDao object.
	 * 
	 * @return BallotDao object
	 */
	BallotDao getBallotDao();

	/**
	 * Return the UserDao object.
	 * 
	 * @return BallotDao object
	 */
	UserDao getUserDao();

	/**
	 * Return the CommissionerDao object.
	 * 
	 * @return CommissoionerDao object
	 */
	CommissionerDao getCommissionerDao();

}
