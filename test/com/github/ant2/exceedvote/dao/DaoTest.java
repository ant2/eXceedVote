package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Ballot;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.User;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.util.CalendarUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DaoTest {

	public void testDaoFactory(DaoFactory factory) {
		EventDao eventDao = factory.getEventDao();
		VoteEvent event = testEventDao(eventDao);

		VoterDao voterDao = factory.getVoterDao();
		populateVoterDao(event, voterDao);
		populateVoterDao(event, voterDao);
		populateVoterDao(event, voterDao);
		assertEquals(3, voterDao.findAllByEvent(event).size());

		CriterionDao criterionDao = factory.getCriterionDao();
		testCriterionDao(event, criterionDao);

		ProjectDao projectDao = factory.getProjectDao();
		testProjectDao(event, projectDao);

		BallotDao ballotDao = factory.getBallotDao();
		{
			List<Voter> voters = voterDao.findAllByEvent(event);
			List<Criterion> criteria = criterionDao.findAllByEvent(event);
			List<Project> projects = projectDao.findAllByEvent(event);
			for (Voter voter : voters) {
				for (Criterion criterion : criteria) {

					// add ballots
					for (Project project : projects) {
						populateBallotDao(event, project, criterion, voter,
								ballotDao);
					}

					// count the number of projects. there must be this number
					// of ballots.
					int expectedSize = projects.size();

					// check the number of ballots...
					List<Ballot> all = ballotDao.findAllByVoterAndCriterion(
							voter, criterion);
					assertEquals(expectedSize, all.size());

					// now remove all ballots
					for (Ballot ballot : all) {
						ballotDao.remove(ballot);

						// count of ballots must decrease
						expectedSize -= 1;
						assertEquals(expectedSize, ballotDao
								.findAllByVoterAndCriterion(voter, criterion)
								.size());
					}

					// finally, add all ballots back.
					for (Project project : projects) {
						populateBallotDao(event, project, criterion, voter,
								ballotDao);
					}

					expectedSize = projects.size();
					assertEquals(expectedSize, ballotDao
							.findAllByVoterAndCriterion(voter, criterion)
							.size());

				}
			}
		}

		UserDao userDao = factory.getUserDao();

		Voter v = new Voter();
		v.setName("Ki");
		v.setStudentId("1234");
		User u = new User("UsernameTestKi", "KiPassword");
		v.setUser(u);
		v.setVoteEvent(event);

		voterDao.save(v);
		userDao.save(u);

		assertEquals(v, voterDao.findByUser(u));
		assertEquals(u, userDao.findByUserName("UsernameTestKi"));

	}

	private void populateBallotDao(VoteEvent event, Project project,
			Criterion criterion, Voter voter, BallotDao ballotDao) {
		Ballot ballot = new Ballot(project, criterion, voter, 2);
		ballotDao.save(ballot);
	}

	private void testProjectDao(VoteEvent event, ProjectDao projectDao) {
		projectDao.save(event.createProject("Nyan Nyan Nyan"));
		projectDao.save(event.createProject("Panda Version Two"));
		List<Project> projects = projectDao.findAllByEvent(event);
		assertEquals(2, projects.size());
	}

	private void testCriterionDao(VoteEvent event, CriterionDao criterionDao) {
		criterionDao.save(event.createCriterion("Best Software"));
		criterionDao.save(event.createCriterion("Best OOP"));
		criterionDao.save(event.createCriterion("User Interface Award"));
		List<Criterion> criteria = criterionDao.findAllByEvent(event);
		assertEquals(3, criteria.size());
	}

	private Voter populateVoterDao(VoteEvent event, VoterDao voterDao) {
		Voter voter = event.createVoter();
		voter.setName("Voter #" + System.currentTimeMillis());
		voter.setStudentId("00" + System.currentTimeMillis());
		voterDao.save(voter);
		return voter;
	}

	private VoteEvent testEventDao(EventDao eventDao) {

		List<VoteEvent> events = eventDao.findAll();

		VoteEvent event = new VoteEvent();
		event.setName("Test eXceed Vote");
		event.setStartTime(CalendarUtil.createCalendar(0));
		event.setFinishTime(CalendarUtil.createCalendar(300));
		event.setAnnouncementTime(CalendarUtil.createCalendar(400));

		eventDao.save(event);

		events = eventDao.findAll();
		assertFalse(events.isEmpty());

		return event;

	}

}
