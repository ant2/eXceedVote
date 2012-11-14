package com.github.ant2.exceedvote.dao.ebean;

import java.util.List;

import com.avaje.ebean.Ebean;
import com.github.ant2.exceedvote.dao.BallotDao;
import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.EventDao;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

public class EbeanDaoFactory implements DaoFactory {

	protected EventDao eventDao;
	protected VoterDao voterDao;
	protected CriterionDao criterionDao;
	protected ProjectDao projectDao;
	protected BallotDao ballotDao;

	private class EbeanDao<T> {

		protected Class<T> beanType;

		public EbeanDao(Class<T> beanType) {
			this.beanType = beanType;
		}

		public void save(T t) {
			Ebean.save(t);
		}

		public List<T> findAll() {
			return Ebean.find(beanType).findList();
		}
		
		public T find(int id) {
			return Ebean.find(beanType, id);
		}

	}

	private class VoteEventPartDao<T extends VoteEvent.Part> extends
			EbeanDao<T> {
		public VoteEventPartDao(Class<T> beanType) {
			super(beanType);
		}

		public List<T> findAllByEvent(VoteEvent event) {
			return Ebean.find(beanType).where().eq("voteEvent", event)
					.findList();
		}
	}

	private class EbeanEventDao extends EbeanDao<VoteEvent> implements EventDao {
		public EbeanEventDao() {
			super(VoteEvent.class);
		}
	}

	private class EbeanVoterDao extends VoteEventPartDao<Voter> implements
			VoterDao {
		public EbeanVoterDao() {
			super(Voter.class);
		}
	}

	private class EbeanCriterionDao extends VoteEventPartDao<Criterion>
			implements CriterionDao {
		public EbeanCriterionDao() {
			super(Criterion.class);
		}
	}

	private class EbeanProjectDao extends VoteEventPartDao<Project> implements
			ProjectDao {
		public EbeanProjectDao() {
			super(Project.class);
		}
	}

	private class EbeanBallotDao extends EbeanDao<Ballot> implements BallotDao {

		public EbeanBallotDao() {
			super(Ballot.class);
		}

		@Override
		public List<Ballot> findAllByVoterAndCriterion(Voter voter,
				Criterion criterion) {
			return Ebean.find(Ballot.class).where().eq("voter", voter)
					.eq("criterion", criterion).findList();
		}

	}

	public EbeanDaoFactory() {
		eventDao = new EbeanEventDao();
		voterDao = new EbeanVoterDao();
		criterionDao = new EbeanCriterionDao();
		projectDao = new EbeanProjectDao();
		ballotDao = new EbeanBallotDao();
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
