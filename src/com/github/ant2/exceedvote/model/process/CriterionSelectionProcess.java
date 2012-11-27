package com.github.ant2.exceedvote.model.process;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

public class CriterionSelectionProcess {

	private Logger logger = LogManager
			.getLogger(CriterionSelectionProcess.class);

	private VoteEvent event;
	private Context context;

	private DaoFactory df;

	private List<Criterion> criteria;

	public CriterionSelectionProcess(Context context) {
		this.context = context;
		event = context.getEvent();
		df = context.getDaoFactory();
	}

	public List<Criterion> getAllCriteria() {
		if (criteria == null) {
			logger.debug("Getting all criteria.");
			criteria = df.getCriterionDao().findAllByEvent(event);
		} else {
			logger.debug("Already got all criteria.");
		}
		return criteria;
	}

	public VotingProcess createVotingProcess(Criterion criterion) {
		return new VotingProcess(context, criterion);
	}

}
