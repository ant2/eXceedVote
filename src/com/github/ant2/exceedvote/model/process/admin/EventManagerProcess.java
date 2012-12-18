package com.github.ant2.exceedvote.model.process.admin;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.exceedvote.util.ChangeObservable;
import com.github.ant2.exceedvote.util.ChangeObserver;

/**
 * The process for managing event.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class EventManagerProcess extends ChangeObservable implements
		ChangeObserver {
	private static Logger logger = LogManager
			.getLogger(EventManagerProcess.class);

	private DaoFactory df;
	private ProjectDao projectDao;
	private CriterionDao criterionDao;
	private VoterDao voterDao;
	private List<Project> projects;
	private List<Criterion> criteria;
	private List<Voter> voters;
	private VoteEvent event;

	/**
	 * Constructs the new EventManagerProcess.
	 * 
	 * @param df
	 *            the DAO factory for get all DAO
	 * @param event
	 *            the editing event
	 */
	public EventManagerProcess(DaoFactory df, VoteEvent event) {
		this.df = df;
		this.event = event;
		projectDao = df.getProjectDao();
		criterionDao = df.getCriterionDao();
		voterDao = df.getVoterDao();
		logger.debug("Manageing Event: " + event.toString());
	}

	/**
	 * Returns the list of all voters.
	 * 
	 * @return list of all voters
	 */
	public List<Project> getAllProjects() {
		if (projects == null) {
			projects = projectDao.findAllByEvent(event);
		}
		return projects;
	}

	/**
	 * Returns the list of all available criteria.
	 * 
	 * @return list of all available criteria
	 */
	public List<Criterion> getAllCriteria() {
		if (criteria == null) {
			criteria = criterionDao.findAllByEvent(event);
		}
		return criteria;
	}

	/**
	 * Returns the vote event.
	 * 
	 * @return current vote event
	 */
	public VoteEvent getEvent() {
		return event;
	}

	/**
	 * Create the EditCriterionProcess for selected criterion.
	 * 
	 * @param criterion
	 *            the editing criterion
	 * @return the EditCriterionProcess object
	 */
	public EditCriterionProcess editCriterion(Criterion criterion) {
		EditCriterionProcess process = new EditCriterionProcess(df, criterion);
		process.addObserver(this);
		return process;
	}

	/**
	 * Create the EditProjectProcess for selected project.
	 * 
	 * @param project
	 *            the editing project
	 * @return the EditProjectProcess object
	 */
	public EditProjectProcess editProject(Project project) {
		EditProjectProcess process = new EditProjectProcess(df, project);
		process.addObserver(this);
		return process;
	}

	@Override
	public void changed() {
		// clear cached data
		projects = null;
		criteria = null;

		// notify others
		notifyObservers();
	}

	/**
	 * Create the new ViewResultProcess.
	 * 
	 * @return the ViewResultProcess object
	 */
	public ViewResultProcess viewResult() {
		return new ViewResultProcess(df, event);
	}

	/**
	 * Returns list of all voters.
	 * 
	 * @return list of all voters
	 */
	public List<Voter> getAllVoter() {
		if (voters == null) voters = voterDao.findAllByEvent(event);
		return voters;
	}

	/**
	 * Create the new ManageVoterProcess.
	 * 
	 * @return the ManageVoterProcess object
	 */
	public ManageVoterProcess manageVoters() {
		return new ManageVoterProcess(df, event);
	}
}
