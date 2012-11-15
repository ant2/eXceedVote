package com.github.ant2.exceedvote.dao.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.dao.BallotDao;
import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.EventDao;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Model;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.sun.tools.jdi.LinkedHashMap;

public class MemoryDaoFactory implements DaoFactory {
	
	private static Logger logger = LogManager.getLogger(MemoryDaoFactory.class);
	
	protected EventDao eventDao;
	protected VoterDao voterDao;
	protected CriterionDao criterionDao;
	protected ProjectDao projectDao;
	protected BallotDao ballotDao;

	private int nextId = 1;
	
	private class MemoryDao<T extends Model> {

		protected Map<Integer, T> map = new HashMap<Integer, T>();

		public void save(T t) {
			if (t.getId() == null) {
				int id = nextId++;
				logger.debug("Assigning ID = {} to object {}", id, t);
				t.setId(id);
			}
			map.put(t.getId(), t);
			logger.debug("Saved object {} to memory... Database now contains {} nodes.", t, map.size());
		}

		public List<T> findAll() {
			return new ArrayList<T>(map.values());
		}

		public T find(int id) {
			return map.get(id);
		}
		
	}

	private class VoteEventPartDao<T extends Model & VoteEvent.Part> extends
			MemoryDao<T> {
		public List<T> findAllByEvent(VoteEvent event) {
			List<T> list = new ArrayList<T>();
			for (T t : findAll()) {
				if (t.getVoteEvent().equals(event)) {
					list.add(t);
				}
			}
			return list;
		}
	}

	private class MemoryEventDao extends MemoryDao<VoteEvent> implements
			EventDao {
	}

	private class MemoryVoterDao extends VoteEventPartDao<Voter> implements
			VoterDao {
	}

	private class MemoryCriterionDao extends VoteEventPartDao<Criterion>
			implements CriterionDao {
	}

	private class MemoryProjectDao extends VoteEventPartDao<Project> implements
			ProjectDao {
	}

	private class MemoryBallotDao extends MemoryDao<Ballot> implements
			BallotDao {

		@Override
		public List<Ballot> findAllByVoterAndCriterion(Voter voter,
				Criterion criterion) {
			List<Ballot> list = new ArrayList<Ballot>();
			for (Ballot ballot : findAll()) {
				if (ballot.getVoter().equals(voter)
						&& ballot.getCriterion().equals(criterion)) {
					list.add(ballot);
				}
			}
			return list;
		}

	}

	public MemoryDaoFactory() {
		eventDao = new MemoryEventDao();
		voterDao = new MemoryVoterDao();
		criterionDao = new MemoryCriterionDao();
		projectDao = new MemoryProjectDao();
		ballotDao = new MemoryBallotDao();
	}

	@Override
	public EventDao getEventDao() {
		return eventDao;
	}

	@Override
	public VoterDao getVoterDao() {
		return voterDao;
	}

	@Override
	public CriterionDao getCriterionDao() {
		return criterionDao;
	}

	@Override
	public ProjectDao getProjectDao() {
		return projectDao;
	}

	@Override
	public BallotDao getBallotDao() {
		return ballotDao;
	}

}
