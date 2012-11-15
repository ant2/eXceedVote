package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * The VoterDao class is responsible for retrieve and save voter to the
 * persistent unit.
 * 
 * @author Thai Pangsakulyanont (dtinth)
 */
public interface VoterDao {

	/**
	 * Retrieve all the voter that belonging to specific event.
	 * 
	 * @param event
	 *            the event need to find
	 * @return list of all voter that belonging to this event
	 */
	List<Voter> findAllByEvent(VoteEvent event);

	/**
	 * Save the voter to the persistent unit.
	 * 
	 * @param voter
	 *            the voter needs to be saved
	 */
	void save(Voter voter);

	/**
	 * Find voter in the persistent unit by specific id.
	 * 
	 * @param id
	 *            id of voter
	 * @return voter that have specific id
	 */
	Voter find(int id);

	/**
	 * Return list of all voter in persistent unit.
	 * 
	 * @return list of all voter
	 */
	List<Voter> findAll();

}
