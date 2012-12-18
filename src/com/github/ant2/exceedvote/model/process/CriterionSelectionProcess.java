package com.github.ant2.exceedvote.model.process;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

/**
 * A criterion selection process
 * 
 * @author Thai Pangsakulyanont
 */
public class CriterionSelectionProcess {

	private Logger logger = LogManager
			.getLogger(CriterionSelectionProcess.class);

	private VoteEvent event;
	private Context context;

	private DaoFactory df;

	private List<Criterion> criteria;

	/**
	 * @param context
	 *            the context
	 */
	public CriterionSelectionProcess(Context context) {
		this.context = context;
		event = context.getEvent();
		df = context.getDaoFactory();
	}

	/**
	 * Gets all the criteria
	 * 
	 * @return the list of criteria
	 */
	public List<Criterion> getAllCriteria() {
		if (criteria == null) {
			logger.debug("Getting all criteria.");
			criteria = df.getCriterionDao().findAllByEvent(event);
		} else {
			logger.debug("Already got all criteria.");
		}
		return criteria;
	}

	/**
	 * Creates the VotingProcess
	 * 
	 * @param criterion
	 *            the criterion that is chosen
	 * @return the VotingProcess
	 */
	public VotingProcess createVotingProcess(Criterion criterion) {
		return new VotingProcess(context, criterion);
	}

}
