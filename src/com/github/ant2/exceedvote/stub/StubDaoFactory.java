package com.github.ant2.exceedvote.stub;

import com.github.ant2.exceedvote.dao.CommissionerDao;
import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.EventDao;
import com.github.ant2.exceedvote.dao.ProjectDao;
import com.github.ant2.exceedvote.dao.UserDao;
import com.github.ant2.exceedvote.dao.VoterDao;
import com.github.ant2.exceedvote.dao.memory.MemoryDaoFactory;
import com.github.ant2.exceedvote.model.domain.Commissioner;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.User;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.util.CalendarUtil;

/**
 * A StubDaoFactory is a MemoryDaoFactory with some pre-filled data.
 * 
 * @author dtinth
 */
public class StubDaoFactory extends MemoryDaoFactory {

	/**
	 * The created event.
	 */
	public final VoteEvent EVENT = new VoteEvent();

	{
		EVENT.setName("eXceed Camp 2013");
		EVENT.setStartTime(CalendarUtil.createCalendar(0));
		EVENT.setFinishTime(CalendarUtil.createCalendar(300));
		EVENT.setAnnouncementTime(CalendarUtil.createCalendar(400));
	}

	/** Stub voter #1 */
	public final Voter V1 = EVENT.createVoter("Demo Voter", "001");

	/** Stub voter #2 */
	public final Voter V2 = EVENT.createVoter("Voter 2", "002");

	/** Stub commissioner */
	public final Commissioner COM1 = EVENT.createCommissioner("Commissioner 1");

	/** Stub criterion #1 */
	public final Criterion C1 = EVENT.createCriterion("Usability Award");

	/** Stub criterion #2 */
	public final Criterion C2 = EVENT.createCriterion("Usefulness Award");

	/** Stub criterion #3 */
	public final Criterion C3 = EVENT.createCriterion("Creativity Award");

	/** Stub project #1 */
	public final Project P1 = EVENT.createProject("eXceed Olympics");

	/** Stub project #2 */
	public final Project P2 = EVENT.createProject("Panda Conspiracy");

	/** Stub project #3 */
	public final Project P3 = EVENT.createProject("Integer Overfloweth");

	/** Stub project #4 */
	public final Project P4 = EVENT.createProject("Auto Drama Creator");

	/** Stub user #1 for voter #1 */
	public final User U1 = new User("demouser", "pass");
	
	/** Stub user #2 for voter #2 */
	public final User U2 = new User("voter2", "pass");
	
	/** Stub user #3 for commissioner */
	public final User U3 = new User("com1", "pass");

	/**
	 * Constructs a new StubDaoFactory.
	 */
	public StubDaoFactory() {
		V1.setUser(U1);
		V2.setUser(U2);
		COM1.setUser(U3);

		EventDao eventDao = getEventDao();
		VoterDao voterDao = getVoterDao();
		CriterionDao criterionDao = getCriterionDao();
		ProjectDao projectDao = getProjectDao();
		UserDao userDao = getUserDao();
		CommissionerDao commissionerDao = getCommissionerDao();

		eventDao.save(EVENT);
		voterDao.save(V1);
		voterDao.save(V2);
		criterionDao.save(C1);
		criterionDao.save(C2);
		criterionDao.save(C3);
		projectDao.save(P1);
		projectDao.save(P2);
		projectDao.save(P3);
		projectDao.save(P4);
		userDao.save(U1);
		userDao.save(U2);
		userDao.save(U3);
		commissionerDao.save(COM1);
	}
	
}
