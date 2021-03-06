package com.github.ant2.exceedvote.dao.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.dao.BallotDao;
import com.github.ant2.exceedvote.dao.CommissionerDao;
import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.EventDao;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.UserDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Commissioner;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Model;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.User;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

/**
 * A DAO that keeps everything inside memory. It is implemented using a Hash
 * Map, so everything disappears after closing app. Used for testing.
 * 
 * @author dttvb
 */
public class MemoryDaoFactory implements DaoFactory {

	private static Logger logger = LogManager.getLogger(MemoryDaoFactory.class);

	private EventDao eventDao;
	private VoterDao voterDao;
	private CriterionDao criterionDao;
	private ProjectDao projectDao;
	private BallotDao ballotDao;
	private UserDao userDao;
	private CommissionerDao commissionDao;

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
			logger.debug(
					"Saved object {} to memory... Database now contains {} nodes.",
					t, map.size());
		}

		public List<T> findAll() {
			return new ArrayList<T>(map.values());
		}

		public T find(int id) {
			return map.get(id);
		}

		public void remove(T t) {
			map.remove(t.getId());
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
		@Override
		public Voter findByUser(User u) {
			for (Voter v : findAll()) {
				if (v.getUser() == u) return v;
			}
			return null;
		}
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

		@Override
		public List<Ballot> findAllByEvent(VoteEvent event) {
			List<Ballot> list = new ArrayList<Ballot>();
			for (Ballot ballot : findAll()) {
				if (ballot.getCriterion().getVoteEvent() == event) {
					list.add(ballot);
				}
			}
			return list;
		}
	}

	private class MemoryUserDao extends MemoryDao<User> implements UserDao {
		@Override
		public User findByUserName(String user) {
			for (User u : findAll()) {
				if (u.getUsername().equals(user)) return u;
			}
			return null;
		}

	}

	private class MemoryCommissionerDao extends MemoryDao<Commissioner>
			implements CommissionerDao {
		@Override
		public Commissioner findByUser(User user) {
			for (Commissioner c : findAll()) {
				if (c.getUser() == user) return c;
			}
			return null;
		}
	}

	/**
	 * Constructs a new MemoryDaoFactory.
	 */
	public MemoryDaoFactory() {
		eventDao = new MemoryEventDao();
		voterDao = new MemoryVoterDao();
		criterionDao = new MemoryCriterionDao();
		projectDao = new MemoryProjectDao();
		ballotDao = new MemoryBallotDao();
		userDao = new MemoryUserDao();
		commissionDao = new MemoryCommissionerDao();
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

	@Override
	public UserDao getUserDao() {
		return userDao;
	}

	@Override
	public CommissionerDao getCommissionerDao() {
		return commissionDao;
	}

}
