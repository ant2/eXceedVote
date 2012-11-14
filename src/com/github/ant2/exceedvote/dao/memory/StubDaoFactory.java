package com.github.ant2.exceedvote.dao.memory;

import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.exceedvote.model.process.Context;
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

	public final Criterion C1 = EVENT.createCriterion("Criterion 1");
	public final Criterion C2 = EVENT.createCriterion("Criterion 2");
	public final Criterion C3 = EVENT.createCriterion("Criterion 3");

	public final Project P1 = EVENT.createProject("Project 1");
	public final Project P2 = EVENT.createProject("Project 1");
	public final Project P3 = EVENT.createProject("Project 1");
	public final Project P4 = EVENT.createProject("Project 1");

	public final Context CONTEXT = new Context(this, EVENT, V2);

	public StubDaoFactory() {
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
	}

}
