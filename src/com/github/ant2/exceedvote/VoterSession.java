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
		// XXX : this is just a test data
		List<Project> list = new ArrayList<Project>();
		list.add(new Project("Physics Works", "I am the best project!"));
		list.add(new Project("Nyan Cat Extreme", "Nyanyanyanyanyanayanyaynany!!"));
		list.add(new Project("TROLOL", "Our project sings the trolol song forever"));
		list.add(new Project("DERP", "DERPYDERPY"));
		list.add(new Project("Love Status", "Coding at maximum bug power"));
		return list;
	}

	public List<Criterion> getCriteria() {
		// XXX : this is just a test data
		List<Criterion> list = new ArrayList<Criterion>();
		list.add(new Criterion("Maximum Bug"));
		list.add(new Criterion("Best OOP"));
		list.add(new Criterion("Creative"));
		list.add(new Criterion("Best Graphic"));
		list.add(new Criterion("User Friendly"));
		return list;
	}

}
