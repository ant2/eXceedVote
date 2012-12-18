package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * The BallotDao class is responsible for retrieving and saving ballot objects
 * to persistent unit.
 * 
 * @author Thai Pangsakulyanont (dtinth)
 */
public interface BallotDao {

	/**
	 * Retrieves all ballots that the voter already voted for all project in
	 * specific criterion.
	 * 
	 * @param voter
	 *            the owner of the ballots
	 * @param criterion
	 *            criterion that need to retrieve the ballots
	 * @return list of all ballots of this voter that voted for all project in
	 *         this criterion
	 */
	List<Ballot> findAllByVoterAndCriterion(Voter voter, Criterion criterion);

	/**
	 * Saves the ballot to persistent unit.
	 * 
	 * @param ballot
	 *            the ballot needs to be saved
	 */
	void save(Ballot ballot);

	/**
	 * Removes the ballot from persistent unit.
	 * 
	 * @param ballot
	 *            the ballot needs to be removed
	 */
	void remove(Ballot ballot);

	/**
	 * Finds all ballots inside an event.
	 * 
	 * @param event
	 *            the event to search
	 * @return list of ballots, by event
	 */
	List<Ballot> findAllByEvent(VoteEvent event);

}
