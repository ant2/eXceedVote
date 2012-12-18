package com.github.ant2.exceedvote.controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.process.admin.EventManagerProcess;
import com.github.ant2.exceedvote.model.process.admin.SelectEventProcess;
import com.github.ant2.exceedvote.view.admin.ManageEventWindow;
import com.github.ant2.exceedvote.view.admin.SelectEventWindow;

/**
 * 
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class SelectEventController {
	private SelectEventProcess process;
	private SelectEventWindow view;
	private List<VoteEvent> events;
	private Runnable logoutAction;
	
	private static Logger logger = LogManager
			.getLogger(SelectEventController.class);

	public SelectEventController(SelectEventProcess process,
			SelectEventWindow view) {
		this.process = process;
		this.view = view;
		events = process.getAllEvent();
		addListener();
	}

	private void addListener() {
		view.getOkButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				EventManagerProcess subprocess = process.manageEvent(events
						.get(view.getSelectedEvent()));
				ManageEventWindow window = new ManageEventWindow();
				EventManagerController controller = new EventManagerController(
						subprocess, window);
				controller.setOnLogoutAction(logoutAction);
				controller.run();
			}
		});

		view.getNewEventButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.error("Not implemented");
			}
		});
	}

	public void run() {
		view.getEventList().setModel(new EventListModel());
		view.setVisible(true);
		view.pack();
	}

	public class EventListModel extends AbstractListModel implements ListModel {
		/** */
		private static final long serialVersionUID = 1L;

		@Override
		public String getElementAt(int row) {
			return events.get(row).toString();
		}

		@Override
		public int getSize() {
			return events.size();
		}
	}

	public void setOnLogoutAction(Runnable logoutAction) {
		this.logoutAction = logoutAction;
	}
}
