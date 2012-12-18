package com.github.ant2.exceedvote.model.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * A voting process
 * 
 * @author Artima Mahahemarat
 */
public class VotingProcess {

	private Logger logger = LogManager.getLogger(VotingProcess.class);
	private VoteEvent event;
	private Voter voter;
	private Criterion criterion;
	private int usedBallots;
	private int[] a;
	private DaoFactory df;
	private List<Project> projects;
	private Context context;

	/**
	 * @param context
	 *            the context
	 * @param criterion
	 *            the criterion to vote.
	 */
	public VotingProcess(Context context, Criterion criterion) {

		this.context = context;
		event = context.getEvent();
		voter = context.getVoter();
		this.criterion = criterion;
		df = context.getDaoFactory();
		a = new int[getProjects().size()];

		Map<Project, Integer> map = new BallotRetriever(context, criterion)
				.count();
		for (int i = 0; i < a.length; i++) {
			Project project = getProjects().get(i);
			if (map.containsKey(project)) {
				a[i] = map.get(project);
				usedBallots += a[i];
			}
		}

	}

	/**
	 * Sets the DAOFactory
	 * 
	 * @param df
	 *            DaoFactory that is going to be set
	 */
	public void setDaoFactory(DaoFactory df) {
		logger.debug("Setting new DaoFactory.");
		this.df = df;
	}

	/**
	 * Gets all the projects in event
	 * 
	 * @return List of a project
	 */
	public List<Project> getProjects() {
		if (projects == null) {
			logger.debug("Getting all projects.");
			projects = df.getProjectDao().findAllByEvent(event);
		} else {
			logger.debug("Already got all projects.");
		}
		return projects;
	}

	/**
	 * Checks that ballots can increase or not
	 * 
	 * @return true if used ballots are less than allowed, false otherwise
	 */
	public boolean canIncrease() {
		logger.debug("Determine if used ballots are less than allowed.");
		return usedBallots < voter.getAllowedBallots();
	}

	/**
	 * Checks that ballots can decrease or not
	 * 
	 * @param project
	 *            the project that is chosen
	 * @return true if the project has been voted, false otherwise
	 */
	public boolean canDecrease(Project project) {
		logger.debug("Getting index of project.");
		int i = getProjects().indexOf(project);
		logger.debug("Determine if project has ever been voted.");
		return a[i] > 0;
	}

	/**
	 * Increases the ballot
	 * 
	 * @param project
	 *            the project that is chosen
	 */
	public void increase(Project project) {
		if (!canIncrease()) {
			logger.debug("Project cannot be increased!");
			return;
		}
		logger.debug("Project can be increased.");
		logger.debug("Getting index of project.");
		int i = getProjects().indexOf(project);
		logger.debug("Adding project count and used ballots.");
		a[i]++;
		usedBallots++;
	}

	/**
	 * Counts the ballots in the project
	 * 
	 * @param project
	 *            the project that is chosen
	 * @return the number of ballots
	 */
	public int getCount(Project project) {
		logger.debug("Getting index of project.");
		int i = getProjects().indexOf(project);
		logger.debug("Retrieving project count.");
		return a[i];
	}

	/**
	 * Decrease the ballot
	 * 
	 * @param project
	 *            the project that is chosen
	 */
	public void decrease(Project project) {
		if (!canDecrease(project)) {
			logger.debug("Project cannot be decreased!");
			return;
		}
		logger.debug("Project can be decreased.");
		logger.debug("Getting index of project.");
		int i = getProjects().indexOf(project);
		logger.debug("Reducing project count and used ballots.");
		a[i]--;
		usedBallots--;
	}

	/**
	 * Submits the ballots to the system
	 */
	public void submit() {
		Map<Project, Integer> map = new HashMap<Project, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				continue;
			}
			for (int j = 0; j < a[i]; j++) {
				Project project = getProjects().get(i);
				map.put(project, a[i]);
			}
		}
		new BallotSubmitter(context, criterion).submit(map);
	}

	/**
	 * Gets the criterion
	 * 
	 * @return the criterion
	 */
	public Criterion getCriterion() {
		logger.debug("Retrieving criterion.");
		return criterion;
	}

	/**
	 * Gets the number of used ballots
	 * 
	 * @return the number of used ballots
	 */
	public int getUsedBallots() {
		logger.debug("Retrieving used ballots.");
		return usedBallots;
	}

	/**
	 * Gets the number of allowed ballots
	 * 
	 * @return the number of allowed ballots
	 */
	public int getTotalBallots() {
		logger.debug("Retrieving allowed ballots.");
		return voter.getAllowedBallots();
	}

}
