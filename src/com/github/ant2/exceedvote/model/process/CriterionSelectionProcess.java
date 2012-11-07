package com.github.ant2.exceedvote.model.process;

import java.util.List;

import com.github.ant2.exceedvote.model.Criterion;
import com.github.ant2.exceedvote.model.VoteEvent;

public class CriterionSelectionProcess {

	private VoteEvent event;

	public CriterionSelectionProcess(VoteEvent event) {
		this.event = event;
	}

	public List<Criterion> getAllCriteria() {
		return event.getCriteria();
	}

}
