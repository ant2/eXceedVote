package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

public interface CriterionDao {

	void save(Criterion criterion);

	List<Criterion> findAllByEvent(VoteEvent event);

}
