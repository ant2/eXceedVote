package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Voter;

public interface BallotDao {

	List<Ballot> findAllByVoterAndCriterion(Voter voter, Criterion criterion);

	void save(Ballot ballot);

}
