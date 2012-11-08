package com.github.ant2.exceedvote.model.process;

import java.util.List;

import com.github.ant2.exceedvote.model.Criterion;
import com.github.ant2.exceedvote.model.VoteEvent;

public class CriterionSelectionProcess {

	private VoteEvent event;
	private Context context;

	public CriterionSelectionProcess(Context context) {
		this.context = context;
		this.event = context.getEvent();
	}

	public List<Criterion> getAllCriteria() {
		return event.getCriteria();
	}

	public VotingProcess createVotingProcess(Criterion criterion) {
		return new VotingProcess(event, context.getVoter(), criterion);
	}

}
