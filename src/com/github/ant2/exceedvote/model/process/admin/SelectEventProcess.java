package com.github.ant2.exceedvote.model.process.admin;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.EventDao;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

/**
 * 
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class SelectEventProcess {
	private static Logger logger = LogManager
			.getLogger(SelectEventProcess.class);
	private DaoFactory df;
	private EventDao eventDao;
	private List<VoteEvent> events;

	public SelectEventProcess(DaoFactory daoFactory) {
		df = daoFactory;
		eventDao = df.getEventDao();
	}

	public List<VoteEvent> getAllEvent() {
		if (events == null) {
			events = eventDao.findAll();
		}
		return events;
	}

	public EventManagerProcess manageEvent(VoteEvent event) {
		return new EventManagerProcess(df, event);
	}
}
