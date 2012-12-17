package com.github.ant2.exceedvote.controller.admin;

import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.process.admin.BallotCount;
import com.github.ant2.exceedvote.model.process.admin.BallotCounterResult;
import com.github.ant2.exceedvote.model.process.admin.ViewResultProcess;
import com.github.ant2.exceedvote.view.admin.ViewResultWindow;

public class ViewResultController {

	private ViewResultProcess process;
	private ViewResultWindow view;

	public ViewResultController(ViewResultProcess process, ViewResultWindow view) {
		this.process = process;
		this.view = view;
		render();
	}

	private void render() {
		StringBuilder html = new StringBuilder();

		html.append("<html><h1>Exceed Vote Result</h1>")
				.append("<p>For Event: " + process.getEvent().getName()
						+ "</p>")
				.append("<p>Calculated At: "
						+ String.format("%tT", process.getCalendar()))
				.append("<hr/>");

		BallotCounterResult result = process.getResult();

		for (Criterion c : process.getCriteria()) {
			BallotCount count = result.forCriterion(c);
			html.append("<h2>" + c + "</h2>");
			html.append("<table>");
			for (Project p : process.getProjects()) {
				html.append("<tr>").append("<td>" + p + "</td>")
						.append("<td>" + count.get(p) + "</td>");
			}
			html.append("</table>");
			html.append("<hr/>");
		}

		view.setText(html.toString());
	}

	public void run() {
		view.setVisible(true);
	}

}
