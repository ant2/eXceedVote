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
import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

public class JPADaoFactory implements DaoFactory {

	protected EventDao eventDao;
	protected VoterDao voterDao;
	protected CriterionDao criterionDao;
	protected ProjectDao projectDao;
	protected BallotDao ballotDao;
	
	protected EntityManager em = Persistence.createEntityManagerFactory("eXceedVote").createEntityManager();

	private class JPADao<T> {

		protected Class<T> beanType;
		protected String className;

		public JPADao(Class<T> beanType, String className) {
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
			JPADao<T> {
		public VoteEventPartDao(Class<T> beanType, String className) {
			super(beanType, className);
		}

		public List<T> findAllByEvent(VoteEvent event) {
			return em.createQuery("SELECT x FROM " + className + " x WHERE x.voteEvent = :event")
					.setParameter("event", event)
					.getResultList();
		}
	}

	private class JPAEventDao extends JPADao<VoteEvent> implements EventDao {
		public JPAEventDao() {
			super(VoteEvent.class, "VoteEvent");
		}
	}

	private class JPAVoterDao extends VoteEventPartDao<Voter> implements
			VoterDao {
		public JPAVoterDao() {
			super(Voter.class, "Voter");
		}
	}

	private class JPACriterionDao extends VoteEventPartDao<Criterion>
			implements CriterionDao {
		public JPACriterionDao() {
			super(Criterion.class, "Criterion");
		}
	}

	private class JPAProjectDao extends VoteEventPartDao<Project> implements
			ProjectDao {
		public JPAProjectDao() {
			super(Project.class, "Project");
		}
	}

	private class JPABallotDao extends JPADao<Ballot> implements BallotDao {

		public JPABallotDao() {
			super(Ballot.class, "Ballot");
		}

		@Override
		public List<Ballot> findAllByVoterAndCriterion(Voter voter,
				Criterion criterion) {
			return em.createQuery("SELECT x FROM " + className + " x WHERE x.voter = :voter AND x.criterion = :criterion")
					.setParameter("voter", voter)
					.setParameter("criterion", criterion)
					.getResultList();
		}

	}

	public JPADaoFactory() {
		eventDao = new JPAEventDao();
		voterDao = new JPAVoterDao();
		criterionDao = new JPACriterionDao();
		projectDao = new JPAProjectDao();
		ballotDao = new JPABallotDao();
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
