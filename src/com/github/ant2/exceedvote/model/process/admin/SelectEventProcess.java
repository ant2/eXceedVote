package com.github.ant2.exceedvote.model.process.admin;

import java.util.List;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.EventDao;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

/**
 * The process for selecting event to be managed.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class SelectEventProcess {
	private DaoFactory df;
	private EventDao eventDao;
	private List<VoteEvent> events;

	/**
	 * Constructs the new SelectEventProess.
	 * 
	 * @param daoFactory
	 *            the DAO factory to get all other DAO
	 */
	public SelectEventProcess(DaoFactory daoFactory) {
		df = daoFactory;
		eventDao = df.getEventDao();
	}

	/**
	 * Returns list of all events.
	 * 
	 * @return list of all events.
	 */
	public List<VoteEvent> getAllEvent() {
		if (events == null) {
			events = eventDao.findAll();
		}
		return events;
	}

	/**
	 * Create the new EventManagerProcess.
	 * 
	 * @param event
	 *            the editing event
	 * @return the EventManagerProcess object
	 */
	public EventManagerProcess manageEvent(VoteEvent event) {
		return new EventManagerProcess(df, event);
	}
}
