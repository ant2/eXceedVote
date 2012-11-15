package com.github.ant2.exceedvote.model.process;

import java.util.Map;

import com.github.ant2.exceedvote.dao.BallotDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.Voter;

public class BallotSubmitter {

	private Criterion criterion;
	private Context context;

	public BallotSubmitter(Context context, Criterion criterion) {
		this.context = context;
		this.criterion = criterion;
	}

	public void submit(Map<Project, Integer> map) {
		
		DaoFactory df = context.getDaoFactory();
		ProjectDao projectDao = df.getProjectDao();
		BallotDao ballotDao = df.getBallotDao();
		
		Voter voter = context.getVoter();
		
		// retrieve original ballot so we can figure out what to do with them...
		Map<Project, Ballot> originalBallots = new BallotRetriever(context, criterion).retrieve();
		
		// loop through each project and figure out the operations...
		for (Project project : projectDao.findAllByEvent(context.getEvent())) {
			
			Ballot ballot = originalBallots.get(project);
			Integer newVotesInteger = map.get(project);
			
			int newVotes = 0;
			if (newVotesInteger != null) {
				newVotes = newVotesInteger;
			}
			
			if (ballot == null && newVotes == 0) {
				// no vote -> no vote : do nothing
			} else if (ballot == null && newVotes > 0) {
				// no vote -> some vote : create new ballot
				ballot = new Ballot(project, criterion, voter, newVotes);
				ballotDao.save(ballot);
			} else if (ballot != null && newVotes > 0) {
				// some vote -> some other number of vote : update ballot
				ballot.setVotes(newVotes);
				ballotDao.save(ballot);
			} else if (ballot != null && newVotes == 0) {
				// some vote -> no vote : remove ballot
				ballotDao.remove(ballot);
			}
			
		}
	}

}
