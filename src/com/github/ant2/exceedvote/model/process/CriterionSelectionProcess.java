package com.github.ant2.exceedvote.model.process;

import java.util.List;

import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

public class CriterionSelectionProcess {

	private VoteEvent event;
	private Context context;
	
	private DaoFactory df;

	public CriterionSelectionProcess(Context context) {
		this.context = context;
		event = context.getEvent();
		df = context.getDaoFactory();
	}

	public List<Criterion> getAllCriteria() {
		return df.getCriterionDao().findAllByEvent(event);
	}
	

	public VotingProcess createVotingProcess(Criterion criterion) {
		return new VotingProcess(context, criterion);
	}

}
