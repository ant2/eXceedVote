package com.github.exceedvote.process.admin;

import java.util.List;

import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

/**
 * 
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class EventManagerProcess {
	private DaoFactory df;
	private ProjectDao projectDao;
	private CriterionDao criterionDao;
	private List<Project> projects;
	private List<Criterion> criteria;
	private VoteEvent event;

	public EventManagerProcess(DaoFactory df, VoteEvent event) {
		this.df = df;
		this.event = event;
		projectDao = df.getProjectDao();
		criterionDao = df.getCriterionDao();
		System.out.println("managing event: " + event.toString());
	}

	public List<Project> getAllProject() {
		if (projects == null) {
			projects = projectDao.findAllByEvent(event);
		}
		return projects;
	}

	public List<Criterion> getAllCriterion() {
		if (criteria == null) {
			criteria = criterionDao.findAllByEvent(event);
		}
		return criteria;
	}
}
