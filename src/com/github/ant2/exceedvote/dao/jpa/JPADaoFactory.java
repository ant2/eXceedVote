package com.github.ant2.exceedvote.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.github.ant2.exceedvote.dao.BallotDao;
import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.EventDao;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

public class JPADaoFactory implements DaoFactory {

	protected EventDao eventDao;
	protected VoterDao voterDao;
	protected CriterionDao criterionDao;
	protected ProjectDao projectDao;
	protected BallotDao ballotDao;
	
	protected EntityManager em = Persistence.createEntityManagerFactory("eXceedVote").createEntityManager();

	private class EbeanDao<T> {

		protected Class<T> beanType;
		protected String className;

		public EbeanDao(Class<T> beanType, String className) {
			this.beanType = beanType;
			this.className = className;
		}

		public void save(T t) {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		}

		public T find(int id) {
			return em.find(beanType, id);
		}
		
		public List<T> findAll() {
			return em.createQuery("SELECT x FROM " + className + " x").getResultList();
		}
		
		public void remove(T t) {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		}

	}

	private class VoteEventPartDao<T extends VoteEvent.Part> extends
			EbeanDao<T> {
		public VoteEventPartDao(Class<T> beanType, String className) {
			super(beanType, className);
		}

		public List<T> findAllByEvent(VoteEvent event) {
			return em.createQuery("SELECT x FROM " + className + " x WHERE x.event = :event")
					.setParameter("event", event)
					.getResultList();
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
