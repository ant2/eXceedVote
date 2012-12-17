package com.github.exceedvote.process.admin;

import java.util.List;

import com.github.ant2.exceedvote.controller.admin.EventManagerController;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.EventDao;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.view.admin.ManageEventWindow;

/**
 * 
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class SelectEventProcess {
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

	public void createEventManagerWindow(VoteEvent event) {
		EventManagerProcess process = new EventManagerProcess(df, event);
		ManageEventWindow window = new ManageEventWindow();
		EventManagerController controller = new EventManagerController(process,
				window);
		controller.run();
	}
}
