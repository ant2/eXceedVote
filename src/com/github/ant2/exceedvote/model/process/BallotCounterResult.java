package com.github.ant2.exceedvote.model.process;

import java.util.Calendar;

import com.github.ant2.exceedvote.model.domain.Criterion;

public interface BallotCounterResult {

	BallotCount forCriterion(Criterion c);

	Calendar getCalendar();

}
