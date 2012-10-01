package com.github.ant2.exceedvote;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * eXceed Vote Main Class
 * 
 * @author dtinth
 */
public class ExceedVoteMain {

	private static Logger logger = Logger.getLogger(ExceedVoteMain.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
	}

	private static Calendar minutesFromNow(int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minutes);
		return calendar;
	}

	private static void test() {

		Voter v = new Voter();
		
		VotingSession session = new VotingSession();
		session.setStartTime(minutesFromNow(0));
		session.setFinishTime(minutesFromNow(3));
		session.setAnnouncementTime(minutesFromNow(10));

		int allowedBallots = v.getAllowedBallots();
		logger.info("Allowed ballots " + allowedBallots);

		VoterProfile profile = v.getProfile();
		BallotBox box = session.getBallotBox();

		System.out.println("Hello, " + profile);

		int remainingTime = session.getRemainingTime();
		System.out.printf("We have %d : %d left\n", remainingTime / 60,
				remainingTime % 60);

		List<Project> projects = session.getProjects();
		List<Criterion> criteria = session.getCriteria();

		System.out.println("Projects:");
		for (Project project : projects) {
			System.out.println("- " + project);
		}

		System.out.println("Criteria:");
		for (Criterion criterion : criteria) {
			System.out.println("- " + criterion);
		}

		for (int i = 0; i < 5; i++) {
			// user selects a project
			Project selectedProject = projects.get(i);
			Criterion selectedCriteria = criteria.get(i / 2);

			// use that information to create a ballot
			Ballot b = new Ballot(v, selectedProject, selectedCriteria);
			session.submit(b);

		}

		// display the ballots
		System.out.println("Used Ballots:");
		for (Ballot ballot : session.getBallotBox().getVoterBallots(v)) {
			System.out.println("- " + ballot);
		}

	}

}
