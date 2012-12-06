package com.github.ant2.exceedvote.stub;

import com.github.ant2.exceedvote.dao.memory.MemoryDaoFactory;
import com.github.ant2.exceedvote.model.domain.Commissioner;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.User;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.util.CalendarUtil;

public class StubDaoFactory extends MemoryDaoFactory {

	public final VoteEvent EVENT = new VoteEvent();

	{
		EVENT.setName("Test Event");
		EVENT.setStartTime(CalendarUtil.createCalendar(0));
		EVENT.setFinishTime(CalendarUtil.createCalendar(300));
		EVENT.setAnnouncementTime(CalendarUtil.createCalendar(400));
	}

	public final Voter V1 = EVENT.createVoter("Voter 1", "001");
	public final Voter V2 = EVENT.createVoter("Voter 2", "002");
	public final Commissioner COM1 = EVENT.createCommissioner("Commissioner 1");

	public final Criterion C1 = EVENT.createCriterion("Criterion 1");
	public final Criterion C2 = EVENT.createCriterion("Criterion 2");
	public final Criterion C3 = EVENT.createCriterion("Criterion 3");

	public final Project P1 = EVENT.createProject("Project 1");
	public final Project P2 = EVENT.createProject("Project 2");
	public final Project P3 = EVENT.createProject("Project 3");
	public final Project P4 = EVENT.createProject("Project 4");

	public final User U1 = new User("voter1", "pass");
	public final User U2 = new User("voter2", "pass");
	public final User U3 = new User("com1", "pass");

	public StubDaoFactory() {
		V1.setUser(U1);
		V2.setUser(U2);
		COM1.setUser(U3);

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
		commissionDao.save(COM1);
	}
}
