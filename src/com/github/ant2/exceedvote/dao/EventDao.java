package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.VoteEvent;

/**
 * The EventDao class is responsible for
 * 
 * @author Thai Pangsakulyanont (dtinth)
 */
public interface EventDao {
	/**
	 * Return all event in the persistent unit.
	 * 
	 * @return list of all event in the persistent unit
	 */
	List<VoteEvent> findAll();

	/**
	 * Save new event to the persistent unit.
	 * 
	 * @param newEvent
	 *            new event need to be saved
	 */
	void save(VoteEvent newEvent);

}
