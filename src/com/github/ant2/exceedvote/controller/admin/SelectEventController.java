package com.github.ant2.exceedvote.controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.view.admin.SelectEventWindow;
import com.github.exceedvote.process.admin.SelectEventProcess;

/**
 * 
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class SelectEventController {
	private SelectEventProcess process;
	private SelectEventWindow view;
	private List<VoteEvent> events;

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
				process.createEventManagerWindow(events.get(view
						.getSelectedEvent()));
			}
		});

		view.getNewEventButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("new event button pressed");
			}
		});
	}

	public void run() {
		view.getEventList().setModel(new EventListModel());
		view.setVisible(true);
		view.pack();
	}

	public class EventListModel extends AbstractListModel<String> implements
			ListModel<String> {
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
}
