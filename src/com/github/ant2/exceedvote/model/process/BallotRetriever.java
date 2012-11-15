package com.github.ant2.exceedvote.model.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.github.ant2.exceedvote.dao.BallotDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.Voter;

public class BallotRetriever {

	private Context context;
	private Criterion criterion;

	public BallotRetriever(Context context, Criterion criterion) {
		this.context = context;
		this.criterion = criterion;
	}

	public Map<Project, Ballot> retrieve() {
		Voter voter = context.getVoter();
		HashMap<Project, Ballot> map = new HashMap<Project, Ballot>();
		BallotDao ballotDao = context.getDaoFactory().getBallotDao();
		List<Ballot> ballots = ballotDao.findAllByVoterAndCriterion(voter,
				criterion);
		for (Ballot ballot : ballots) {
			map.put(ballot.getProject(), ballot);
		}
		return map;
	}

	public Map<Project, Integer> count() {
		HashMap<Project,Integer> map = new HashMap<Project, Integer>();
		for (Entry<Project, Ballot> entry : retrieve().entrySet()) {
			map.put(entry.getKey(), entry.getValue().getVotes());
		}
		return map;
	}

}
