package com.github.ant2.exceedvote;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VoterSession {
	
	private Calendar startTime;
	private Calendar finishTime;
	private Calendar announcementTime;
	
	private BallotBox ballotBox;
	
	public VoterSession() {
		ballotBox = new BallotBox();
		
		// TODO put actual data here!
		startTime = Calendar.getInstance();
		finishTime = Calendar.getInstance();
		finishTime.add(Calendar.HOUR_OF_DAY, 1);
	}

	public BallotBox getBallotBox() {
		return ballotBox;
	}

	public int getRemainingTime() {
		return (int)((finishTime.getTimeInMillis() -
				Calendar.getInstance().getTimeInMillis()) / 1000);
	}

	public List<Project> getProjects() {
		List<Project> list = new ArrayList<Project>();
		return list;
	}

	public List<Criterion> getCriteria() {
		List<Criterion> list = new ArrayList<Criterion>();
		return list;
	}

}
